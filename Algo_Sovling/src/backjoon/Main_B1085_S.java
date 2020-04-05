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

public class Main_B1085_S {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int minVal = 2000;
		if(Math.abs(x) < minVal) minVal = Math.abs(x);
		if(Math.abs(y) < minVal) minVal = Math.abs(y);
		if(Math.abs(w-x) < minVal) minVal = Math.abs(w-x);
		if(Math.abs(h-y) < minVal) minVal = Math.abs(h-y);
		
		bw.write(minVal+"");
		
		br.close();
		bw.close();
	}
}
