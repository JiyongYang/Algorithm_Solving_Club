package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Main_B11726_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		long[] res = new long[N+2];
		res[1] = 1;
		res[2] = 2;
		for (int i = 3; i < res.length; i++) {
			res[i] = (res[i-1]+res[i-2])%10007;
		}
		
		bw.write(res[N]%10007+"");
		
		bw.close();
		br.close();
	}
}
