package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_B5622_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	public static void main(String[] args) throws IOException {
		String s = br.readLine().toUpperCase();
		int time = 0;
		for (int i = 0; i < s.length(); i++) {
			int q = (s.charAt(i))-65;
			if(q >= 18) q -= 1;
			if(q==24) time += q/3+2;
			else time += q/3+3;
		}
		bw.write(time+"");
		
		bw.close();
		br.close();
	}
}
