package swea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_S4014_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int N = 0, X = 0;
	static int[][] map = null;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			for (int y = 0; y < N; y++) {
				st = new StringTokenizer(br.readLine());
				for (int x = 0; x < N; x++) {
					map[y][x] = Integer.parseInt(st.nextToken());
				}
			}

			int cnt = 0;
			for (int dt = 0; dt < N; dt++) {
				if (check(dt, 0, 0)) cnt++;
				if (check(0, dt, 1)) cnt++;
			}
			bw.write("#" + t + " " + cnt + "\n");
			bw.flush();
		}
		br.close();
		bw.close();
	}

	public static boolean check(int y, int x, int dir) {
		boolean[] check = new boolean[N];
		// horizontal
		if (dir == 0) {
			for (int nx = 0; nx < N; nx++) {
				if (nx + 1 < N && map[y][nx] != map[y][nx + 1]) {
					// 값이 다른 경우
					// 현재 위치 값이 더 작은 경우
					if (map[y][nx] + 1 == map[y][nx + 1]) {
						// 맵의 사이즈를 벗어나는 경우
						if (nx - X + 1 < 0)	return false;
						for (int d = 0; d < X; d++) {
							if (check[nx - d] || map[y][nx - d] + 1 != map[y][nx + 1]) return false;
						}
						for (int d = 0; d < X; d++) {
							check[nx - d] = true;
						}
						// 뒤에 값이 더 작은 경우
					} else if (map[y][nx] == map[y][nx + 1] + 1) {
						// 맵의 사이즈를 벗어나는 경우
						if (nx + X >= N) return false;

						for (int d = 1; d <= X; d++) {
							if (check[nx + d] || map[y][nx + d] + 1 != map[y][nx]) return false;
						}
						for (int d = 1; d <= X; d++) 
							check[nx + d] = true;
					} else 
						return false;
				}
			}
			// vertical
		} else {
			for (int ny = 0; ny < N; ny++) {
				if (ny + 1 < N && map[ny][x] != map[ny + 1][x]) {
					// 값이 다른 경우
					// 현재 위치 값이 더 작은 경우
					if (map[ny][x] + 1 == map[ny + 1][x]) {
						// 맵의 사이즈를 벗어나는 경우
						if (ny - X + 1 < 0) return false;
						for (int d = 0; d < X; d++) {
							if (check[ny - d] || map[ny - d][x] + 1 != map[ny + 1][x]) return false;
						}
						for (int d = 0; d < X; d++) 
							check[ny - d] = true;
						// 뒤에 값이 더 작은 경우
					} else if (map[ny][x] == map[ny + 1][x] + 1) {
						// 맵의 사이즈를 벗어나는 경우
						if (ny + X >= N) return false;

						for (int d = 1; d <= X; d++) {
							if (check[ny + d] || map[ny + d][x] + 1 != map[ny][x]) return false;
						}
						for (int d = 1; d <= X; d++) 
							check[ny + d] = true;
					} else {
						return false;
					}
				}
			}
		}
		return true;
	}
}
