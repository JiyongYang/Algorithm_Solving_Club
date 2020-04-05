package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_B1850_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		Long aM = Long.parseLong(st.nextToken());
		Long bM = Long.parseLong(st.nextToken());
		
		long r = 0L;
		if(aM < bM) { r = gcd(aM, bM); }
		else r = gcd(aM, bM);
		
		for (int i = 0; i < r; i++) {
			bw.write("1");
		}
		
		br.close();
		bw.close();
	}
	
	public static long gcd(long a, long b) {
		if(b==0) return a;
		else return gcd(b, a%b);
	}
}
