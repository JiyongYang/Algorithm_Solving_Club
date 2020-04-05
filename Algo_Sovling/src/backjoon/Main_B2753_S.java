package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_B2753_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int a = Integer.parseInt(br.readLine());
		
		if((a%4==0 && a%100!=0) || a%400==0) bw.write(1+"");
		else bw.write(0+"");
		
		bw.close();
		br.close();
	}
}
