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

public class Main_B1547_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	public static void main(String[] args) throws IOException {
		int M = Integer.parseInt(br.readLine());
		int[] num = new int[4];
		int[] ltable = new int[4];
		for (int i = 1; i < num.length; i++) {
			num[i] = i;
			ltable[i] = i;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			swap(num, ltable, from, to);
		}
		bw.write(num[1]+"");
		
		br.close();
		bw.close();
	}
	public static void swap(int[] arr, int[] ltable, int p1, int p2) {
		int idx1 = ltable[p1];
		int idx2 = ltable[p2];
		
		int temp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = temp;
		
		temp = ltable[p1];
		ltable[p1] = ltable[p2];
		ltable[p2] = temp;
	}
}
