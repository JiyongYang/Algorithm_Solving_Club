package swea;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Solution_S5656_S {
	static class Pos{
		int y;
		int x;
		int d;
		public Pos(int y, int x, int d) {
			super();
			this.y = y;
			this.x = x;
			this.d = d;
		}
	}
	
	static int N, W, H;
	static int[][] map = null;
	static int cnt = 0;
	static int minCnt = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			W = sc.nextInt();
			H = sc.nextInt();
			cnt = 0;
			minCnt = Integer.MAX_VALUE;
			
			map = new int[H][W];			
			for (int y = 0; y < H; y++) {
				for (int x = 0; x < W; x++) {
					map[y][x] = sc.nextInt();
					if(map[y][x] != 0) cnt++;
				}
			}
			ArrayList<Integer> arr = new ArrayList<>();
			dfs(arr);
			
			
			System.out.println("#"+t+" "+minCnt);
		}
	}
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void run(ArrayList<Integer> arr) {
		int[][] temp = new int[H][W];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = map[i].clone();
		}
		
		int tempCnt = 0;
		boolean flg = false;
		
		Queue<Pos> q = new LinkedList<>();
//		print(temp);
		for (int i = 0; i < arr.size(); i++) {
			int sW = arr.get(i);
			int sH = 0;
			while(sH < H && temp[sH][sW] == 0) {
				sH++;
			}
			if(sH == H) continue;
//			System.out.println("sH:: "+sH);
			flg = true;
			boolean[][] check = new boolean[H][W];
			check[sH][sW] = true;
			q.add(new Pos(sH, sW, temp[sH][sW]));
			while(!q.isEmpty()) {
				Pos tp = q.poll();
				for (int k = 0; k < 4; k++) {
					for (int d = 1; d < tp.d; d++) {
						int ny = tp.y + dy[k]*d;
						int nx = tp.x + dx[k]*d;
						
						if(ny >= H || ny < 0 || nx >= W || nx < 0) continue;
						if(check[ny][nx]) continue;
						check[ny][nx] = true;
						q.add(new Pos(ny, nx, temp[ny][nx]));
						
					}
				}
			}
			tempCnt = 0;
			// temp 맵 밑으로 밀기
			
			Stack<Integer> stack = null;
			for (int x = 0; x < W; x++) {
				stack = new Stack<>();
				for (int y = 0; y < H; y++) {
					if(!check[y][x] && temp[y][x]!=0) stack.add(temp[y][x]);
					temp[y][x] = 0;
				}
				tempCnt+=stack.size();
				
				int offset = H-1;
				while(!stack.isEmpty()) {
					temp[offset--][x] = stack.pop();
				}
			}
		}
//		System.out.println("---------");
//		print(temp);
//		System.out.println(tempCnt);
		
		if(flg && minCnt > tempCnt) minCnt = tempCnt;
		
		
	}
	
	public static void print(int[][] map) {
		for (int y = 0; y < H; y++) {
			for (int x = 0; x < W; x++) {
				System.out.print(map[y][x]+" ");
			}
			System.out.println();
		}
	}
	
	public static void dfs(ArrayList<Integer> arr) {
		if(arr.size() == N) {
//			System.out.println(arr);
			run(arr);
			return;
		}
		
		for (int i = 0; i < W; i++) {
			arr.add(i);
			dfs(arr);
			arr.remove(arr.size()-1);
		}
	}
}
