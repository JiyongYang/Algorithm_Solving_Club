package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class Main_B9095_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		int[] res = new int[12];
		res[1] = 1;
		res[2] = 2;
		res[3] = 4;
		for (int i = 4; i < res.length; i++) {
			res[i] = res[i-1] + res[i-2] + res[i-3];
		}
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			bw.write(res[N]+"\n");
		}
		
		bw.close();
		br.close();
	}
}
