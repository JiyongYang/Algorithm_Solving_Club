package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_B2638_S {
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
	static int[][] map = null;
	static int total = 0;
	
	public static void main(String[] args) throws IOException {
		
		
		int N = 0, M = 0;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < M; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				if(map[y][x] == 1) total++;
			}
		}
		int count = 0;
		while(total != 0) {
			run(N, M);
			count++;
		}
		
//		for (int y = 0; y < N; y++) {
//			for (int x = 0; x < M; x++) {
//				bw.write(map[y][x]+" ");
//			}
//			bw.write("\n");
//		}
		
		bw.write(count+"");
		bw.close();
		br.close();
	}
	
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void run(int N, int M) {
		Queue<Pos> q = new LinkedList<>();
		
		int[][] check = new int[N][M];
		
		q.add(new Pos(0,0));
		
		while(!q.isEmpty()) {
			
			Pos temp = q.poll();
			
			for (int k = 0; k < 4; k++) {
				int nx = temp.x + dx[k];
				int ny = temp.y + dy[k];
				
				if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
				
				if(map[ny][nx] == 1 && check[ny][nx] > 1) continue;
				if(map[ny][nx] == 0 && check[ny][nx] == 1) continue;
				
				check[ny][nx]++;
				
				if(map[ny][nx] == 0) {
					q.add(new Pos(ny, nx));
				}
			}
		}
		
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if(map[y][x] == 1 && check[y][x] >= 2) {
					map[y][x] = 0;
					total--;
				}
			}
		}
	}
}
