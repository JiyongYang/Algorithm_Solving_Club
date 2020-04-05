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

public class Main_B3053_S {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int r = Integer.parseInt(br.readLine());
		double c1 = Math.PI*Math.pow(r, 2);
		double c2 = Math.pow(r, 2)*2;
		
		bw.write(String.format("%.6f\n%.6f", c1, c2));
		
		br.close();
		bw.close();
	}
}
