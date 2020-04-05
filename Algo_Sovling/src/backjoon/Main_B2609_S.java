package backjoon;
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

public class Main_B2609_S {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int gcd = gcd(a,b);
		bw.write(gcd+"\n");
		bw.write((a*b)/gcd+"\n");
		
		
		
		br.close();
		bw.close();
	}
	
	public static int gcd(int a, int b) {
		if(a > b) {
			if(b == 0) return a;
			return gcd(b, a%b);
		} else {
			if(a == 0) return b;
			return gcd(a, b%a);
		}
	}
}
