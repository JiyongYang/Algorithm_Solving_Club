package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B10844_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int cnt = 0;
	static final long MOD = 1000000000;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		long[][] nums = new long[101][10];
		
		for (int i = 1; i < 10; i++) {
			nums[1][i] = 1L;
		}
		
		for (int i = 2; i <= N; i++) {
			for (int j = 0; j <= 9; j++) {
				if(j == 0) nums[i][j] += nums[i-1][j+1];
				else if(j == 9) nums[i][j] += nums[i-1][j-1];
				else {
					nums[i][j] += nums[i-1][j-1]+nums[i-1][j+1];
				}
				nums[i][j] %= MOD;
			}
		}
		long sum = 0;
		for (int i = 0; i <= 9; i++) {
			sum+=nums[N][i];
		}
		bw.write(sum%MOD+"\n");
		
//		for (int i = 1; i <= 9; i++) {
//			dp(i, 0, N-1);
//		}
//		bw.write(cnt+"\n");
		
		bw.close();
		br.close();
	}
	
	public static void dp(int n, int depth, int len) {
		if(depth == len) {
			cnt++;
			return;
		}
		else {
			if(n == 0) dp(1, depth+1, len);
			else if(n==9) dp(8, depth+1, len);
			else {
				dp(n-1, depth+1, len);
				dp(n+1, depth+1, len);
			}
		}
	}
}
