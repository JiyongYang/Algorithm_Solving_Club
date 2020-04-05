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

public class Main_B3009_S {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int[] cnts = new int[1001];
		int[] cnts2 = new int[1001];
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			list.add(x);
			list2.add(y);
			cnts[x] += 1;
			cnts2[y] += 1;
		}
		int fx = 0, fy = 0;
		for (int i = 0; i < list.size(); i++) {
			if(cnts[list.get(i)] == 1) fx = list.get(i);
			if(cnts2[list2.get(i)] == 1) fy = list2.get(i);
		}
		
		bw.write(fx+" "+fy);
		
		br.close();
		bw.close();
	}
}
