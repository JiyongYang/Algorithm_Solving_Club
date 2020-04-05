package swea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_S3289_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] p = new int[n+1];
			makeSet(p);
			
			bw.write("#"+t+" ");
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken());
				int xSet = Integer.parseInt(st.nextToken());
				int ySet = Integer.parseInt(st.nextToken());
				if(op == 0) unionSet(xSet, ySet, p);
				if(op == 1) bw.write(checkSet(xSet, ySet, p)+"");
			}
			bw.write("\n");
		}
		
		br.close();
		bw.close();
	}
	
	static int checkSet(int x, int y, int[] p) {
		if(p[findSet(x, p)] == p[findSet(y, p)]) return 1;
		return 0;
	}
	
	static void unionSet(int x, int y, int[] p) {
		int fy = y;
		x = findSet(x, p);
		y = findSet(y, p);
		if(x != y) {
			p[y] = x;
			findSet(fy, p);
		}
	}
	
	static int findSet(int x, int[] p) {
		if(x == p[x]) return x;
		else {
			int r = findSet(p[x], p);
			p[x] = r;
			return r;
		}
	}
	
	static void makeSet(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i;
		}
	}
}
