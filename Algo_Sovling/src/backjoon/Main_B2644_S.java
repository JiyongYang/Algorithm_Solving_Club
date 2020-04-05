package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Chon{
	int n;
	int dist;
	Chon(int n, int dist){
		this.n = n;
		this.dist = dist;
	}
}

public class Main_B2644_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		String in = br.readLine();
		int p1 = Integer.parseInt(in.split(" ")[0]);
		int p2 = Integer.parseInt(in.split(" ")[1]);
		
		LinkedList<Integer>[] relation = new LinkedList[n+1];
		
		for (int i = 0; i < n+1; i++) {
			relation[i] = new LinkedList<>();
		}
		
		int r = Integer.parseInt(br.readLine());
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			relation[s].add(d);
			relation[d].add(s);
		}
		bw.write(Integer.toString(bfs(relation, p1, p2, n)));
		bw.close();
		br.close();
		
	}
	public static int bfs(LinkedList<Integer>[] relation, int src, int dst, int n) {
		boolean[] visited = new boolean[n+1];
		Queue<Chon> q = new LinkedList<>();
		
		Chon c = new Chon(src, 0);
		visited[src] = true;
		q.add(c);
		while(!q.isEmpty()) {
			Chon v = q.poll();
			for (int i = 0; i < relation[v.n].size(); i++) {
				int w = relation[v.n].get(i);
				
				if(w == dst) return v.dist+1;
				
				Chon tc = new Chon(w, v.dist+1);
				if(visited[w] == false) {
					visited[w] = true;
					q.add(tc);
				}
			}
		}
		return -1;
	}
}
