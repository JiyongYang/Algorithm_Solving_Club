package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_B1193_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		bw.write(f(N)+"");
		
		br.close();
		bw.close();
	}
	
	public static String f(int n) throws IOException {
		double r1 = -1+Math.sqrt(1-(8.0*(-(n-1))));
		int r = (int)(r1/2)+1;
		int l = ((r-1)*r)/2;
		int diff = n-l;

//		bw.write(String.format("%d] %d l(%d) d(%d) ", n, r, l, diff));
		
		if(r%2 ==0) {
			return diff+"/"+(r+1-diff);
		}
		else {
			return (r+1-diff)+"/"+diff;
		}
	}
}
