package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_B2606_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		int[][] edge = new int[N+1][N+1];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			edge[from][to] = 1;
			edge[to][from] = 1;
		}
		
		int cnt = 0;
		boolean[] check = new boolean[N+1];
		// start 1
		Queue<Integer> s = new LinkedList<>();
		s.add(1);
		check[1] = true;
		while(!s.isEmpty()) {
			int vertex = s.poll();
			for (int i = 1; i <= N; i++) {
				if(i == vertex) continue;
				if(!check[i] && edge[vertex][i] == 1) {
					s.add(i);
					check[i] = true;
					cnt++;
				}
			}
		}
		bw.write(cnt+"");
		
		br.close();
		bw.close();
	}
}
