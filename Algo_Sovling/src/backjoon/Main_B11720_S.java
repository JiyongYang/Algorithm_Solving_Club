package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_B11720_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		br.readLine();
		String s = br.readLine();
		int sum = 0;
		for (int i = 0; i < s.length(); i++) {
			sum += (s.charAt(i) - '0');
		}
		bw.write(sum+"");
		
		bw.close();
		br.close();
	}
}
