package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_B2908_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		StringBuilder sb1 = new StringBuilder(st.nextToken());
		StringBuilder sb2 = new StringBuilder(st.nextToken());
		StringBuilder sb11 = sb1.reverse();
		StringBuilder sb21 = sb2.reverse();
		
		if(Integer.parseInt(sb11.toString()) > Integer.parseInt(sb21.toString())) bw.write(sb11.toString()+"\n");
		else bw.write(sb21.toString()+"\n");
		
		
		bw.close();
		br.close();
	}
}
