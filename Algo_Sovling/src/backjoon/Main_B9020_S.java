package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B9020_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		boolean[] prime = new boolean[10001];
		prime[1] = true;
		for (int i = 2; i < prime.length; i++) {
			if(prime[i]) continue;
			int offset = 2;
			while(true) {
				if(i*offset > 10000) break;
				prime[i*offset] = true;
				offset++;
			}
		}
		
		
		for (int iter = 0; iter < N; iter++) {
			int a = 0, b = 0;
			int minDiff = Integer.MAX_VALUE;
			int num = Integer.parseInt(br.readLine());
			for (int i = 2; i <= num/2; i++) {
				if(prime[i] == false && prime[num-i] == false) {
					if(num-i-i < minDiff) {
						minDiff = num-i-i;
						a = i;
						b = num-i;
//						System.out.println(i+" "+minDiff);
					}
				}
			}
			
			bw.write(a+" "+b+"\n");
		}
		
		br.close();
		bw.close();
	}

}
