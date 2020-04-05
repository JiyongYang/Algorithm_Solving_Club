package swea;
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
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_S1494_S {
	static class Pos{
		int y;
		int x;
		public Pos(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int[] cnt = null;
	static int N = 0;
	static Pos[] lst = null;
	static long minVal = Long.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			minVal = Long.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			lst = new Pos[N];
			for (int i = 0; i < lst.length; i++) {
				st = new StringTokenizer(br.readLine());
				lst[i] = new Pos(Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()));
			}
			
			cnt = new int[N];
			for (int i = 0; i < cnt.length; i++) {
				cnt[i] = 1;
			}
			ArrayList<Integer> arr = new ArrayList<>();
			perm(arr,0);
			
			bw.write("#"+t+" "+minVal+"\n");
		}
		
		br.close();
		bw.close();
	}
	
	public static void perm(ArrayList<Integer> arr, int x) {
		if(arr.size() == N/2) {
			Pos temp = new Pos(0, 0);
			boolean[] lookupTable = new boolean[N];
			for (Integer idx : arr) {
				lookupTable[idx] = true;
			}
			for (int i = 0; i < lookupTable.length; i++) {
				if(lookupTable[i]) {
					temp.x -= lst[i].x;
					temp.y -= lst[i].y;
				} else {
					temp.x += lst[i].x;
					temp.y += lst[i].y;
				}
			}
			long a = temp.x;
			long b = temp.y;
			long vector = a*a + b*b;
			if(vector < minVal) minVal = vector;
			return;
		}
		for (int i = x; i < N; i++) {
			if(cnt[i] > 0) {
				cnt[i]--;
				arr.add(i);
				perm(arr, i);
				arr.remove(arr.size()-1);
				cnt[i]++;
			}
		}
	}
}
