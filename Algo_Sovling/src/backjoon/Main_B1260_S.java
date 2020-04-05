package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_B1260_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException{
		
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		LinkedList<Integer>[] vertices = new LinkedList[N+1];
		for (int i = 0; i < N+1; i++) {
			vertices[i] = new LinkedList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			vertices[s].add(d);
			vertices[d].add(s);
		}
		
		for (int i = 1; i < N+1; i++) {
			Collections.sort(vertices[i]);
		}
		
		dfs(vertices, N, V);
		bw.write("\n");
		bfs(vertices, N, V);
		
		br.close();
		bw.close();
	}
	
	public static void dfs(LinkedList<Integer>[] vertices, int N, int start) throws IOException {
		Set<Integer> checked = new HashSet<>();
		Stack<Integer> stack = new Stack<>();
		
		checked.add(start);
		bw.write(start+" ");
		stack.add(start);
		
		while(!stack.isEmpty()) {
			int v = stack.pop();
			for (int i = 0; i < vertices[v].size(); i++) {
				int w = vertices[v].get(i);
				if(!checked.contains(w))
				{
					stack.add(v);
					stack.add(w);
					checked.add(w);
					bw.write(w+" ");
					break;
				}
			}
		}
	}
	
	public static void dfs2(LinkedList<Integer>[] vertices, int N, int start) throws IOException {
		Set<Integer> checked = new HashSet<>();
		Stack<Integer> stack = new Stack<>();
		
		checked.add(start);
		bw.write(start+" ");
		stack.add(start);
		
		while(!stack.isEmpty()) {
			int v = stack.peek();
			boolean flag = false;
			
			for (int i = 0; i < vertices[v].size(); i++) {
				int w = vertices[v].get(i);
				if(!checked.contains(w)) {
					stack.add(w);
					bw.write(w+" ");
					checked.add(w);
					flag = true;
					break;
				}
			}
			if(!flag) stack.pop();
		}
	}
	
	public static void bfs(LinkedList<Integer>[] vertices, int N, int start) throws IOException {
		Set<Integer> checked = new HashSet<>();
		Queue<Integer> queue = new LinkedList<>();
		
		checked.add(start);
		bw.write(start+" ");
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			int v = queue.poll();
			for (int i = 0; i < vertices[v].size(); i++) {
				int w = vertices[v].get(i);
				if(!checked.contains(w)) {
					queue.add(w);
					checked.add(w);
					bw.write(w+" ");
				}
			}
		}
	}
}
