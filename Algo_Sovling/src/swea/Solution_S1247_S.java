package swea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_S1247_S {
	static class Pos{
		int y;
		int x;
		Pos(int y, int x){
			this.x = x;
			this.y = y;
		}
	}
	
	static class Node{
		Pos pos;
		int id;
		int dist;
		ArrayList<Node> child = new ArrayList<>();
		Node(int id, int dist, Pos pos){
			this.id = id;
			this.dist = dist;
			this.pos = pos;
		}
		@Override
		public String toString() {
			if(child.size() != 0)
				return "[i|" + id +"] "+child+"";
			return "[i|" + id  + "]";
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int minPath = Integer.MAX_VALUE;
	static Node[] graph = null;
	static Pos[] pList = null;
	static int N = 0;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			pList = new Pos[N+2];
			graph = new Node[N+2];
			minPath = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			pList[0] = new Pos(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
			pList[1] = new Pos(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
			for (int i = 2; i < pList.length; i++) {
				pList[i] = new Pos(Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()));
			}
			
			for (int i = 0; i < graph.length; i++) {
				Pos base = pList[i];
				graph[i] = new Node(i, 0, base);
				for (int j = 0; j < pList.length; j++) {
					if( i == j ) continue;
					graph[i].child.add( new Node( j, distance(base, pList[j]), pList[j]) );
				}
			}
			boolean[] check = new boolean[N+2];
			dfs(graph[0], check, 0, 0);
			
			bw.write("#"+t+" "+minPath+"\n");
			bw.flush();
		}
		
		br.close();
		bw.close();
	}
	
	public static void dfs(Node node, boolean[] check, int pathWeight, int depth) {
//		System.out.println(node+" "+depth +" "+N);
		// base
		if(depth == N) {
			// 집만 빼고 다 방문한 경우
			pathWeight += distance(node.pos, pList[1]);
			if(pathWeight < minPath) minPath = pathWeight;
			return;
		}
		
		for (int i = 0; i < node.child.size(); i++) {
			
			Node tNode = node.child.get(i);
			
			if(tNode.id == 1 || tNode.id == node.id || check[tNode.id] || tNode.id == 0) continue;
//			System.out.println(depth+" "+i+" "+graph[tNode.id]);
			
			pathWeight += distance(node.pos, tNode.pos);
			check[tNode.id] = true;
			dfs(graph[tNode.id], check, pathWeight, depth+1);
			check[tNode.id] = false;
			pathWeight -= distance(node.pos, tNode.pos);
		}
	}
	
	public static int distance(Pos p1, Pos p2) {
		return Math.abs(p1.x-p2.x) + Math.abs(p1.y-p2.y);
	}
}
