package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B4948_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		
		boolean[] prime = new boolean[123456*2+1];
		prime[1] = true;
		for (int i = 2; i < prime.length; i++) {
			if(prime[i]) continue;
			int offset = 2;
			while(true) {
				if(i*offset > 123456*2) break;
				prime[i*offset] = true;
				offset++;
			}
		}
		
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			int cnt = 0;
			for (int i = N+1; i <= N*2; i++) {
				if(!prime[i]) cnt++;
			}
			bw.write(cnt+"\n");
		}
		
		br.close();
		bw.close();
	}
}
