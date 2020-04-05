package unsolved;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution_djisktra {
	static class Island{
		int id;
		int y;
		int x;
		Island(int y, int x){
			this.id = pid++;
			this.y = y;
			this.x = x;
		}
		@Override
		public String toString() {
			return "[id=" + id + ", (" + y + ", " + x + ")]";
		}
		
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static StringTokenizer st2 = null;
	static int N = 0;
	static double E = 0;
	static int pid = 0;
	static Island[] islands = null;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			st2 = new StringTokenizer(br.readLine());
			islands = new Island[N];
			for (int i = 0; i < N; i++) {
				islands[i] = new Island(Integer.parseInt(st.nextToken()), 
						Integer.parseInt(st2.nextToken()));
			}
			
			E = Double.parseDouble(br.readLine());
			System.out.println(Arrays.toString(islands));
			int[] Dist = new int[N];
			
			Dijkstra(islands[0], Dist);
			
			bw.write("#"+t+" "+"\n");
		}
		
		bw.close();
		br.close();
	}
	
	public static void Dijkstra(Island s, int[] Dist) {
		boolean[] check = new boolean[N];
		check[s.id] = true;
		int cnt = 1;
		HashSet<Integer> U = new HashSet<>();
		U.add(s.id);
		
		for (int i = 0; i < N; i++) {
			if(islands[i].id == s.id) {
				Dist[i] = -1;
				continue;
			}
			Dist[i] = Distance(s, islands[i]);
		}
		System.out.println(Arrays.toString(Dist));
		
		while(U.size() != N) {
			System.out.println("!!");
			Island closestIsl = null;
			int minDist = Integer.MAX_VALUE;
			for (int i = 0; i < Dist.length; i++) {
				if(check[i]) continue;
				if(Dist[i] < minDist) {
					minDist = Dist[i];
					closestIsl = islands[i];
				}
			}
			
			check[closestIsl.id] = true;
//			U.add(Distance(closestIsl, s));
			
			for (int i = 0; i < N; i++) {
				// ?
//				if(U.contains(i)) continue;
//				Dist[i] = Math.min(Dist[i], Dist[closestIsl.id]+Distance(closestIsl, islands[i]));
				if(Dist[i] >= Dist[closestIsl.id]+Distance(closestIsl, islands[i])) {
					Dist[i] = Math.min(Dist[i], Dist[closestIsl.id]+Distance(closestIsl, islands[i]));
					U.add(Distance(closestIsl, islands[i]));
					System.out.println("??");
				}
				
			}
			
//			System.out.println(closestIsl);
			System.out.println(U);
		}
	}
	
	public static int Distance(Island s, Island s2) {
		return Math.abs(s.y - s2.y) + Math.abs(s.x - s2.x);
	}
}
