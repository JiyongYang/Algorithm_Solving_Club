package swea;
import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution_S7396_S {
	static class Word implements Comparable<Word>{
		Character c;
		int d;
		int y;
		int x;
		public Word(Character c, int d, int y, int x) {
			this.c = c;
			this.d = d;
			this.y = y;
			this.x = x;
		}

		@Override
		public String toString() {
			return "Word [c=" + c + ", d=" + d + "]";
		}
		@Override
		public int compareTo(Word o) {
			return d == o.d? c.compareTo(o.c) : d-o.d;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((c == null) ? 0 : c.hashCode());
			result = prime * result + d;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Word other = (Word) obj;
			if (c == null) {
				if (other.c != null)
					return false;
			} else if (!c.equals(other.c))
				return false;
			if (d != other.d)
				return false;
			return true;
		}
	}
	
	static int N, M;
	static char[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new char[N][M];
			for (int y = 0; y < N; y++) {
				String s = sc.next();
				for (int x = 0; x < M; x++) {
					map[y][x] = s.charAt(x);
				}
			}
			
			StringBuilder sb = bfs();
			
			System.out.println("#"+t+" "+sb.toString());
		}
	}
	
	static int[] dx = {1, 0};
	static int[] dy = {0, 1};
	
	public static StringBuilder bfs() {
		StringBuilder sb = new StringBuilder();
		boolean[][] check = new boolean[N][M];
		check[0][0] = true;
		PriorityQueue<Word> pq = new PriorityQueue<>();
//		TreeSet<Word> ts = new TreeSet<>();
//		ts.add(new Word(map[0][0], 0, 0, 0));
		int dist = 0;
		Word pre = new Word(map[0][0], dist, 0, 0);
		pq.add(pre);
		sb.append(pre.c);
		while(!pq.isEmpty()) {
			Word w = pq.poll();
			if(w.d != dist) {
				// 새로운 dist 거리에 첫 객체 등장
				pre = w;
				sb.append(w.c);
			}
			dist = w.d;
			if(!w.equals(pre)) continue;
//			if(dist != w.d) continue;
//			pre = w;
			for (int k = 0; k < 2; k++) {
				int ny = w.y + dy[k];
				int nx = w.x + dx[k];
				if(ny >= N || nx >= M) continue;
				if(check[ny][nx]) continue;
				check[ny][nx] = true;
				pq.add(new Word(map[ny][nx], dist+1, ny, nx));
			}
		}
		return sb;
	}
}
