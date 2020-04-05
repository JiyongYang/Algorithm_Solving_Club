package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_B1065_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int i = N; i >=1 ; i--) {
			if(d(i)) cnt++;
		}
		bw.write(cnt+"");
		bw.close();
	}
	
	public static boolean d(int n) {
		
		if(n < 100) return true;
		else {
			int diff = n%10-(n/10)%10;
			int base = n/10;
			boolean flg = true;
			while(base > 9) {
				int idiff = base%10-(base/10)%10;
				if(diff != idiff) {
					flg = false;
					break;
				}
				base /= 10;
			}
			return flg;
		}
	}
}
