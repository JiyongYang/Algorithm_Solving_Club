package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_B9498_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int a = Integer.parseInt(br.readLine());
		switch(a/10) {
		case 10:
		case 9:
			bw.write("A");
			break;
		case 8:
			bw.write("B");
			break;
		case 7:
			bw.write("C");
			break;
		case 6:
			bw.write("D");
			break;
		default:
			bw.write("F");
			break;
		}
		
		bw.close();
		br.close();
	}
}
