package swea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_S1251_S {
	static class Pos{
		int y;
		int x;
		public Pos(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
	
	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		double weight;
		public Edge(int from, int to, double weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		public Edge() {
		}

		@Override
		public int compareTo(Edge o) {
			return (int)(this.weight - o.weight);
		}
		@Override
		public String toString() {
			return "[from=" + from + ", to=" + to + ", weight=" + weight + "]\n";
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static StringTokenizer st2 = null;
	
	static int[] dist = null;;
	static ArrayList<Edge> list;
	static int N = 0;
	static double e = 0.0;
	static int[] p = null;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			
			list = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			st2 = new StringTokenizer(br.readLine());
			e = Double.parseDouble(br.readLine());
			
			Pos[] pl = new Pos[N];
			for (int i = 0; i < pl.length; i++) {
				pl[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st2.nextToken()));
			}
			
			for (int i = 0; i < pl.length; i++) {
				for (int j = 0; j < pl.length; j++) {
					if(i == j) continue;
					list.add(new Edge(i, j, distance(pl[i], pl[j])));
				}
			}
			Collections.sort(list);
			
			makeSet();
			bw.write(String.format("#%d %.0f\n", t, mst()*e));
			bw.flush();
		}
		
		br.close();
		bw.close();
	}
	
	public static double distance(Pos p1, Pos p2) {
		return Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2);
	}
	
	public static double mst() {
		double sum = 0 ;
		for (int i = 0; i < list.size(); i++) {
			Edge temp = list.get(i);
			if(unionSet(temp.from, temp.to)) {
				sum += temp.weight;
			}
		}
		return sum;
	}
	
	
	public static void makeSet() {
		p = new int[N];
		for (int i = 0; i < N; i++) {
			p[i] = i;
		}
	}
	
	public static int findSet(int x) {
		if(x == p[x]) return x;
		else {
			int r = findSet(p[x]);
			p[x] = r;
			return p[x];
		}
	}
	
	public static boolean unionSet(int y, int x) {
		int ty = y;
		y = findSet(y);
		x = findSet(x);
		if(y != x) {
			if(y > x) {
				p[y] = x;
			}
			else {
				p[x] = y;
			}
			findSet(ty);
			return true;
		}
		return false;
	}
}
