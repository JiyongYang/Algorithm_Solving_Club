package swea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_S2382_S {
	static class Pos{
		int y;
		int x;
		Pos(int y, int x){
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
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pos other = (Pos) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
		
	}
	
	static class SSet{
		int y;
		int x;
		int cnt;
		int dir;
		SSet(int y, int x, int cnt, int dir){
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.dir = dir;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			String s = "";
			if(dir==1) s = "U";
			if(dir==2) s = "D";
			if(dir==3) s = "L";
			if(dir==4) s = "R";
			return "(" + y + ", " + x + ") " + cnt + " " + s + "";
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int[] dx = {0, 0, 0, -1, 1};
	static int[] dy = {0, -1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			for (int offset = 0; offset < map.length; offset++) {
				map[offset][0] = -1;
				map[offset][N-1] = -1;
				map[0][offset] = -1;
				map[N-1][offset] = -1;
			}
			
			ArrayList<SSet> list = new ArrayList<>();
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				list.add(new SSet(Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()), 
						Integer.parseInt(st.nextToken()), 
						Integer.parseInt(st.nextToken())));
			}
			
			bw.write("#"+t+" "+run(list, N, M, map)+"\n");
			bw.flush();
		}
		br.close();
		bw.close();
	}
	
	// 1 상, 2 하, 3 좌, 4 우
	public static int run(ArrayList<SSet> list, int N, int M, int[][] map) {
		Map<Pos, ArrayList<SSet>> hm = new HashMap<>();
		for (int i = 0; i < M; i++) {
			// 각 미생물의 위치 업데이트와 약품 구역에 들어가는 얘들 처리
			// 업데이트된 얘들을 hm에 넣어주기
			for (int k = 0; k < list.size(); k++) {
				SSet temp = list.get(k);
				int ny = temp.y+dy[temp.dir];
				int nx = temp.x+dx[temp.dir];
				temp.y = ny;
				temp.x = nx;
				if(ny == 0 || ny == N-1 || nx == 0 || nx == N-1) {
					if(temp.dir%2==1) temp.dir = (temp.dir+6)%5;
					else temp.dir = (temp.dir+4)%5;
					temp.cnt/=2;
				}
				Pos nPos = new Pos(ny, nx);
				if(hm.containsKey(nPos)) hm.get(nPos).add(temp);
				else {
					ArrayList<SSet> tList = new ArrayList<>();
					tList.add(temp);
					hm.put(nPos, tList);
				}
			}
			// list에 있는 내용 비워주기(이후 업데이트 된 얘들로 채워주기)
			list.clear();
			// 같은 위치에 있는 얘들 하나로 합치는 과정
			Set<Pos> keys = hm.keySet();
			for (Pos key : keys) {
				ArrayList<SSet> tList = hm.get(key);
				if(tList.size() == 1) {
					// 해당 위치에 하나만 존재하는 경우
					list.add(tList.get(0));
				} else {
					// 여러개가 존재하는 경우
					int sum = tList.get(0).cnt;
					SSet maxSet = tList.get(0);
					for (int p = 1; p < tList.size(); p++) {
						sum+=tList.get(p).cnt;
						if(tList.get(p).cnt > maxSet.cnt) maxSet = tList.get(p);
					}
					maxSet.cnt = sum;
					list.add(maxSet);
				}
			}
			
			// 모든 처리가 끝난 후 hashmap 초기화
			hm.clear();
		}
		int result = 0;
		for (int i = 0; i < list.size(); i++) {
			result+=list.get(i).cnt;
//			System.out.println(list.get(i));
		}
		
		return result;
	}
}
