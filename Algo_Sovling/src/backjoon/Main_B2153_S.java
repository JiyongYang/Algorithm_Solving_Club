package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_B2153_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	public static void main(String[] args) throws IOException {
		
		String in = br.readLine();
		int a = 0;
		for (int i = 0; i < in.length(); i++) {
			int v = (int)in.charAt(i);
			if(v >= 65 && v <= 90) { a += v-64+26;}
			else if(v >= 97 && v <= 122) { a += v-96; }
		}
		
		boolean[] check = new boolean[a+10];
		check[1] = false;
		for (int i = 2; i < a+10; i++) {
			if(check[i]) continue;
			int offset = 2;
			while(i*offset <= a) {
				check[i*offset] = true;
				offset++;
			}
		}
		if(!check[a]) bw.write("It is a prime word.");
		else bw.write("It is not a prime word.");
		
		
		br.close();
		bw.close();
	}
}
