package jungol;
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

public class Main_J1828_S {
	static class Chemi implements Comparable<Chemi>{
		int low;
		int high;
		public Chemi(int low, int high) {
			super();
			this.low = low;
			this.high = high;
		}
		@Override
		public int compareTo(Chemi o) {
			return high - o.high;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Chemi [low=" + low + ", high=" + high + "]\n";
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		ArrayList<Chemi> list = new ArrayList<>();
		boolean[] check = new boolean[N];
		int cnt = 0, total = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int mint = Integer.parseInt(st.nextToken());
			int maxt = Integer.parseInt(st.nextToken());
			
			list.add(new Chemi(mint, maxt));
		}
		Collections.sort(list);
		
		
		int maxTem = list.get(0).high;
		while(true) {
			for (int i = 0; i < list.size(); i++) {
				if(check[i]) continue;
				if(list.get(i).low > maxTem) break;
				if(list.get(i).high < maxTem) maxTem = list.get(i).high;
				cnt++;
				check[i] = true;
			}
			total++;
			for (int i = 0; i < list.size(); i++) {
				if(check[i]) continue;
				maxTem = list.get(i).high;
				break;
			}
			if(cnt == N) break;
		}
		bw.write(total+"");
		
		br.close();
		bw.close();
	}
}
