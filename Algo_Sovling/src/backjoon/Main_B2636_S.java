package backjoon;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_B2636_S {
	static class Pos{
		int y;
		int x;
		public Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	static int[][] map = null;
	static int cnt = 0;
	static int H, W;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		H = sc.nextInt();
		W = sc.nextInt();
		map = new int[H][W];
		
		for (int y = 0; y < H; y++) {
			for (int x = 0; x < W; x++) {
				map[y][x] = sc.nextInt();
				if(map[y][x] == 1) cnt++;
			}
		}
		int step = 0;
		int ans = 0;
		while(cnt > 0) {
			ans = cnt;
			step++;
			boolean[][] check = new boolean[H][W];
			bfs(check);
		}
		System.out.println(step);
		System.out.println(ans);
	}
	
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void bfs(boolean[][] check) {
		check[0][0] = true;
		Queue<Pos> q = new LinkedList<Main_B2636_S.Pos>();
		q.add(new Pos(0, 0));
		
		while(!q.isEmpty()) {
			Pos tp = q.poll();
			
			for (int k = 0; k < 4; k++) {
				int ny = tp.y + dy[k];
				int nx = tp.x + dx[k];
				
				if(ny >= H || ny < 0 || nx >= W || nx < 0) continue;
				
				if(check[ny][nx]) continue;
				check[ny][nx] = true;
				if(map[ny][nx] == 0) {
					q.add(new Pos(ny, nx));
				}
			}
		}
		
		for (int y = 0; y < H; y++) {
			for (int x = 0; x < W; x++) {
				if(check[y][x] && map[y][x]==1) {
					map[y][x] = 0;
					cnt--;
				}
			}
		}
	}
}
