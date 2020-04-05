package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_B1012_S {
	static class Pos{
		int y;
		int x;
		public Pos(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int W = 0, H = 0, K = 0;
	static int[][] map = null;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x] = 1;
			}
			boolean[][] check = new boolean[H][W];
			int cnt = 0;
			for (int y = 0; y < H; y++) {
				for (int x = 0; x < W; x++) {
					if(map[y][x] == 1 && !check[y][x]) {
						bfs(y, x, check);
						cnt++;
					}
				}
			}
			bw.write(cnt+"\n");
		}
		
		
		br.close();
		bw.close();
	}
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	public static void bfs(int y, int x, boolean[][] check) {
		Queue<Pos> q = new LinkedList<>();
		check[y][x] = true;
		q.add(new Pos(y, x));
		while(!q.isEmpty()) {
			Pos base = q.poll();
			for (int k = 0; k < 4; k++) {
				int ny = base.y + dy[k];
				int nx = base.x + dx[k];
				
				if(ny >= H || ny < 0 || nx >= W || nx < 0) continue;
				if(map[ny][nx] == 0 || check[ny][nx]) continue;
				check[ny][nx] = true;
				q.add(new Pos(ny, nx));
			}
		}
	}
}
