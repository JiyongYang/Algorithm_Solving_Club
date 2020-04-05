package jungol;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_J1863_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int[] p = null;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		p = new int[n+1];
		makeSet();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if(x < y) unionSet(x, y);
			else unionSet(y, x);
		}
		
		try {
			bw.write(findsReli(n, m)+"");
		} catch (Exception e) {
			bw.write(e+"");
		}
		
		bw.close();
		br.close();
	}
	
	public static int findsReli(int n, int m) {
		int cnt = 0;
		int[] counter = new int[n+1];
		for (int i = 0; i < p.length; i++) {
			if(findSet(i) <= n && counter[findSet(i)]++ == 0) {
				cnt++;
			}
		}
		return cnt-1;
	}
	
	public static void unionSet(int x, int y) {
		int fy = y;
		x = findSet(x);
		y = findSet(y);
		if(x != y) {
			p[y] = x;
			findSet(fy);
		}
	}
	
	public static int findSet(int x) {
		if(x == p[x]) return x;
		else {
			int r = findSet(p[x]);
			p[x] = r;
			return r;
		}
	}
	
	public static void makeSet() {
		for (int i = 0; i < p.length; i++) {
			p[i] = i;
		}
	}
}
