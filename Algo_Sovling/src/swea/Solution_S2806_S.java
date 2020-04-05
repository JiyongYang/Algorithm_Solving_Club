package swea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_S2806_S {
	static class Node{
		int x;
		int y;
		Node parent;
		Node(int y, int x){
			this.x = x;
			this.y = y;
		}
		Node(int y, int x, Node parent){
			this.x = x;
			this.y = y;
			this.parent = parent;
		}
		@Override
		public String toString() {
			return "[" + x + ", " + y + "]";
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;

	static int N = 0;
	static int[][] map = null;
	static int cnt = 0;
	static int cntBt = 0;
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			cnt = 0;
			N = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < N; i++) {
				map = new int[N][N];
				backtrack(new Node(0, i, null));
			}
			bw.write("#"+t+" "+cnt+"\n");
		}
		br.close();
		bw.close();
	}
	
	public static void backtrack(Node v) throws IOException {
		if(isPromising(v)) {
			// 종료 조건
			if(v.y == N-1) {
				cnt++;
//				for (Node i = v; v != null; v = v.parent) {
//					System.out.print(i+" ");
//				}
				return;
			}
			// backtrack 조건
			map[v.y][v.x] = 1;
			for (int i = 0; i < N; i++) {
				if(i == v.x) continue;
				backtrack(new Node(v.y+1, i, v));
			}
			map[v.y][v.x] = 0;
		}
	}
	
	static int[] dx = {1, 0, -1, 0, 1, -1, -1, 1};
	static int[] dy = {0, 1, 0, -1, 1, 1, -1, -1};
	private static boolean isPromising(Node v) {
		cntBt++;
		for (int k = 0; k < 8; k++) {
			int baseX = v.x;
			int baseY = v.y;
			while(true) {
				int nx = baseX + dx[k];
				int ny = baseY + dy[k];
				if(ny >= 0 && ny < N && nx >= 0 && nx < N) {
					if(map[ny][nx] == 1) return false;
					baseX = nx;
					baseY = ny;
				}
				else break;
			}
		}
		return true;
	}
}
