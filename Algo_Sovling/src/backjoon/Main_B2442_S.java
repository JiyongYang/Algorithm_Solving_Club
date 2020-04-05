package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_B2442_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < N-i; j++) {
				bw.write(" ");
			}
			for (int j = 0; j < i*2-1; j++) {
				bw.write("*");
			}
			bw.write("\n");
		}
		
		br.close();
		bw.close();
	}
}
