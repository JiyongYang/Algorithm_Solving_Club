package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_B8983_S {
	static class Pos implements Comparable<Pos>{
		int y;
		int x;
		public Pos(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		@Override
		public int compareTo(Pos o) {
			return this.x==o.x ? this.y-o.y : this.x-o.x;
		}
		@Override
		public String toString() {
			return "P(" + x + ", " + y + ")";
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int M = 0, N = 0, L = 0;
	static Pos[] animal = null;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		int[] shot = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			shot[i] = (Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(shot);
		
		animal = new Pos[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			animal[i] = new Pos(y , x);
		}
		Arrays.sort(animal);
		int cnt = 0;
		int offset = 0;
		for (int i = 0; i < N; i++) {
			while(offset != M-1 && shot[offset+1] < animal[i].x) {
				offset++;
			}
			if(Math.abs(shot[offset] - animal[i].x)+animal[i].y <= L) {
				cnt++;
				continue;
			}
			if(offset != M-1) {
				if(Math.abs(shot[offset+1] - animal[i].x)+animal[i].y <= L) {
					cnt++;
					continue;
				}
			}
		}
		
		bw.write(cnt+"");
		
		br.close();
		bw.close();
	}
}
