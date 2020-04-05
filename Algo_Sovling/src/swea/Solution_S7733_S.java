package swea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution_S7733_S {
	static class Pos{
		int x;
		int y;
		Pos(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	
	static int N = 0;
	static int M = 0;
	static int[] p = null;
	static int[][] map = null;
//	static Edge[] edges = null;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int maxDay = 0;
	static int maxChunk = 0;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] > maxDay) maxDay = map[i][j];
				}
			}
			cheese();
			
			bw.write("#"+t+" "+maxChunk+"\n");
			maxChunk = 0;
		}
		
		br.close();
		bw.close();
	}
	
	public static void cheese() throws IOException {
		int cnt = 0;
		for (int day = 0; day <= maxDay; day++) {
			boolean[][] check = new boolean[N][N];
			cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] <= day || check[i][j]) continue;
					BFS(new Pos(i, j), day, check);
					cnt++;
				}
			}
			if(cnt > maxChunk) maxChunk = cnt;
			
		}
	}
	
	public static void BFS(Pos s, int day, boolean[][] check) throws IOException {
		Queue<Pos> q = new LinkedList<>();
		q.add(s);
		check[s.y][s.x] = true;
		while(!q.isEmpty()) {
			Pos t = q.poll();
			for (int k = 0; k < 4; k++) {
				int ny = t.y + dy[k];
				int nx = t.x + dx[k];
				
				if(ny >= N || ny < 0 || nx >= N || nx < 0) continue;
				if(check[ny][nx] || map[ny][nx] <= day) continue;
				check[ny][nx] = true;
				q.add(new Pos(ny, nx));
				
			}
		}
	}
	
	public static void print(boolean[][] check) throws IOException {
		for (int i = 0; i < check.length; i++) {
			for (int j = 0; j < check.length; j++) {
				if(check[i][j]) bw.write("1 ");
				else bw.write("0 ");
			}
			bw.write("\n");
		}
	}
	
	
	/*public static int cheeseChunk(int day) {
		int cnt = 0;
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if(map[y][x] <= day) continue;
				int pos = x+N*y;
				if(p[pos] == -1) {
					p[pos] = pos;
					continue;
				} else {
					int p = findSet(pos);
				}
			}
		}
		
		return cnt;
	}
	
	
	public static void makeSet() {
		for (int i = 0; i < N*N; i++) {
			p[i] = -1;
		}
	}
	
	public static int findSet(int x) {
		if(x == p[x]) return x;
		else {
			int r = findSet(p[x]);
			p[x] = r;
			return p[x];
		}
	}
	
	public static boolean unionSet(int y, int x) {
		int ty = y;
		y = findSet(y);
		x = findSet(x);
		if(y != x) {
			if(y > x) p[y] = x;
			else p[x] = y;
			findSet(ty);
			return true;
		}
		return false;
	}*/
	
}
