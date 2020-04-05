package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_B10809_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int[] alpha = new int[26];
		for (int i = 0; i < alpha.length; i++) {
			alpha[i] = -1;
		}
		
		String s = br.readLine();
		for (int i = 0; i < s.length(); i++) {
			int pos = (int)s.charAt(i) - 97;
			if(alpha[pos] == -1) alpha[pos] = i;
		}
		
		for (int i = 0; i < alpha.length; i++) {
			bw.write(alpha[i]+" ");
		}
		
		bw.close();
		br.close();
	}
}
