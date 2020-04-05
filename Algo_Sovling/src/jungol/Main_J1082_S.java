package jungol;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_J1082_S {
	static class Point{
		int x;
		int y;
		int dist;
		Point(int y, int x, int dist){
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int[][] map;
	static int R = 0;
	static int C = 0;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		ArrayList<Point> lavaSourList = new ArrayList<>();
		Point startPos = null;
		Point destPos = null;
		
		for (int i = 0; i < R; i++) {
			String in = br.readLine();
			for (int j = 0; j < C; j++) {
				if(in.charAt(j) == 'D') {
					map[i][j] = -4;
					destPos = new Point(i, j, 0);
				}
				else if(in.charAt(j) == '.') {
					map[i][j] = 9999;
				}
				else if(in.charAt(j) == '*') {
					map[i][j] = -1;
					lavaSourList.add(new Point(i, j, 0));
				}
				else if(in.charAt(j) == 'X') {
					map[i][j] = -2;
				}
				else if(in.charAt(j) == 'S') {
					map[i][j] = -3;
					startPos = new Point(i, j, 0);
				}
			}
		}
		makeMap(lavaSourList);
		
		int result = escape(startPos);
		if(result == -1) bw.write("impossible\n");
		else bw.write(result+"\n");
		
		br.close();
		bw.close();
	}
	
	private static int escape(Point startPos) {
		Queue<Point> q = new LinkedList<>();
		boolean[][] check = new boolean[R][C];
		Point pt = startPos;
		pt.dist = 0;
		check[pt.y][pt.x] = true;
		q.add(pt);
		while(!q.isEmpty()) {
			pt = q.poll();
			int dist = pt.dist;
			for (int k = 0; k < 4; k++) {
				int ny = pt.y + dy[k];
				int nx = pt.x + dx[k];
				if(ny>=0 && ny<R && nx>=0 && nx<C) {
					if(map[ny][nx] == -4) return dist+1;
					if(check[ny][nx] || map[ny][nx] < 0 || map[ny][nx] <= dist+1) continue;

					check[ny][nx] = true;
					Point tpt = new Point(ny, nx, dist+1);
					q.add(tpt);
				}
			}
		}
		return -1;
	}

	private static void makeMap(ArrayList<Point> lavaSourList) {
		for (int i = 0; i < lavaSourList.size(); i++) {
			Queue<Point> q = new LinkedList<>();
			boolean[][] check = new boolean[R][C];
			Point pt = lavaSourList.get(i);
			check[pt.y][pt.x] = true;
			q.add(pt);
			while(!q.isEmpty()) {
				pt = q.poll();
				int dist = pt.dist;
				for (int k = 0; k < 4; k++) {
					int ny = pt.y + dy[k];
					int nx = pt.x + dx[k];
					
					if(ny>=0 && ny<R && nx>=0 && nx<C) {
						if(check[ny][nx] || map[ny][nx] < 0) continue;
						
						if(map[ny][nx] > dist+1) map[ny][nx] = dist+1;
						check[ny][nx] = true;
						Point tpt = new Point(ny, nx, dist+1);
						q.add(tpt);
					}
				}
			}
		}
	}
}
