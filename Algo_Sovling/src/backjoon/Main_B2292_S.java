package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_B2292_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		if(n==1) bw.write(1+"");
		else bw.write(f(n)+"\n");
		br.close();
		bw.close();
	}
	
	public static int f(int n) {
		double n1 = -((n-2)/3.0);
		double r1 = -1+Math.sqrt(1-(4*n1));
		return (int)(r1/2)+2;
	}
}
