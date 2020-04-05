package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B6064_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int checkSum = x;
			int checkMod = x;
			if(x>y) {
				checkSum = y;
				checkMod = y;
			}
			boolean flg = false;
			for (int i = 0; i < (x<=y?N:M); i++) {
				if((checkMod == y && x <= y) ||
						(checkMod == x && x > y)) {
					flg = true;
					break;
				}
				if(x<=y) {
					checkMod = (checkMod+M)%N == 0 ? N : (checkMod+M)%N;
					checkSum+=M;
				}else {
					checkMod = (checkMod+N)%M == 0 ? M : (checkMod+N)%M;
					checkSum+=N;
				}
				
			}
			
			if(flg) bw.write(checkSum+"\n");
			else bw.write(-1+"\n");
		}
		
		br.close();
		bw.close();
	}
	
}
