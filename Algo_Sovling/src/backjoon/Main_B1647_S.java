package backjoon;
import java.io.*;
import java.util.*;
import java.lang.*;

public class Main_B1647_S {
	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int weight;
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return weight == o.weight ? from - o.from : weight - o.weight;
		}
	}
	static int[] p = null;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		p = new int[N+1];
		
		ArrayList<Edge> list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			list.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		
		Collections.sort(list);
		makeSet();
		int total = 0;
		int edge = 0;
		int cnt = 0;
		for (int i = 0; i < list.size(); i++) {
			Edge e = list.get(i);
			if(unionSet(e.from, e.to)) {
				cnt++;
				total += e.weight;
				edge = e.weight;
				if(cnt == N-2) break;
			}
		}
		System.out.println(total);
		
	}
	
	public static void makeSet() {
		for (int i = 1; i < p.length; i++) {
			p[i] = i;
		}
	}
	
	public static int findSet(int x) {
		if(x == p[x]) return x;
		else {
			return p[x] = findSet(p[x]);
		}
	}
	
	public static boolean unionSet(int x, int y) {
		int tx = findSet(x);
		int ty = findSet(y);
		
		if(tx == ty) return false;
		else {
			if(x > y) {
				p[tx] = ty;
			} else {
				p[ty] = tx;
			}
			return true;
		}
	}
}
