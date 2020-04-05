package jungol;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_J1462_S {
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
	static int L = 0;
	static int W = 0;
	static int[][] map;
	static int maxDist = -1;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new int[L][W];
		for (int i = 0; i < L; i++) {
			String in = br.readLine();
			for (int j = 0; j < W; j++) {
				if(in.charAt(j) == 'W') map[i][j] = 0;
				else map[i][j] = 1;
			}
		}
		
		for (int i = 0; i < L; i++) {
			for (int j = 0; j < W; j++) {
				if(map[i][j] == 1) bfs(i, j);
			}
		}
		bw.write(maxDist+"");
		
		
		br.close();
		bw.close();
	}

	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, 1, 0, -1};
	
	public static void bfs(int y, int x) throws IOException {
		Queue<Point> q = new LinkedList<>();
		ArrayList<Point> cp = new ArrayList<>();
		boolean[][] check = new boolean[L][W];
		int dist = 0;
		int sMaxDist = 0;
		
		q.add(new Point(y, x, dist));
		check[y][x] = true;
		while(!q.isEmpty()) {
			Point np = q.poll();
			dist = np.dist+1;
			for (int k = 0; k < 4; k++) {
				int ny = np.y + dy[k];
				int nx = np.x + dx[k];
				if(ny >= 0 && ny < L &&
				   nx >= 0 && nx < W) {
					if(check[ny][nx] == false && map[ny][nx] == 1) {
						check[ny][nx] = true;
						q.add(new Point(ny, nx, dist));
						if(dist > maxDist) maxDist = dist;
					}
				}
			}
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
