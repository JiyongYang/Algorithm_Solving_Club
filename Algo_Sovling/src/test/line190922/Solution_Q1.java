package test.line190922;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_Q1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[] consumer = new int[C];
		
		for (int i = 0; i < N; i++) {
			int msg = Integer.parseInt(br.readLine());
			int minVal = Integer.MAX_VALUE;
			int minPos = -1;
			for (int offset = 0; offset < C; offset++) {
				if(minVal > consumer[offset]) {
					minPos = offset;
					minVal = consumer[offset];
				}
			}
			consumer[minPos] += msg;
		}
		
		int maxVal = 0;
		for (int offset = 0; offset < C; offset++) {
			if(maxVal < consumer[offset]) {
				maxVal = consumer[offset];
			}
		}
		bw.write(maxVal+"");
		
		br.close();
		bw.close();
	}
}
