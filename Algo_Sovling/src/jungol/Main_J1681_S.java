package jungol;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_J1681_S {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int N = 0;
	static int[][] map = null;
	static int minCost = 0;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		minCost = Integer.MAX_VALUE;
		
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		ArrayList<Integer> arr = new ArrayList<>();
		
		dfs(arr, 0, 0, 0);
		System.out.println(minCost);
		
		bw.close();
		br.close();
	}
	
	public static void dfs(ArrayList<Integer> arr, int from, int cost, int depth) {
		if(minCost < cost) return;
		
		if(arr.size() == N-1) {
			int lastSpot = arr.get(arr.size()-1);
			if(map[lastSpot][0] != 0) {
				int result = cost+map[lastSpot][0];
				if(result < minCost) minCost = result;
//				System.out.println((cost+map[lastSpot][0])+"] ("+lastSpot+") "+arr);
			}
			
		}
		
		for (int i = 1; i < N; i++) {
			// 길이 없는 경우
			if(map[from][i] == 0) continue;
			
			// 길이 있으며 이미 와본적이 있는 경우
			if(arr.contains(i)) continue;
			
			// 새로 가는 길인 경우
			arr.add(i);
			dfs(arr, i, cost+map[from][i], depth+1);
			arr.remove(arr.size()-1);
			
		}
	}
}
