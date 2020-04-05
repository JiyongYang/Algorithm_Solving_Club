package jungol;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_J1106_S {
	static class Point{
		int x;
		int y;
		int dist;
		Point(int y, int x, int dist){
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int N = 0;
	static int M = 0;
	static int R = 0;
	static int C = 0;
	static int S = 0;
	static int K = 0;
	static int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
	static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		// 말
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		// 졸
		S = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		
		bfs();
		
		bw.close();
		br.close();
		
	}
	
	public static void bfs() throws IOException {
		boolean[][] check = new boolean[N+1][M+1];
		Queue<Point> q = new LinkedList<>();
		
		int dist = 0;
		q.add(new Point(R, C, dist));
		check[R][C] = true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			dist = p.dist + 1;
			for (int k = 0; k < 8; k++) {
				int ny = p.y+dy[k];
				int nx = p.x+dx[k];
				if(ny == S && nx == K) {
					bw.write(dist+"");
					return;
				}
				
				if(ny >= 1 && ny <= N &&
				   nx >= 1 && nx <= M) {
					if(check[ny][nx] == false) {
						Point np = new Point(ny, nx, dist);
						q.add(np);
						check[ny][nx] = true;
					}
				}
			}
			
//			print(check);
		}
	}
	
	public static void print(final boolean[][] check) throws IOException {
		for (int i = 0; i < check.length; i++) {
			for (int j = 0; j < check[i].length; j++) {
				if(check[i][j]) bw.write("■");
				else bw.write("□");
			}
			bw.write("\n");
		}
		bw.write("\n");
		bw.flush();
	}

}
