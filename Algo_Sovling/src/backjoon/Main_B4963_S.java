package backjoon;
import java.util.*;
import java.io.*;

public class Main_B4963_S {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(true) {
			int w = sc.nextInt();
			int h = sc.nextInt();
			
			if(w == 0 && h == 0) break;
			
			int[][] map = new int[h][w];
			if(h == 1 && w == 1) {
				int r = sc.nextInt();
				if(r == 0) System.out.println(0);
				else System.out.println(1);
				continue;
			}
			for (int y = 0; y < h; y++) {
				for (int x = 0; x < w; x++) {
					map[y][x] = sc.nextInt();
				}
			}
			
			System.out.println(bfs(map, h, w));
			
		}
	}
	
	static class Pos{
		int y;
		int x;
		public Pos(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		@Override
		public String toString() {
			return "Pos [y=" + y + ", x=" + x + "]";
		}
	}
	
	static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
	static int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
	public static int bfs(int[][] map, int h, int w) {
		int cnt = 0;
		boolean[][] check = new boolean[h][w];
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				if(map[y][x] == 0 || check[y][x]) continue;
				cnt++;
				Queue<Pos> q = new LinkedList<>();
				check[y][x] = true;
				q.add(new Pos(y, x));
				while(!q.isEmpty()) {
					Pos b = q.poll();
					for (int k = 0; k < 8; k++) {
						int ny = b.y + dy[k];
						int nx = b.x + dx[k];
						
						if(ny >= h || ny < 0 || nx >= w || nx < 0 || check[ny][nx] || map[ny][nx] == 0) continue;
						
						check[ny][nx] = true;
						q.add(new Pos(ny, nx));
					}
				}
				
			}
		}
		
		return cnt;
	}
}
