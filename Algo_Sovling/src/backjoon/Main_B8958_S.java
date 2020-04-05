package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B8958_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			String s = br.readLine();
			int point = 0;
			int cnt = 0;
			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == 'O') {
					point+=++cnt;
				}
				else {
					cnt = 0;
				}
			}
			bw.write(point+"\n");
		}
		
		bw.close();
		br.close();
	}
}
