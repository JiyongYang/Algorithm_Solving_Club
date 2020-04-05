package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B2156_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int N = 0;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		
		int[] wine = new int[N];
		for (int i = 0; i < wine.length; i++) {
			wine[i] = Integer.parseInt(br.readLine());
		}
		int[][] maxWine = new int[N][3];
		maxWine[0][0] = wine[0];
		maxWine[0][1] = wine[0];
		maxWine[0][2] = 0;
		
		for (int i = 1; i < maxWine.length; i++) {
			if(i > 1) maxWine[i][0] = wine[i] + Math.max(Math.max(maxWine[i-2][0], maxWine[i-2][1]), maxWine[i-2][2]);
			else maxWine[i][0] = wine[i];
			maxWine[i][1] = wine[i] + maxWine[i-1][0];
			maxWine[i][2] = Math.max(Math.max(maxWine[i-1][0], maxWine[i-1][1]), maxWine[i-1][2]);
		}
		
//		for (int i = 0; i < maxWine.length; i++) {
//			bw.write(Arrays.toString(maxWine[i])+"\n");
//		}
		
		bw.write(Math.max(Math.max(maxWine[N-1][0], maxWine[N-1][1]), maxWine[N-1][2])+"");
		
		bw.close();
		br.close();
	}
}
