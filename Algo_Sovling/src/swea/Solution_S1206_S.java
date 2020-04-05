package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_S1206_S {
	static int[] dx = {-2, -1, 1, 2};
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String _in = "";
				
		
		for (int t = 1; t <= 10; t++) {	
			try {
				_in = br.readLine();
			} catch (IOException e) {
				System.out.println("IOError");
			}
			
			int N = Integer.parseInt(_in);
			
			int[] nums = new int[N];
			int cnt = 0;
			
			try {
				_in = br.readLine();
				st = new StringTokenizer(_in);
			} catch (IOException e) {
				System.out.println("IOError");
			}
			
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 2; i < nums.length-2; i++) {
				// 특정 위치를 기준으로 양 옆으로 거리가 2인 칸들보다 다 높은 경우
				if(nums[i] > nums[i-1] && nums[i] > nums[i-2]
						&& nums[i] > nums[i+1] && nums[i] > nums[i+2]) {
					int maxV = 0;
					for(int dt : dx) {
						if(maxV < nums[i+dt]) maxV = nums[i+dt];
					}
					int dist = Math.abs(nums[i] - maxV);
					cnt+=dist;
				}
			}
			System.out.println("#"+t+" "+cnt);
		}
	}
}
