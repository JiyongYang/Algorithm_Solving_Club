package unsolved;
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

public class Main_B1753_SR {
	static class Node implements Comparable<Node>{
		int idx;
		int cost;
		public Node(int idx, int cost) {
			super();
			this.idx = idx;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node o) {
			return cost == o.cost ? idx - o.idx : cost - o.cost;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	static int[] dist = null;;
	static int E, V;
	static final int INF = Integer.MAX_VALUE;
	static ArrayList<Node>[] list;
	static boolean[] visit = null;
	
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		int sv = Integer.parseInt(br.readLine());
		
		dist = new int[V+1];
		visit = new boolean[V+1];
		Arrays.fill(dist, INF);
		list = new ArrayList[V+1];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list[from].add(new Node(to, weight));
		}
		
		dijkstra(sv);
		
		for (int i = 1; i < dist.length; i++) {
			if(dist[i] != INF) bw.write(dist[i]+"\n");
			else bw.write("INF\n");
		}
		
		br.close();
		bw.close();
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.offer(new Node(start, dist[start]));
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int minIdx = node.idx;
			visit[minIdx] = true;
			
			// minIdx에 근접한 모든 노드들 확인
			for (int i = 0; i < list[minIdx].size(); i++) {
				Node minIdxNearNode = list[minIdx].get(i);
				if(dist[minIdxNearNode.idx] > minIdxNearNode.cost + dist[minIdx]) {
					dist[minIdxNearNode.idx] = minIdxNearNode.cost + dist[minIdx];
					pq.offer(new Node(minIdxNearNode.idx, dist[minIdxNearNode.idx]));
				}
			}
		}
	}
}
