package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B7568_S {
	static class People implements Comparable<People>{
		int id;
		int w;
		int h;
		public People(int w, int h) {
			super();
			this.id = idx++;
			this.w = w;
			this.h = h;
		}
		@Override
		public int compareTo(People o) {
			if( w > o.w && h > o.h ) return -1;
			if(w < o.w && h < o.h) return 1;
			return 0;
		}
		@Override
		public String toString() {
			return "P [id=" + id + ", w=" + w + ", h=" + h + "]\n";
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static People[] p = null;
	static int[] rank = null;
	static int idx = 0;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		p = new People[N];
		rank = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			p[i] = new People(Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()));
		}
		
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if(i == j) continue;
				if(p[i].compareTo(p[j]) == 1) cnt++;
			}
			rank[i] = cnt+1;
		}
		
		for (int i = 0; i < N; i++) bw.write(rank[i]+" ");
		
		br.close();
		bw.close();
	}
}
