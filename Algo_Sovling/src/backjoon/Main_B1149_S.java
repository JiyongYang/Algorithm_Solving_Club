package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_B1149_S {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		int[][] colors = new int[N][3];
		int[][] result = new int[N][3];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			colors[i][0] = Integer.parseInt(st.nextToken());
			colors[i][1] = Integer.parseInt(st.nextToken());
			colors[i][2] = Integer.parseInt(st.nextToken());
		}
		
		result[0][0] = colors[0][0];
		result[0][1] = colors[0][1];
		result[0][2] = colors[0][2];
		
		for (int i = 1; i < N; i++) {
			{
				int a = colors[i][0]+result[i-1][1]; 
				int b = colors[i][0]+result[i-1][2]; 
				result[i][0] = a > b ? b : a;
			}
			{
				int a = colors[i][1]+result[i-1][0]; 
				int b = colors[i][1]+result[i-1][2]; 
				result[i][1] = a > b ? b : a;
			}
			{
				int a = colors[i][2]+result[i-1][0]; 
				int b = colors[i][2]+result[i-1][1]; 
				result[i][2] = a > b ? b : a;
			}
		}
		int minVal = 10000000;
		for (int i = 0; i < 3; i++) {
			if(result[N-1][i] < minVal) minVal = result[N-1][i];
		}
		
		bw.write(minVal+"");
		
		bw.close();
		br.close();
		
	} // end of main
}
