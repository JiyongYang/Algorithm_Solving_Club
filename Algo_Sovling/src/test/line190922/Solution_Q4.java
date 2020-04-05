package test.line190922;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_Q4 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		int zeroCnt = 0;
		int maxZeroCnt = 0;
		for (int i = 0; i < N; i++) {
			int v = Integer.parseInt(st.nextToken());
			if(v == 1) zeroCnt = 0;
			if(v == 0) zeroCnt++;
			if(zeroCnt > maxZeroCnt) maxZeroCnt = zeroCnt;
		}
		
		bw.write((maxZeroCnt+1)/2+"");
		
		br.close();
		bw.close();
	}
}
