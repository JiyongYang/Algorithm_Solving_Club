package backjoon;
import java.io.*;
import java.util.*;
import java.lang.*;


public class Main_B17142_S {
	static class Pos{
		int y;
		int x;
		int d;
		public Pos(int y, int x, int d) {
			this.y = y;
			this.x = x;
			this.d = d;
		}
	}
	
	static int N, M;
	static int cnt_two = 0;
	static int[][] map = null;
	static ArrayList<Pos> list = null;
	static int minVal = Integer.MAX_VALUE;
	static int unreachableCase = 0;
	static int totalCase = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][N];
		list = new ArrayList<>();
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				map[y][x] = sc.nextInt();
				if(map[y][x] == 2) {
					cnt_two++;
					list.add(new Pos(y, x, 0));
				}
				if(map[y][x] == 1) map[y][x] = -1;
				if(map[y][x] == 2) map[y][x] = -2;
				if(map[y][x] == 0) map[y][x] = -9;
			}
		}
		
		ArrayList<Integer> arr = new ArrayList<>();
		boolean[] check = new boolean[cnt_two];
		
		permu(arr, check, 0);
		
		if(unreachableCase == totalCase) System.out.println(-1);
		else System.out.println(minVal);
	}

	
	public static void permu(ArrayList<Integer> arr, boolean[] check, int s) {
		if(arr.size() == M) {
			totalCase++;
			int[][] tmap = new int[N][N];
			for (int i = 0; i < tmap.length; i++) {
				tmap[i] = map[i].clone();
			}
			dfs(arr, tmap);
			return;
		}
		
		for (int i = s; i < check.length; i++) {
			if(check[i]) continue;
			check[i] = true;
			arr.add(i);
			permu(arr, check, i+1);
			arr.remove(arr.size()-1);
			check[i] = false;
		}
	}
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void dfs(ArrayList<Integer> arr, int[][] tmap) {
		for (Integer i : arr) {
			Pos t = list.get(i);
			bfs(t, tmap);
		}
		
		for (Pos t : list) {
			tmap[t.y][t.x] = -2;
		}
		
		int maxVal = 0;
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if(tmap[y][x] == -9) {
					unreachableCase++;
					return;
				}
				if(tmap[y][x] > 0 && tmap[y][x] > maxVal) maxVal = tmap[y][x];
			}
		}
		
		if(maxVal < minVal) {
			minVal = maxVal;
		}
	}
	
	public static void print(int[][] tmap) {
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if(tmap[y][x] == -1) System.out.print("■ ");
				else if(tmap[y][x] == -2) System.out.print("* ");
				else System.out.print(tmap[y][x]+" ");
			}
			System.out.println();
		}
	}
	
	public static void bfs(Pos p, int[][] tmap) {
		boolean[][] check = new boolean[N][N];
		Queue<Pos> q = new LinkedList<>();
		q.add(p);
		check[p.y][p.x] = true;
		tmap[p.y][p.x] = p.d;
		while(!q.isEmpty()) {
			Pos t = q.poll();
			
			for (int k = 0; k < 4; k++) {
				int ny = t.y + dy[k];
				int nx = t.x + dx[k];
				if(ny >= N || ny < 0 || nx >= N || nx < 0 || check[ny][nx] ) continue;
				if(tmap[ny][nx] != -9 && tmap[ny][nx] != -2 && tmap[ny][nx] < 0) continue;
				if(tmap[ny][nx] >= 0 && tmap[ny][nx] <= t.d+1) continue;
				
				check[ny][nx] = true;
				tmap[ny][nx] = t.d+1;
				q.add(new Pos(ny, nx, t.d+1));
			}
		}
	}
}
