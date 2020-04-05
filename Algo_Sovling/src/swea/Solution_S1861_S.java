package swea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_S1861_S {
	static class Pos implements Comparable<Pos>{
		int sIdx;
		int cnt;
		public Pos(int sIdx, int cnt) {
			super();
			this.sIdx = sIdx;
			this.cnt = cnt;
		}
		@Override
		public int compareTo(Pos o) {
			return (cnt - o.cnt) == 0 ? sIdx - o.sIdx : o.cnt - cnt;
		}
		@Override
		public String toString() {
			return sIdx + " " + cnt;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int N = 0;
	static int[][] map = null;
	static ArrayList<Pos> list = null;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			map = new int[N][N];
			for (int y = 0; y < N; y++) {
				st = new StringTokenizer(br.readLine());
				for (int x = 0; x < N; x++) {
					map[y][x] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					find(y, x);
				}
			}
			Collections.sort(list);
//			bw.write(list.toString());
			
			bw.write("#"+t+" "+list.get(0)+"\n");
		}
		
		br.close();
		bw.close();
	}
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	public static void find(int y, int x) {
		int cnt = 1;
		int baseVal = map[y][x];
		boolean gFlg = false;
		while(true) {
			boolean flg = false;
			for (int k = 0; k < 4; k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];
				if(ny >= N || ny < 0 || nx >= N || nx < 0) continue;
				if(map[ny][nx] == map[y][x]+1) {
					y = ny;
					x = nx;
					gFlg = true;
					flg = true;
					break;
				}
			}
			if(flg)	cnt++;
			else break;
		}
		if(gFlg) list.add(new Pos(baseVal, cnt));
	}
}
