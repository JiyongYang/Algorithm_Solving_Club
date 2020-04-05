package swea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class Point1{
	int x;
	int y;
	int dist;
	Point1(int y, int x, int dist){
		this.y = y;
		this.x = x;
		this.dist = dist;
	}
	
}

public class Solution_S2805_s {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, -1, 0, 1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] map = new int[N][N];
			for (int j = 0; j < N; j++) {
				String in = br.readLine();
				for (int i = 0; i < N; i++) {
					map[j][i] = in.charAt(i) - '0';
				}
			}
			
			int result = bfs(map, N, 0);
			
			bw.write("#"+t+" "+result+"\n");
			bw.flush();
		}
		bw.close();
		br.close();
	}
	
	public static int bfs(int[][] map, int N, final int dist) throws IOException {
		int result = 0;
		boolean[][] visited = new boolean[N][N];
		Queue<Point1> queue = new LinkedList<>();
		
		Point1 startPoint = new Point1(N/2, N/2, 0);
		visited[N/2][N/2] = true;
		queue.offer(startPoint);
		result += map[startPoint.y][startPoint.x];
		while(!queue.isEmpty()) {
			Point1 v = queue.poll();
			if(v.dist >= (N/2)) {
				continue;
			}
			for (int k = 0; k < 4; k++) {
				int nx = v.x + dx[k];
				int ny = v.y + dy[k];
				Point1 np = new Point1(ny, nx, v.dist+1);
				if(!visited[ny][nx]) {
					visited[ny][nx] = true;
					result += map[ny][nx];
					queue.offer(np);
				}
			}
		}
		
		return result;
	}
}
