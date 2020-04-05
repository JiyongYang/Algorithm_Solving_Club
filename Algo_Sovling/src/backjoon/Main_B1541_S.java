package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main_B1541_S {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;

	public static void main(String[] args) throws IOException {
		String s = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		int sum = 0;
		int subSum = 0;
		boolean subFlg = false;
		for (int i = 0; i < s.length(); i++) {
//			bw.write(sb.toString()+" "+sum+", -"+subSum+"\n");
			if(s.charAt(i) == '+' && !subFlg) {
				sum += Integer.parseInt(sb.toString());
				sb.setLength(0);
				continue;
			}
			if(s.charAt(i) == '+' && subFlg) {
				subSum += Integer.parseInt(sb.toString());
				sb.setLength(0);
				continue;
			}
			if(s.charAt(i) == '-' && !subFlg) {
				sum += (subSum+Integer.parseInt(sb.toString()));
				subSum = 0;
				subFlg = true;
				sb.setLength(0);
				continue;
			}
			if(s.charAt(i) == '-' && subFlg) {
				sum -= (subSum+Integer.parseInt(sb.toString()));
				subSum = 0;
				subFlg = true;
				sb.setLength(0);
				continue;
			}
			sb.append(s.charAt(i));
		}
		if(subFlg) sum -= (subSum+Integer.parseInt(sb.toString()));
		else sum += Integer.parseInt(sb.toString());
		
		bw.write(sum+"");
		
		br.close();
		bw.close();
	}
}
