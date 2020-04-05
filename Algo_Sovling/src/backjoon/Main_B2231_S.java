package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B2231_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		
		int pos = 0;
		for (int i = 1; i < n; i++) {
			if(check(i, n)) {
				pos = i;
				break;
			};
		}
		bw.write(pos+"");
		
		br.close();
		bw.close();
	}
	
	public static boolean check(int i, int n) {
		boolean result = false;
		int sum = i;
		while(i >= 1) {
			sum += i%10;
			i/=10;
		}
		if(sum == n) result = true;
		
		return result;
	}
}
