package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B1978_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] nums = new int[N];
		boolean[] prime = new boolean[1001];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		prime[1] = true;
		for (int i = 2; i < prime.length; i++) {
			if(prime[i]) continue;
			int offset = 2;
			while(true) {
				if(i*offset > 1000) break;
				prime[i*offset] = true;
				offset++;
			}
		}
		
//		for (int i = 1; i < prime.length; i++) {
//			if(!prime[i]) System.out.println(i);
//		}
		
		int cnt = 0;
		for (int i = 0; i < nums.length; i++) {
			if(!prime[nums[i]]) cnt++;
		}
		bw.write(cnt+"");
		
		br.close();
		bw.close();
	}
}
