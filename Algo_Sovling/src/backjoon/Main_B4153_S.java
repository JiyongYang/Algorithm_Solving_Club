package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_B4153_S {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		while(true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a == b && b == c && a == 0) break;
			double maxVal = 0, twoVal = 0;
			maxVal = Math.max(a, Math.max(b, c));
			if(maxVal == a) {
				twoVal = Math.pow(b, 2) + Math.pow(c, 2);
			} else if(maxVal == b) {
				twoVal = Math.pow(a, 2) + Math.pow(c, 2);
			} else {
				twoVal = Math.pow(a, 2) + Math.pow(b, 2);
			}
			
			if(Math.pow(maxVal, 2) == twoVal) bw.write("right\n");
			else bw.write("wrong\n");
		}
		
		br.close();
		bw.close();
	}
}
