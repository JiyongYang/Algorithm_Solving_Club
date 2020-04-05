package swea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_S1952_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int[] cost = null;
	static int[] schedule = null;
	static int counter = 0;
	static int minCost = 0;
	static int maxCnt = 0;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			maxCnt = 0;
			st = new StringTokenizer(br.readLine());
			cost = new int[4];
			for (int i = 0; i < cost.length; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			schedule = new int[12];
			for (int i = 0; i < schedule.length; i++) {
				schedule[i] = Integer.parseInt(st.nextToken());
				if(schedule[i] != 0) maxCnt++;
			}
			minCost = Integer.MAX_VALUE;
			for (int i = 0; i < 12; i++) {
				boolean[] check = new boolean[12];
				counter = 0;
				dfs(i, check, 0, 0);
			}
			if(minCost > cost[3]) minCost = cost[3];
			bw.write("#"+t+" "+minCost+"\n");
//			bw.write("#"+t+" "+minPath+"\n");
			bw.flush();
		}
		
		br.close();
		bw.close();
	}
	
	static void dfs(int month, boolean[] check, int interalCost, int depth) {
//		System.out.println(String.format("%d] %d  || %d", month, interalCost, maxCnt));
		if(/*counter == maxCnt || */depth == maxCnt) {
			if(minCost > interalCost) minCost = interalCost;
			// 종료조건
			return;
		}
		if(schedule[month] == 0 || check[month]) {
			return;
		}
		
		for (int i = month; i < 12; i++) {
			if(schedule[month] == 0 || check[month]) continue;
			
			// 하루 단위
			check[month] = true;
			counter+=1;
			interalCost+=cost[0]*schedule[month];
			dfs(i, check, interalCost, depth+1);
			interalCost-=cost[0]*schedule[month];
			counter-=1;
			check[month] = false;
			
			// 한달 단위
			check[month] = true;
			counter+=1;
			interalCost+=cost[1];
			dfs(i, check, interalCost, depth+1);
			interalCost-=cost[1];
			counter-=1;
			check[month] = false;
			
			int cc = 0;
			// 세달 단위
			for (int k = 0; k < 3; k++) {
				if(month+k < 12) {
					check[month+k] = true;
					if(schedule[month+k] != 0) {
						counter+=1;
						cc+=1;
					}
				}
			}
			interalCost+=cost[2];
			dfs(i, check, interalCost, depth+cc);
			interalCost-=cost[2];
			for (int k = 0; k < 3; k++) {
				if(month+k < 12) {
					check[month+k] = false;
					if(schedule[month+k] != 0) {
						counter-=1;
						cc-=1;
					}
				}
			}
			
		}
	}
}
