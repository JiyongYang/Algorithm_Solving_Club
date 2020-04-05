package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class Main_B2133_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[] res = new int[N+1];
		
		if(N%2==1) bw.write(0+"");
		else {
			res[2] = 3;
			res[0] = 1;
			for (int i = 4; i <= N; i+=2) {
				for (int j = 2; j <= i; j+=2) {
					int s = (j==2) ? 3 : 2;
					res[i] += s*res[i-j];
				}
			}
			bw.write(res[N]+"");
		}
		
		bw.close();
		br.close();
	}
}
