package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B16234_S {
	static class Pos{
		int y;
		int x;
		public Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
		@Override
		public String toString() {
			return "[" + y + ", " + x + "]";
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int N = 0, L = 0, R = 0;
	static int[][] map = null;
	static boolean flg = false;
	static ArrayList<Pos> slist = null;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		slist = new ArrayList<>();
		
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		int tC = 0;
		while(true) {
			slist.clear();
			boolean[][] c = check();
			printCheck(c);
			if(!flg) break;
			bfs(c);
			tC++;
			printMap();
			System.in.read();
			System.in.read();
		}
		bw.write(tC+"");
		
		
		br.close();
		bw.close();
	}
	
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void printMap() {
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				System.out.print(map[y][x]+" ");
			}
			System.out.println();
		}
	}
	
	public static void printCheck(boolean[][] check) {
		for (int y = 0; y < N+N-1; y++) {
			for (int x = 0; x < N+N-1; x++) {
				if(check[y][x]) System.out.print("1 ");
				else System.out.print("0 ");
			}
			System.out.println();
		}
	}
	
	public static boolean[][] check() {
		boolean[][] check = new boolean[N+N-1][N+N-1];
		flg = false;
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				// 가로  아래 확인
				for (int k = 0; k < 2; k++) {
					int ny = y + dy[k];
					int nx = x + dx[k];
					
					if(ny >= N || nx >= N) continue;
					
					int dist = Math.abs(map[y][x]-map[ny][nx]);
					
					if(dist < L || dist > R) continue;
					
					slist.add(new Pos(y*2, x*2));
					flg = true;
					for (int q = 0; q < 3; q++) {
						if(k == 0) check[y*2][x*2+q] = true;
						if(k == 1) check[y*2+q][x*2] = true;
					}
				}
			}
		}
		return check;
	}
	
	public static void bfs(boolean[][] possibleCheck) {
		boolean[][] bfsCheck = new boolean[N+N-1][N+N-1];
		for (Pos start : slist) {
			if(bfsCheck[start.y][start.x]) continue;
			
			int sum = map[(start.y)/2][(start.x)/2];
			int cnt = 1;
			Queue<Pos> q = new LinkedList<>();
			ArrayList<Pos> list = new ArrayList<>();
			q.add(start);
			bfsCheck[start.y][start.x] = true;
			list.add(new Pos((start.y)/2, (start.x)/2));
			
//			System.out.println("S:"+start+" "+sum+" "+cnt+" ");
			while(!q.isEmpty()) {
				Pos t = q.poll();
				for (int k = 0; k < 4; k++) {
					int ny = t.y + dy[k];
					int nx = t.x + dx[k];
					
					if(ny >= N+N-1 || ny < 0 || nx >= N+N-1 || nx < 0) continue;
					if(bfsCheck[ny][nx] || !possibleCheck[ny][nx]) continue;
					
					bfsCheck[ny][nx] = true;
					if(ny%2==0 && nx%2==0) {
//						System.out.println(ny/2+" "+nx/2+" :: "+map[ny/2][nx/2]);
						list.add(new Pos(ny/2, nx/2));
						sum+=map[ny/2][nx/2];
						cnt++;
					}
					q.add(new Pos(ny, nx));
				}
			}
//			System.out.println(sum+" "+cnt+" "+sum/cnt);
			for (Pos pos : list) {
				map[pos.y][pos.x] = sum/cnt;
			}
		}
	}
}
