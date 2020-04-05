package swea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_S3124_S {
	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int weight;
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		public Edge() {
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
		@Override
		public String toString() {
			return "[from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}
		
		
	}
	
	static int N = 0;
	static int M = 0;
	static int[] p = null;
	static Edge[] edges = null;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			edges = new Edge[M];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				edges[i] = new Edge();
				edges[i].from = Integer.parseInt(st.nextToken());
				edges[i].to = Integer.parseInt(st.nextToken());
				edges[i].weight = Integer.parseInt(st.nextToken());
			}
			makeSet();
			Arrays.sort(edges);
			
//			ArrayList<Edge> resultList = mst();
//			
//			for (Edge edge : resultList) {
//				bw.write(edge+"\n");
//			}
			bw.write("#"+t+" "+mst()+"\n");
		}
		
		
		br.close();
		bw.close();
	}
	
	public static long mst() {
		//ArrayList<Edge> list = new ArrayList<>();
		long sum = 0 ;
		for (int i = 0; i < M; i++) {
			Edge temp = edges[i];
			if(unionSet(temp.from, temp.to)) {
				//list.add(temp);
				sum += temp.weight;
			}
//			if(findSet(temp.from) != findSet(temp.to)) {
//				//list.add(temp);
//				sum += temp.weight;
//				unionSet(temp.from, temp.to);
//			}
		}
		return sum;
	}
	
	
	public static void makeSet() {
		p = new int[N+1];
		for (int i = 0; i <= N; i++) {
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
