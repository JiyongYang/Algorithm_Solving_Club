package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_B1890_S {
	static class Pos implements Comparable<Pos>{
		int y;
		int x;
		public Pos(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		@Override
		public int compareTo(Pos o) {
			return (y+x) - (o.y+o.x);
		}
		@Override
		public String toString() {
			return "Pos [y=" + y + ", x=" + x + "]";
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int[][] map = null;
	static int[] dx = {1, 0};
	static int[] dy = {0, 1};
	static int N = 0;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		bw.write(dp()+"");
		
		br.close();
		bw.close();
	}
	
	public static long dp() {
		PriorityQueue<Pos> pq = new PriorityQueue<>(/*new Comparator<Pos>() {
			@Override
			public int compare(Pos o1, Pos o2) {
				return (o1.x+o1.y)-(o2.x+o2.y);
			}
			
		}*/);
		long[][] cumul = new long[N][N];
		cumul[0][0] = 1;
		pq.add(new Pos(0, 0));
		while(!pq.isEmpty()) {
			Pos t = pq.poll();
			int base = map[t.y][t.x];
			for (int k = 0; k < 2; k++) {
				int ny = t.y + dy[k]*base;
				int nx = t.x + dx[k]*base;
				
				if(ny >= N || nx < 0 || nx >= N || nx < 0) continue;
				
				if(cumul[ny][nx] == 0 && !(ny == N-1 && nx == N-1)) pq.add(new Pos(ny, nx));
				
				cumul[ny][nx] += cumul[t.y][t.x];
			}
		}
		return cumul[N-1][N-1];
	}
	
	public static void print(long[][] arr) {
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				System.out.print(arr[y][x]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
