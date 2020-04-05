package test.line190922;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_Q5 {
	static class Pos implements Comparable<Pos>{
		int x;
		int y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public int compareTo(Pos o) {
			return (x+y) - (o.x+o.y);
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int cH = Integer.parseInt(st.nextToken());
		int cW = Integer.parseInt(st.nextToken());
		
		if(cH >= H || cH < 0 || cW >= W || cW < 0) {
			bw.write("fail");
			bw.close();
			return;
		}
		int minDis = cW+cH;

		PriorityQueue<Pos> pq = new PriorityQueue<>();
		for (int y = 0; y < H; y++) {
			for (int x = 0; x < W; x++) {
				pq.add(new Pos(x, y));
			}
		}
		
		int[][] map = new int[H][W];
		while(!pq.isEmpty()) {
			Pos p = pq.poll();
			if(p.x == 0 || p.y == 0) map[p.y][p.x] = 1;
			else {
				map[p.y][p.x] = map[p.y-1][p.x] + map[p.y][p.x-1];
			}
		}
		bw.write(minDis+"\n"+map[cH][cW]+"");
		
		
		
		br.close();
		bw.close();
	}
}
