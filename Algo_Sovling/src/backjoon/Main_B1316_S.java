package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_B1316_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int[] counter = new int[26];
			String s = br.readLine();
			int prePos = 0;
			boolean flg = true;
			for (int k = 0; k < s.length(); k++) {
				int v = (int)(s.charAt(k)) - 97;
				if(k!= 0&& prePos != v) {
					counter[prePos] = -1;
				}
				
				if(counter[v] != -1) {
					counter[v]++;
				}else {
					flg = false;
					break;
				}
				
				prePos = v;
			}
			if(flg) cnt++;
		}
		bw.write(cnt+"");
		
		br.close();
		bw.close();
	}

}
