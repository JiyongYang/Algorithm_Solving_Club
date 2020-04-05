package swea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_S7193_S {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			String X = st.nextToken();
			long decimalNum = 0L;
			for (int i = X.length()-1; i >= 0 ; i--) {
//				System.out.println((X.charAt(i)-'0')+" "+Math.pow(N, (X.length()-1)-i));
				decimalNum += (X.charAt(i)-'0')%(N-1);
			}
			bw.write("#"+t+" "+(decimalNum)%(N-1)+"\n");
			
		}
		
		br.close();
		bw.close();
	}
}
