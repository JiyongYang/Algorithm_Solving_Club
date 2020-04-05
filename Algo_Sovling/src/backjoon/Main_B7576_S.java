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

public class Main_B7576_S {
	static class Pos{
		int y;
		int x;
		int time;
		public Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
		public Pos(int y, int x, int time) {
			this(y,x);
			this.time = time;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int W = 0, H = 0, maxCnt = 0, cnt = 0, maxTime = 0;
	static int[][] map = null;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		ArrayList<Pos> startList = new ArrayList<>();
		
		for (int y = 0; y < H; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < W; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
				if(map[y][x] == 0) maxCnt++;
				if(map[y][x] == 1) startList.add(new Pos(y, x));
			}
		}
		
		bfs2(startList);
		
		if(maxCnt != cnt) bw.write(-1+"");
		else bw.write(maxTime+"");
		
		br.close();
		bw.close();
	}
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	public static void bfs2(ArrayList<Pos> startList) {
		boolean[][] innerCheck = new boolean[H][W];
		Queue<Pos> q = new LinkedList<>();
		for (Pos start : startList) {
			innerCheck[start.y][start.x] = true;
			q.add(new Pos(start.y, start.x, 0));
		}
		while(!q.isEmpty()) {
			Pos base = q.poll();
			for (int k = 0; k < 4; k++) {
				int ny = base.y + dy[k];
				int nx = base.x + dx[k];
				
				if(ny >= H || ny < 0 || nx >= W || nx < 0) continue;
				if(map[ny][nx] != 0 || innerCheck[ny][nx]) continue;
				cnt++;
				if(maxTime < base.time+1) maxTime = base.time+1;
				innerCheck[ny][nx] = true;
				q.add(new Pos(ny, nx, base.time+1));
			}
		}
	}
	
}
