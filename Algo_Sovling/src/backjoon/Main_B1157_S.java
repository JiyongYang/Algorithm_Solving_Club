package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_B1157_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	public static void main(String[] args) throws IOException {
		int[] alpha = new int[26];
		String s = br.readLine().toUpperCase();
		for (int i = 0; i < s.length(); i++) {
			int pos = (int)(s.charAt(i)) - 65;
			alpha[pos]++;
		}
		int max = 0;
		char mCh = ' ';
		int maxCnt = 0;
		for (int i = 0; i < alpha.length; i++) {
			if(alpha[i] > max) {
				max = alpha[i];
				mCh = (char)(i+65);
				maxCnt = 1;
			} else if (alpha[i] == max) {
				maxCnt++;
			}
		}
		if(maxCnt > 1) bw.write("?");
		else bw.write(mCh);
		
		bw.close();
		br.close();
	}
}
