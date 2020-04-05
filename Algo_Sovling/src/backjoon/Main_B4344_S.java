package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B4344_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int[] nums = new int[N];
			int sum = 0;
			for (int i = 0; i < nums.length; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
				sum += nums[i];
			}
			double aver = sum/(double)N;
			int cnt = 0;
			for (int i = 0; i < nums.length; i++) {
				if(nums[i] > aver) cnt++;
			}
			double result = ((cnt/(double)N)*100.0);
			bw.write(String.format("%.3f%%\n", result));
		}
		
		bw.close();
		br.close();
	}
}
