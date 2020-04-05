package swea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_S8424_S {
	static class Edge{
		int from;
		int to;
		public Edge(int from, int to) {
			super();
			this.from = from;
			this.to = to;
		}
		@Override
		public String toString() {
			return "Edge [" + from + " >> " + to + "]\n";
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + from;
			return result;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			Edge other = (Edge) obj;
			if (from == other.from && to == other.to)
				return true;
			if (from == other.to && to == other.from)
				return true;
			return false;
		}
		
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int N = 0;
	static ArrayList<Edge>[] vertices = null;
	static boolean flg = false;
	static boolean[] check = null;
	static int cId = 0;
	static ArrayList<Edge> list = null;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			flg = false;
			cId = 0;
			N = Integer.parseInt(br.readLine());
			check = new boolean[N+1];
			vertices = new ArrayList[N+1];
			list = new ArrayList<>();
			for (int i = 1; i < N+1; i++) {
				vertices[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				vertices[from].add(new Edge(from, to));
				vertices[to].add(new Edge(to, from));
			}
			
//			System.out.println(Arrays.toString(vertices));
			dfs(1, t);
		}
		
		br.close();
		bw.close();
	}
	
	public static void dfs(int id, int testcase) throws IOException {
//		System.out.println("call dfs("+id+")");
		check[id] = true;
		if(flg) return;
		
		for (int ei = 0; ei < vertices[id].size(); ei++) {
			int dst = vertices[id].get(ei).to;
//			System.out.print("dst:: "+dst);
			if(check[dst] && list.contains(vertices[id].get(ei))) {
//				System.out.println(" -- continue");
				continue;
			}
			if(!check[dst]) {
//				System.out.println(" -- recursive dfs("+dst+") call");
				check[dst] = true;
				list.add(vertices[id].get(ei));
				dfs(dst, testcase);
				if(list.size() > 0) list.remove(list.size()-1);
//				System.out.println(" -- recursive dfs("+dst+") call -- back");
			} else {
				if(flg) return;
//				System.out.println(" -- END size:"+list.size()+" E="+list.toString());
				flg = true;
				int cnt = 0;
				while(!list.isEmpty()) {
					Edge e = list.remove(list.size()-1);
					if(e.to == dst) break;
					cnt++;
				}
				
				bw.write("#"+testcase+" "+(cnt+1)+"\n");
			}
		}
	}
}
