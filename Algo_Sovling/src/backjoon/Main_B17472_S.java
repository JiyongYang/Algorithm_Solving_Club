package backjoon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_B17472_S {
	static class Pos{
		int y;
		int x;
		int from;
		public Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
		
		public Pos(int y, int x, int from) {
			this(y, x);
			this.from = from;
		}
	}
	
	static class Bridge implements Comparable<Bridge>{
		int from;
		int to;
		int range;
		public Bridge(int from, int to, int range) {
			this.from = from;
			this.to = to;
			this.range = range;
		}
		@Override
		public int compareTo(Bridge o) {
			return range - o.range;
		}
		@Override
		public String toString() {
			return "Bridge [from=" + from + ", to=" + to + ", range=" + range + "]\n";
		}
	}
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	static int[][] map = null;
	static int[][] rMap = null;
	static int H, W;
	static int[] p;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		H = sc.nextInt();
		W = sc.nextInt();
		
		map = new int[H][W];
		rMap = new int[H][W];
		for (int y = 0; y < H; y++) {
			for (int x = 0; x < W; x++) {
				map[y][x] = sc.nextInt();
			}
		}
		
		int offset = 1;
		for (int y = 0; y < H; y++) {
			for (int x = 0; x < W; x++) {
				if(map[y][x] == 1 && rMap[y][x] == 0) bfs(map, rMap, new Pos(y, x), offset++);
			}
		}
		
//		for (int y = 0; y < H; y++) {
//			System.out.println(Arrays.toString(rMap[y]));
//		}
		
		ArrayList<Pos> list = new ArrayList<>();
		for (int y = 0; y < H; y++) {
			for (int x = 0; x < W; x++) {
				if(rMap[y][x] != 0) list.add(new Pos(y, x, rMap[y][x]));
			}
		}
		ArrayList<Bridge> bridges = new ArrayList<>();
		
		findBridge(list, bridges);
		
		Collections.sort(bridges);
//		System.out.println(bridges);
		
		p = new int[offset];
		for (int i = 0; i < offset; i++) {
			p[i] = i;
		}
		
		int bCnt = 0;
		int range = 0;
		for (int i = 0; i < bridges.size(); i++) {
			Bridge br = bridges.get(i);
			
			if(unionSet(br.from, br.to)) {
				range+=br.range;
//				System.out.println(range);
				bCnt++;
			}
		}
		if(bCnt == offset-2) System.out.println(range);
		else System.out.println(-1);
	}
	
	public static int findSet(int x) {
		if(x == p[x]) return x;
		else {
			int f = findSet(p[x]);
			p[x] = f;
			return p[x];
		}
	}
	
	public static boolean unionSet(int x, int y) {
		int tx = findSet(x);
		int ty = findSet(y);
		
		if(tx == ty) return false;
		else {
			if(x > y) p[tx] = ty;
			else p[ty] = tx;
		}
		return true;
	}
	
	
	public static void findBridge(ArrayList<Pos> list, ArrayList<Bridge> bridge) {
		for (int i = 0; i < list.size(); i++) {
			// 4 way check
			Pos base = list.get(i);
			for (int k = 0; k < 4; k++) {
				int range = -1;
				int offset = 1;
				while(true) {
					range++;
					int ny = base.y + dy[k]*(offset);
					int nx = base.x + dx[k]*(offset++);
					// 범위 초과
					if(ny >= H || ny < 0 || nx >= W || nx < 0) break;
					// 같은 섬
					if(rMap[ny][nx] == base.from) break;
					
					// 바다
					if(rMap[ny][nx] == 0) continue;
					// 거리가 2 이하는 제외
					if(range <= 1 && rMap[ny][nx] != 0) break;
					if(range <= 1) continue;
					
					bridge.add(new Bridge(base.from, rMap[ny][nx], range));
					break;
				}
			}
		}
	}
	
	public static void bfs(int[][] base, int[][] map, Pos s, int idx) {
		Queue<Pos> q = new LinkedList<>();
		
		q.add(s);
		map[s.y][s.x] = idx;
		while(!q.isEmpty()) {
			Pos tp = q.poll();
			for (int k = 0; k < 4; k++) {
				int ny = tp.y + dy[k];
				int nx = tp.x + dx[k];
				
				if(ny >= H || ny < 0 || nx >= W || nx < 0) continue;
				if(map[ny][nx] != 0 || base[ny][nx] == 0) continue;
				
				map[ny][nx] = idx;
				q.add(new Pos(ny, nx));
			}
		}
	}
	
}
