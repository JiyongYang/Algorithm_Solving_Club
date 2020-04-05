package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_B2750_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		for (int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(num);
		for (int i = 0; i < num.length; i++) {
			bw.write(num[i]+"\n");
		}
		
		br.close();
		bw.close();
	}
	
}
