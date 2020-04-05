package swea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_S2007_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			String in = br.readLine();
			StringBuilder sb = new StringBuilder();
			sb.append(in.charAt(0));
			for (int i = 1; i < in.length(); i++) {
				if(in.charAt(i) != sb.charAt(0)) {
					sb.append(in.charAt(i));
				}else {
					if(i+sb.length() > in.length()) break;
					String cmp = in.substring(i, i+sb.length());
					if(cmp.equals(sb.toString())) i += sb.length()-1;
					else sb.append(in.charAt(i));
				}
			}
			bw.write("#"+t+" "+sb.length()+"\n");
			bw.flush();
		}
		bw.close();
		br.close();
	}
}
