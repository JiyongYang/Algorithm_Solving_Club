package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B2577_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		int r = a*b*c;
		int[] cnt = new int[10];
		
		while(r >= 1) {
			cnt[r%10]++;
			r = r/10;
		}
		for (int i = 0; i < cnt.length; i++) {
			bw.write(cnt[i]+"\n");
		}
		
		bw.close();
		br.close();
	}
}
