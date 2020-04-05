package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B2775_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			int[][] apart = new int[k+1][n];
			for (int y = 0; y < apart.length; y++) {
				for (int x = 0; x < apart[y].length; x++) {
					if(y == 0) apart[y][x] = x+1;
					else {
						if(x == 0) apart[y][x] = apart[y-1][x];
						else apart[y][x] = apart[y-1][x]+apart[y][x-1];
					}
				}
			}
			
			bw.write(apart[k][n-1]+"\n");
		}
		
		br.close();
		bw.close();
	}
	
}
