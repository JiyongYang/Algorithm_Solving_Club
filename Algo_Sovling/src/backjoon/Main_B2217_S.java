package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main_B2217_S {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[] rope = new int[N];
		for (int i = 0; i < rope.length; i++) {
			rope[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(rope);
		int maxWeight = 0;
		for (int i = N-1; i >= 0; i--) {
			//(i-N)
			if(maxWeight < (rope[i]*(N-i))) maxWeight = (rope[i]*(N-i));
		}
		bw.write(maxWeight+"");
		
		br.close();
		bw.close();
	}
}
