package swea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_S1953_S {
	static class Pos {
		int y;
		int x;
		int dist;
		public Pos(int y, int x, int dist) {
			this.y = y;
			this.x = x;
			this.dist = dist;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int[][] map = null;
	static int N = 0, M = 0, L = 0;
	static Pos start = null;
	static final int[][][] delta = { { { 0, 0 } }, // 없음
			{ { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }, // 1 상하좌우
			{ { -1, 0 }, { 1, 0 }, { 0, 0  }, { 0, 0 } }, // 2 상하
			{ {  0, 0 }, { 0, 0 }, { 0, -1 }, { 0, 1 } }, // 3 좌우
			{ { -1, 0 }, { 0, 0 }, { 0, 0  }, { 0, 1 } }, // 4 상우
			{ {  0, 0 }, { 1, 0 }, { 0, 0  }, { 0, 1 } }, // 5 하우
			{ {  0, 0 }, { 1, 0 }, { 0, -1 }, { 0, 0 } }, // 6 하좌
			{ { -1, 0 }, { 0, 0 }, { 0, -1 }, { 0, 0 } }  // 7 상좌
	};
	static final int[][][] possibleDir = {
			//0	  1				2			  3				4			  5				6			  7
	 /*0*/	{{0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}},
	 /*1*/	{{0}, {1, 1, 1, 1}, {1, 1, 0, 0}, {0, 0, 1, 1}, {0, 1, 1, 0}, {1, 0, 1, 0}, {1, 0, 0, 1}, {0, 1, 0, 1}},
	 /*2*/	{{0}, {1, 1, 0, 0}, {1, 1, 0, 0}, {0, 0, 0, 0}, {0, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 0}, {0, 1, 0, 0}},
	 /*3*/	{{0}, {0, 0, 1, 1}, {0, 0, 0, 0}, {0, 0, 1, 1}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}},
	 /*4*/	{{0}, {1, 0, 0, 1}, {1, 0, 0, 0}, {0, 0, 0, 1}, {0, 0, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}},
	 /*5*/	{{0}, {0, 1, 0, 1}, {0, 1, 0, 0}, {0, 0, 0, 1}, {0, 1, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 1}, {0, 1, 0, 1}},
	 /*6*/	{{0}, {0, 1, 1, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 0}},
	 /*7*/	{{0}, {1, 0, 1, 0}, {1, 0, 0, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {1, 0, 1, 0}, {1, 0, 0, 0}, {0, 0, 0, 0}}
	};

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine().trim());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			start = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 1);
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			
			for (int y = 0; y < N; y++) {
				st = new StringTokenizer(br.readLine());
				for (int x = 0; x < M; x++) {
					map[y][x] = Integer.parseInt(st.nextToken());
				}
			}

			bw.write("#" + t + " " +bfs()+ "\n");
		}

		br.close();
		bw.close();
	}

	public static void print(boolean[][] check) {
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				if (check[y][x]) System.out.print("1 ");
				else System.out.print("0 ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static int bfs() {
		int cnt = 0;
		Queue<Pos> q = new LinkedList<Solution_S1953_S.Pos>();
		boolean[][] check = new boolean[N][M];
		q.add(start);
		check[start.y][start.x] = true;
		cnt++;
		while (!q.isEmpty()) {
			Pos bs = q.poll();
			int dir = map[bs.y][bs.x];
			if (bs.dist >= L) continue;

			for (int k = 0; k < delta[dir].length; k++) {
				int ny = bs.y + delta[dir][k][0];
				int nx = bs.x + delta[dir][k][1];
				
				if (ny >= N || ny < 0 || nx >= M || nx < 0 || 
						map[ny][nx] == 0 || check[ny][nx])	continue;
				// 갈수 있는 길인지 확인
				if(possibleDir[dir][map[ny][nx]][k] == 0) continue;
				
				cnt++;
				check[ny][nx] = true;
				q.add(new Pos(ny, nx, bs.dist+1));
			}
		}
		return cnt;
	}
}
