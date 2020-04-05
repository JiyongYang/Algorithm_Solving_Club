package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B1929_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		boolean[] prime = new boolean[N+1];
		prime[1] = true;
		for (int i = 2; i < prime.length; i++) {
			if(prime[i]) continue;
			int offset = 2;
			while(true) {
				if(i*offset > N) break;
				prime[i*offset] = true;
				offset++;
			}
		}
		
		int sum = 0;
		int min = 0;
		boolean flg = true;
		for (int i = M; i <= N; i++) {
			if(!prime[i]) bw.write(i+"\n");
		}
		
		br.close();
		bw.close();
	}
}
