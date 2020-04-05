package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_B1101_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int gap = y-x;
			
			bw.write(f(gap)+"\n");
		}
		
		br.close();
		bw.close();
	}
	
	public static int f(int n) {
		double n1 = -((n)/1.0);
		double r1 = -1+Math.sqrt(1-(4*n1));
		int iResult = (int)Math.ceil(r1/2);
		int formerSum = iResult*(iResult-1);
		int diff = n-formerSum;
//		System.out.println(String.format("[R]%d, [S]%d, [D]%d\n", iResult, formerSum, diff));
		if(diff <= iResult) return iResult*2-1;
		else return iResult*2;
	}
}
