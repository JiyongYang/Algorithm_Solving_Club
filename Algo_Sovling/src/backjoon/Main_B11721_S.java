package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
public class Main_B11721_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		String n = br.readLine();
		
		while(n.length() > 10) {
			String s = n.substring(0, 10);
			bw.write(s+"\n");
			n = n.substring(10);
		}
		bw.write(n+"\n");
		
		bw.close();
		br.close();
	}
}
