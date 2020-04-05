package test.mocktest_190827;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_Q1 {
	static class Paint{
		int sy;
		int sx;
		int ey;
		int ex;
		int gs;
		public Paint(int sy, int sx, int ey, int ex, int gs) {
			super();
			this.sy = sy;
			this.sx = sx;
			this.ey = ey;
			this.ex = ex;
			this.gs = gs;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int N = 0, M = 0, K = 0;
	static Paint[] pList = null;
	static int[][] map = null;
	static int[] gsCnt = null;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			gsCnt = new int[11];
			pList = new Paint[K];
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int sy = Integer.parseInt(st.nextToken());
				int sx = Integer.parseInt(st.nextToken());
				int ey = Integer.parseInt(st.nextToken());
				int ex = Integer.parseInt(st.nextToken());
				int gs = Integer.parseInt(st.nextToken());
				pList[i] = new Paint(sy, sx, ey, ex, gs);
			}
			painting();
			bw.write("#"+t+" "+counter()+"\n");
		}
		
		bw.close();
		br.close();
	}
	
	public static void painting() {
		for (int i = 0; i < K; i++) {
			Paint pt = pList[i];
			// checking for proper space
			boolean flg = false;
			for (int y = pt.sy; y <= pt.ey; y++) {
				for (int x = pt.sx; x <= pt.ex; x++) {
					if(map[y][x] > pt.gs) {
						flg = true;
						break;
					}
				}
			}
			if(flg) continue;
			for (int y = pt.sy; y <= pt.ey; y++) {
				for (int x = pt.sx; x <= pt.ex; x++) {
					map[y][x] = pt.gs;
				}
			}
		}
	}
	
	public static int counter() {
		int result = 0;
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				gsCnt[map[y][x]]++;
			}
		}
		
		for (int i = 0; i < gsCnt.length; i++) {
			if(result < gsCnt[i]) result = gsCnt[i];
		}
		
		return result;
	}
}
