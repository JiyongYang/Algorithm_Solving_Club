package swea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_S5215_S {
	static class Ingre implements Comparable<Ingre>{
		int pt;
		int cal;
		public Ingre(int pt, int cal) {
			super();
			this.pt = pt;
			this.cal = cal;
		}
		@Override
		public int compareTo(Ingre o) {
			return cal - o.cal;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Ingre [pt=" + pt + ", cal=" + cal + "]";
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int N = 0, L = 0, maxPt = 0;
	static ArrayList<Ingre> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			maxPt = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				list.add(new Ingre(Integer.parseInt(st.nextToken()), 
						Integer.parseInt(st.nextToken())));
			}
			Collections.sort(list);
//			System.out.println(list);
			
			dfs(0, L, 0);
			
			list.clear();
			bw.write("#"+t+" "+maxPt+"\n");
		}
		
		bw.close();
		br.close();
	}
	
	public static void dfs(int s, int L, int pt) {
		if(s == N || L <= 0) {
			if(pt > maxPt) maxPt = pt;
			return;
		}
		
		if(L>=list.get(s).cal) 
		{
			dfs(s+1, L-list.get(s).cal, pt+list.get(s).pt);
			dfs(s+1, L, pt);
		}
		else {
			if(pt > maxPt) maxPt = pt;
			return;
		}
	}
}
