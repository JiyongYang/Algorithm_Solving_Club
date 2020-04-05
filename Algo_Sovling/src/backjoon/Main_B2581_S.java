package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B2581_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		boolean[] prime = new boolean[N+1];
		prime[1] = true;
		for (int i = 2; i < prime.length; i++) {
			if(prime[i]) continue;
			int offset = 2;
			while(true) {
				if(i*offset > N+1) break;
				prime[i*offset] = true;
				offset++;
			}
		}
		
		int sum = 0;
		int min = 0;
		boolean flg = true;
		for (int i = M; i <= N; i++) {
			if(!prime[i]) {
				sum+=i;
				if(flg) {
					min=i;
					flg = false;
				}
				
			}
		}
		if(sum == 0) bw.write(-1+"");
		else bw.write(sum+"\n"+min);
		
		
		br.close();
		bw.close();
	}
}
