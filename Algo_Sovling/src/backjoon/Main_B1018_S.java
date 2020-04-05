package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B1018_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int N = 0, M = 0;
	static int[][] map = null;
	static int small = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int y = 0; y < N; y++) {
			String s = br.readLine();
			for (int x = 0; x < M; x++) {
				if(s.charAt(x)=='W') map[y][x] = 0;
				else map[y][x] = 1;
			}
		}
		
		
		for (int y = 0; y < N-7; y++) {
			for (int x = 0; x < M-7; x++) {
				checker(y, x);
			}
		}
		bw.write(small+"");
		
		br.close();
		bw.close();
	}
	
	public static void checker(int y, int x) {
		int cnt = 0;
		for (int ch = 0; ch < 2; ch++) {
			cnt = 0;
			for (int j = 0; j < 8; j++) {
				for (int i = 0; i < 8; i++) {
					if(map[y+j][x+i] != ch) cnt++;
					ch = (ch+1)%2;
				}
				ch = (ch+1)%2;
			}
			if(cnt < small) small = cnt;
		}
	}
}
