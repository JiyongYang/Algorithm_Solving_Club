package swea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_S1258_S {
	static class Area implements Comparable<Area> {
		int height;
		int width;

		public Area(int height, int width) {
			super();
			this.height = height;
			this.width = width;
		}

		@Override
		public int compareTo(Area o) {
			if((height * width) == (o.height * o.width)) {
				return height - o.height;
			}
			return (height * width) - (o.height * o.width);
		}

		@Override
		public String toString() {
			return "Area [height=" + height + ", width=" + width + "]";
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int N = 0;
	static int[][] map = null;
	static int[] dx = { 1, 0, -1, 0};
	static int[] dy = { 0, 1, 0, -1};
	static int areaCnt = 0;
	static ArrayList<Area> list = null;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			areaCnt = 0;
			list = new ArrayList<>();
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int y = 0; y < N; y++) {
				st = new StringTokenizer(br.readLine());
				for (int x = 0; x < N; x++) {
					map[y][x] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			boolean[][] checkArea = new boolean[N][N];
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					if(map[y][x] == 0 || checkArea[y][x]) continue;
					bfs(y, x, checkArea);
				}
			}
			Collections.sort(list);
			bw.write("#"+t+" "+list.size()+" ");
			for (Area ar : list) {
				bw.write(ar.height+" "+ar.width+" ");
			}
			bw.write("\n");
		}
		br.close();
		bw.close();
	}

	public static void bfs(int y, int x, boolean[][] checkArea) {
		boolean[][] check = new boolean[N][N];
		Queue<Area> q = new LinkedList<>();
		int rCnt = 1;
		int dCnt = 1;
		check[y][x] = true;
		q.add(new Area(y, x));
		// right dir
		while (!q.isEmpty()) {
			Area ar = q.poll();
			int ny = ar.height + dy[0];
			int nx = ar.width + dx[0];
			if (ny >= N || ny < 0 || nx >= N || nx < 0 
					|| map[ny][nx]==0 || check[ny][nx]) continue;
			check[ny][nx] = true;
			q.add(new Area(ny, nx));
			rCnt++;
		}
		q.add(new Area(y, x));
		// down dir
		while (!q.isEmpty()) {
			Area ar = q.poll();
			int ny = ar.height + dy[1];
			int nx = ar.width + dx[1];
			if (ny >= N || ny < 0 || nx >= N || nx < 0 
					|| map[ny][nx]==0 || check[ny][nx]) continue;
			check[ny][nx] = true;
			q.add(new Area(ny, nx));
			dCnt++;
		}
		list.add(new Area(dCnt, rCnt));
		
		q.clear();
		checkArea[y][x] = true;
		q.add(new Area(y,x));
		while(!q.isEmpty()) {
			Area ar = q.poll();
			for (int k = 0; k < 4; k++) {
				int ny = ar.height + dy[k];
				int nx = ar.width + dx[k];
				if (ny >= N || ny < 0 || nx >= N || nx < 0 
						|| map[ny][nx]==0 || checkArea[ny][nx]) continue;
				checkArea[ny][nx] = true;
				q.add(new Area(ny, nx));
			}
		}
	}
}
