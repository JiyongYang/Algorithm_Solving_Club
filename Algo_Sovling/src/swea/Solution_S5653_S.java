package swea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_S5653_S {
	static class Pos{
		int y;
		int x;
		public Pos(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			Pos other = (Pos) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
	}
	static class StemCell{
		// 0 inactive  1 active  2 done
		int state;
		int vitality;
		int curVital;
		int y;
		int x;
		public StemCell(int y, int x, int state, int vitality) {
			super();
			this.y = y;
			this.x = x;
			this.state = state;
			this.vitality = vitality;
			this.curVital = vitality;
		}
		public StemCell(int y, int x, int state, int vitality, int cv) {
			this(y, x, state, vitality);
			this.curVital = cv;
		}
		@Override
		public String toString() {
			return "StemCell [S:" + state + ", V:" + vitality + ", CV:" + curVital + ", (" + y
					+ ", " + x + ")]";
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int N = 0, M = 0, K = 0;
	static StemCell[][] map = null;
	static ArrayList<StemCell> list = null;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new StemCell[350][350];
			list = new ArrayList<>();
			for (int y = 0; y < N; y++) {
				st = new StringTokenizer(br.readLine());
				for (int x = 0; x < M; x++) {
					int vital = Integer.parseInt(st.nextToken());
					if(vital == 0) continue;
					map[y+150][x+150] = new StemCell(y+150, x+150, 0, vital);
					list.add(new StemCell(y+150, x+150, 0, vital));
				}
			}
			
			cultivate();
			
			bw.write("#"+t+" "+list.size()+"\n");
			bw.flush();
		}
		br.close();
		bw.close();
	}
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	public static void cultivate() {
		HashMap<Pos, StemCell> hm = new HashMap<>();
		for (int i = 0; i < K; i++) {
			for (StemCell st : list) {
				st.curVital--;
				if(st.state == 0 && st.curVital == 0) {
					st.state = 1;
					st.curVital = st.vitality;
					map[st.y][st.x] = st;
					hm.put(new Pos(st.y, st.x), st);
					continue;
				}
				
				if(st.state == 1 && st.curVital == st.vitality-1) {
					for (int k = 0; k < 4; k++) {
						int ny = st.y + dy[k];
						int nx = st.x + dx[k];
						StemCell temp = null;
						// 빈 경우
						if(map[ny][nx] == null) {
							temp = new StemCell(ny, nx, 0, st.vitality, st.vitality);
							map[ny][nx] = temp;
							hm.put(new Pos(ny, nx), temp);
						}
						// 이미 차 있는 경우 + inactive + cur == vital인 경우
						else if(map[ny][nx] != null && 
								map[ny][nx].state == 0 && 
								map[ny][nx].vitality == map[ny][nx].curVital) {
							if(map[ny][nx].vitality < st.vitality) {
								temp = new StemCell(ny, nx, 0, st.vitality, st.vitality);
								map[ny][nx] = temp;
								hm.put(new Pos(ny, nx), temp);
							}
						}
					}
				}
				
				if(st.state == 1 && st.curVital == 0) {
					st.state = 2;
					map[st.y][st.x] = new StemCell(st.y, st.x, 2, st.vitality);
					continue;
				}
				map[st.y][st.x] = st;
				hm.put(new Pos(st.y, st.x), st);
			}// end list for
			list.clear();
			Set<Pos> keys = hm.keySet();
			for (Pos k : keys) list.add(hm.get(k));
			hm.clear();
		} // end K
	} 
}
