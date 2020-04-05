package backjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B13458_S {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		String in = "";
		
		int N = Integer.parseInt(br.readLine());
		in = br.readLine();
		st = new StringTokenizer(in);
		int[] pp = new int[N];
		for (int i = 0; i < pp.length; i++) {
			pp[i] = Integer.parseInt(st.nextToken()); 
		}
		
		in = br.readLine();
		int B = Integer.parseInt(in.split(" ")[0]);
		int C = Integer.parseInt(in.split(" ")[1]);
		
		long cnt = 0;
		
		for (int i = 0; i < pp.length; i++) {
			pp[i] -= B;
			cnt += 1l;
			
			if(pp[i] > 0) {
				if(pp[i] % C == 0) cnt += pp[i]/C;
				else cnt += pp[i]/C+1;
			}
		}
		System.out.print(cnt);
		
		
	}
}
