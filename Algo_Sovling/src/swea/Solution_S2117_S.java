package swea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_S2117_S {
	static class House{
		int x;
		int y;
		House(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static ArrayList<House> hList = new ArrayList<>();
	static int[] costList = new int[50];
	static int maxSizeOfArea = 0;
	static int N = 0;
	static int M = 0;
	static int maxArea = 0;
	static int maxHouse = 0;

	public static void main(String[] args) throws IOException {
		for (int i = 0; i <= 49; i++) {
			costList[i] = i*i+(i+1)*(i+1);
		}
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			maxArea = 0;
			maxHouse = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int hCnt = 0;
			
			int val = 0;
			for (int y = 0; y < N; y++) {
				st = new StringTokenizer(br.readLine());
				for (int x = 0; x < N; x++) {
					val = Integer.parseInt(st.nextToken());
					if(val == 1) {
						hList.add(new House(y, x));
					}
				}
			}
			hCnt = hList.size();
			
			// 집 개수를 통해 최대로 덮었을 때 가능한 서비스 비용
			int maximalCostByHouses = hCnt * M;
			// 최대 가능한 서비스 비용에 따른 최대 구역 사이즈
			for (int i = 1; i <= costList.length ; i++) {
				if(costList[i]>maximalCostByHouses) {
					maxSizeOfArea = i-1;
					break;
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cal(i, j);
				}
			}
			
			bw.write("#"+t+" "+maxHouse+"\n");
			bw.flush();
			
			hList.clear();
		} // end for(t)
		
		
		br.close();
		bw.close();
	}
	
	public static void cal(int y, int x) {
		// 해당 위치와 집들 간의 거리 구하기
		int[] distList = new int[N*2+1];
		int[] cumul = new int[N*2+1];
		int[] cumulH = new int[N*2+1];
		
		for (House h : hList) {
			int dist = Math.abs(y - h.y) + Math.abs(x - h.x);
			distList[dist]+=1;
		}
		
		cumul[0] = distList[0] * M;
		cumulH[0] = distList[0];
		for (int i = 1; i <= maxSizeOfArea; i++) {
			cumul[i] = cumul[i-1] + distList[i]*M;
			cumulH[i] = cumulH[i-1]+ distList[i];
		}
		
		int mPos = 0;
		for (int i = 0; i <= maxSizeOfArea; i++) {
			// >=로 하는 것이 중요(손해를 보지 않는 다는 말은 이익을 보지 않는 다는 것과 같은 말)
			if(cumul[i] >= costList[i]) {
				mPos = i;
			}
		}
		
		if(maxArea < mPos || (maxArea == mPos && maxHouse < cumulH[mPos])) {
			maxArea = mPos;
			maxHouse = cumulH[mPos];
		}
	}
}
