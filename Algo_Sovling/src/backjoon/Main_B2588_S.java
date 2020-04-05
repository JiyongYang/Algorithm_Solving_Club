package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_B2588_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		
		bw.write(a*(b%10)+"\n");
		bw.write(a*((b/10)%10)+"\n");
		bw.write(a*(b/100)+"\n");
		bw.write(a*b+"");
		
		bw.close();
		br.close();
	}
}
