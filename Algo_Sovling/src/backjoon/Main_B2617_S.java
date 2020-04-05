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

public class Main_B2617_S {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int N = 0;
	static int totalCnt = 0;
	static int cntB = 0, cntS = 0;
	static int[][] diff = null;
	static boolean flg = false;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		diff = new int[N+1][N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			diff[f][t] = 2;
			diff[t][f] = 1;
		}
		
		for (int n1 = 1; n1 < N+1; n1++) {
			flg = false;
			cntB = 0;
			cntS = 0;
			boolean[] check = new boolean[N+1];
			checkB(n1, check);
			if(flg) continue;
			check = new boolean[N+1];
			checkS(n1, check);
		}
		
		bw.write(totalCnt+"");
		
		br.close();
		bw.close();
	}
	
	public static void checkB(int n1, boolean[] check) {
		if(flg) return;
		if(cntB >= (N+1)/2) {
			totalCnt++;
			flg = true;
			return;
		}
		
		for (int of = 1; of < N+1; of++) {
			if(check[of]) continue;
			if(diff[of][n1]==2) {
				check[of] = true;
				cntB++;
				checkB(of, check);
			}
			if(flg) return;
		}
	}
	public static void checkS(int n1, boolean[] check) {
		if(flg) return;
		if(cntS >= (N+1)/2) {
			totalCnt++;
			flg = true;
			return;
		}
		
		for (int of = 1; of < N+1; of++) {
			if(check[of]) continue;
			if(diff[of][n1]==1) {
				check[of] = true;
				cntS++;
				checkS(of, check);
			}
			if(flg) return;
		}
	}
}
