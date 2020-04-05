package jungol;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_J1103_S {
	static class Pos{
		int dir;
		int dist;
		int left;
		int right;
		int top;
		int down;
		public Pos(int dir, int dist) {
			this.dir = dir;
			this.dist = dist;
		}
		public Pos(int dir, int dist, int W, int H) {
			this.dir = dir;
			this.dist = dist;
			switch(dir) {
			case 1:
			case 2:
				this.left = dist;
				this.right = W-dist;
				break;
			case 3:
			case 4:
				this.top = dist;
				this.down = H-dist;
				break;
			}
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int W, H;
	static ArrayList<Pos> list;
	static int baseDir, baseDist;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		int N = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			list.add(new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), W, H));
		}
		st = new StringTokenizer(br.readLine());
		
		Pos base = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), W, H);
		
		
		int sum = 0;
		
		for (int i = 0; i < list.size(); i++) {
			Pos st = list.get(i);
			
			switch(base.dir) {
			case 1:
				if(st.dir == 1) {
					sum += Math.abs(base.dist - st.dist);
				} else if(st.dir == 2) {
					sum += Math.min(base.left + st.left, base.right + st.right) + H;
				} else if(st.dir == 3) {
					sum += base.left + st.top;
				} else {
					sum += base.right + st.top;
				}
				break;
			case 2:
				if(st.dir == 1) {
					sum += Math.min(base.left + st.left, base.right + st.right) + H;
				} else if(st.dir == 2) {
					sum += Math.abs(base.dist - st.dist);
				} else if(st.dir == 3) {
					sum += base.left + st.down;
				} else {
					sum += base.right + st.down;
				}
				break;
			case 3:
				if(st.dir == 1) {
					sum += base.top + st.left;
				} else if(st.dir == 2) {
					sum += base.down + st.left;
				} else if(st.dir == 3) {
					sum += Math.abs(base.dist - st.dist);
				} else {
					sum += Math.min(base.top + st.top, base.down + st.down) + W;
				}
				break;
			case 4:
				if(st.dir == 1) {
					sum += base.top + st.right;
				} else if(st.dir == 2) {
					sum += base.down + st.right;
				} else if(st.dir == 3) {
					sum += Math.min(base.top + st.top, base.down + st.down) + W;
				} else {
					sum += Math.abs(base.dist - st.dist);
				}
				break;
			}
			
			
		}
		
		bw.write(sum+"");
		
		br.close();
		bw.close();
	}
}
