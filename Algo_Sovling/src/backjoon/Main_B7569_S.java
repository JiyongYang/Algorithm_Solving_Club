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

public class Main_B7569_S {
	static class Pos{
		int y;
		int x;
		int z;
		int time;
		public Pos(int z, int y, int x, int time) {
			this(z, y, x);
			this.time = time;
		}
		public Pos(int z, int y, int x) {
			this.y = y;
			this.x = x;
			this.z = z;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int M = 0, N = 0, H = 0, maxCnt = 0, cnt = 0, maxTime = 0;
	static int[][][] map = null;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][N][M];
		ArrayList<Pos> startList = new ArrayList<>();
		
		for (int h = 0; h < H; h++) {
			for (int y = 0; y < N; y++) {
				st = new StringTokenizer(br.readLine());
				for (int x = 0; x < M; x++) {
					map[h][y][x] = Integer.parseInt(st.nextToken());
					if(map[h][y][x] == 1) startList.add(new Pos(h, y, x));
					if(map[h][y][x] == 0) maxCnt++;
				}
			}
		}
		
		bfs(startList);
		if(maxCnt != cnt) bw.write(-1+"");
		else bw.write(maxTime+"");
		
		br.close();
		bw.close();
	}
	
	static void print(boolean[][][] innerCheck) throws IOException {
		for (int h = 0; h < H; h++) {
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < M; x++) {
					if(innerCheck[h][y][x])	bw.write("# ");
					else bw.write("0 ");
				}
				bw.write("\n");
			}
		}
		bw.write("\n");
		bw.flush();
	}
	
	static int[] dx = {1, -1, 0, 0, 0, 0};
	static int[] dy = {0, 0, 1, -1, 0, 0};
	static int[] dh = {0, 0, 0, 0, 1, -1};
	public static void bfs(ArrayList<Pos> startList) throws IOException {
		boolean[][][] innerCheck = new boolean[H][N][M];
		Queue<Pos> q = new LinkedList<>();
		for (Pos start : startList) {
			innerCheck[start.z][start.y][start.x] = true;
			q.add(new Pos(start.z, start.y, start.x, 0));
		}
		while(!q.isEmpty()) {
			Pos base = q.poll();
			for (int k = 0; k < 6; k++) {
				int ny = base.y + dy[k];
				int nx = base.x + dx[k];
				int nz = base.z + dh[k];
				
				if(ny >= N || ny < 0 || nx >= M || nx < 0 || nz >= H || nz < 0) continue;
				if(map[nz][ny][nx] != 0 || innerCheck[nz][ny][nx]) continue;
				cnt++;
				if(maxTime < base.time+1) maxTime = base.time+1;
				innerCheck[nz][ny][nx] = true;
				q.add(new Pos(nz, ny, nx, base.time+1));
			}
//			print(innerCheck);
		}
	}
	
}
