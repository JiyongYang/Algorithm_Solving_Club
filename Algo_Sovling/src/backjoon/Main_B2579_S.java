package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_B2579_S {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int maxSum = 0;
	
	public static void main(String[] args) throws IOException{
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N+1];
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		int[][] cumul = new int[N+1][3];
		
		cumul[N][1] = nums[N];
		cumul[N][2] = nums[N];
		
		for (int i = N-1; i >= 0; i--) {
			if(i+1 <= N) cumul[i][1] = cumul[i+1][2] + nums[i];
			if(i+2 <= N) cumul[i][2] = Math.max(cumul[i+2][1], cumul[i+2][2]) + nums[i];
		}
		if(N >= 3) {
			int tempMaxA = Math.max(cumul[1][1], cumul[1][2]);
			int tempMaxB = Math.max(cumul[2][1], cumul[2][2]);
			bw.write(Math.max(tempMaxB, tempMaxA)+"");
		} else {
			bw.write(Math.max(cumul[1][1], cumul[1][2])+"");
		}
		
		// dfs(nums, N, false, 0);
		
		br.close();
		bw.close();
	}
	
	// 시간 초과하는 방법. depth 깊을 수록 기하 급수적으로 dfs를 수행하는게 많아짐
	public static void dfs(int[] nums, int pos, boolean inARow, int sum) {
		if(pos <= 0) {
			if(maxSum < sum) maxSum = sum;
			return;
		}
		
		if(inARow) {
			System.out.println("["+(pos)+"] >> "+ (pos-2) +"  "+(sum+nums[pos]));
			dfs(nums, pos-2, false, sum + nums[pos]);
		}else {
			System.out.println("["+(pos)+"] >> "+ (pos-1) +"  "+(sum+nums[pos]));
			dfs(nums, pos-1, true, sum + nums[pos]);
			System.out.println("["+(pos)+"] >> "+ (pos-2) +"  "+(sum+nums[pos]));
			dfs(nums, pos-2, false, sum + nums[pos]);
		}
	}
}
