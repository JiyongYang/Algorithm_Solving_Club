package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_B15644_S {
	static class Pos{
		int y;
		int x;
		public Pos(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		@Override
		protected Pos clone() {
			return new Pos(y, x);
		}
		@Override
		public String toString() {
			return "(" + y + ", " + x + ")";
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int[][] map = null;
	static Pos goal = null;
	static boolean flgS = false;
	static int N = 0, M = 0, minCnt = 11;
	static StringBuilder stSb = null;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		Pos blue = null, red = null;
		for (int y = 0; y < N; y++) {
			String s = br.readLine();
			for (int x = 0; x < M; x++) {
				char in = s.charAt(x);
				if(in=='#') map[y][x] = 1;
				if(in=='.') map[y][x] = 0;
				if(in=='B') blue = new Pos(y, x);
				if(in=='R') red = new Pos(y, x);
				if(in=='O') {
					goal = new Pos(y, x);
					map[y][x] = 4;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			run(red, blue, 0, i, sb);
		}
		
		if(minCnt == 11) bw.write(-1+"");
		else bw.write((minCnt+1)+"\n"+stSb.toString());
		br.close();
		bw.close();
	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	
	public static void printMap(Pos red, Pos blue) throws IOException {
		int[][] pMap = new int[N][M];
		for (int i = 0; i < map.length; i++) {
			pMap[i] = map[i].clone();
		}
		if(red.y == -1)	red = goal.clone();
		pMap[red.y][red.x] = 3;
		pMap[blue.y][blue.x] = 2;
		
		for (int i = 0; i < pMap.length; i++) {
			for (int j = 0; j < pMap[i].length; j++) {
				if(pMap[i][j] == 0) bw.write(".");
				if(pMap[i][j] == 1) bw.write("#");
				if(pMap[i][j] == 2) bw.write("B");
				if(pMap[i][j] == 3) bw.write("R");
				if(pMap[i][j] == 4) bw.write("O");
			}
			bw.write("\n");
		}
		bw.flush();
//		System.in.read();
//		System.in.read();
	}
	
	// 0 l, 1 r, 2 d, 3 u
	public static void markDir(int dir, StringBuilder sb) {
		if(dir == 0) sb.append("L");
		if(dir == 1) sb.append("R");
		if(dir == 2) sb.append("D");
		if(dir == 3) sb.append("U");
	}
	
	
	public static void run(Pos red, Pos blue, int depth, int dir, StringBuilder sb) throws IOException {
		if(depth == 10) {
			return;
		}
		
		Pos tRed = red.clone();
		Pos tBlue = blue.clone();
		StringBuilder tSb = new StringBuilder(sb.toString());
		for (int i = 0; i < 4; i++) {
			if(i == dir) continue;
			markDir(i, tSb);
			boolean result = check(tRed, tBlue, i, depth);
			if(flgS && minCnt > depth) {
				minCnt = depth; 
				stSb = new StringBuilder(tSb.toString());
//				bw.write("R:"+tRed+" B:"+tBlue+" D:"+depth+"/"+minCnt+" dir:"+dir+" r:"+result+" fs:"+flgS+"\n");
//				printMap(tRed, tBlue);
			}
			flgS = false;
			if(result) run(tRed, tBlue, depth+1, i, tSb);
			tRed = red.clone();
			tBlue = blue.clone();
			tSb = new StringBuilder(sb.toString());
		}
	}
	
	
	public static boolean moveRed(Pos red, Pos blue, int dir) throws IOException {
		int ny = 0, nx = 0;
		while(true) {
			ny = red.y+dy[dir];
			nx = red.x+dx[dir];
			// 이미 가고자 한 곳에 해당 구슬이 있으면 멈춤
			if(blue.y == ny && blue.x == nx) break;
			if(map[ny][nx] == 1) break;
			if(map[ny][nx] == 4) {
				// 목표를 만난 경우
				flgS = true;
				red.y = -1;
				red.x = -1;
				return false;
//				break;
			}
			red.y = ny;
			red.x = nx;
			if(map[ny][nx] == 0) continue;
			if(map[ny][nx] != 0) break;
		}
		return true;
	}
	
	public static boolean moveBlue(Pos red, Pos blue, int dir) throws IOException {
		int ny = 0, nx = 0;
		while(true) {
			ny = blue.y+dy[dir];
			nx = blue.x+dx[dir];
			// 이미 가고자 한 곳에 해당 구슬이 있으면 멈춤
			if(red.y == ny && red.x == nx) break;
			if(map[ny][nx] == 1) break;
			if(map[ny][nx] == 4) {
				// 목표를 만난 경우
				if(flgS && red.x == -1) {
					flgS = false;
				}
				blue.y = ny;
				blue.x = nx;
				return false;
			}
			blue.y = ny;
			blue.x = nx;
			if(map[ny][nx] == 0) continue;
			if(map[ny][nx] != 0) break;
		}
		return true;
	}
	
	
	public static boolean check(Pos red, Pos blue, int dir, int depth) throws IOException {
		boolean rFlg = true, bFlg = true;
		if (dir == 0 || dir == 1) {
			if (red.y == blue.y) {
				// 같은 라인인 경우
				if (red.x < blue.x) {
					// red가 더 왼쪽인 경우
					if (dir == 0) {
						// 기울인 방향이 왼쪽인 경우
						rFlg = moveRed(red, blue, dir);
						bFlg = moveBlue(red, blue, dir);
					}
					if (dir == 1) {
						// 기울인 방향이 오른쪽인 경우
						bFlg = moveBlue(red, blue, dir);
						rFlg = moveRed(red, blue, dir);
					}
				} else {
					// blue가 더 왼족인 경우
					if (dir == 0) {
						// 기울인 방향이 왼쪽인 경우
						bFlg = moveBlue(red, blue, dir);
						rFlg = moveRed(red, blue, dir);
					}
					if (dir == 1) {
						// 기울인 방향이 오른쪽인 경우
						rFlg = moveRed(red, blue, dir);
						bFlg = moveBlue(red, blue, dir);
					}
				}
			} else {
				// 다른 라인인 경우
				// 빨간공
				rFlg = moveRed(red, blue, dir);
				// 파란공
				bFlg = moveBlue(red, blue, dir);
			}
		} else {
			if (red.x == blue.x) {
				// 같은 라인인 경우
				if (red.y < blue.y) {
					// red가 더 위쪽인 경우
					if (dir == 2) {
						// 기울인 방향이 아래인 경우
						bFlg = moveBlue(red, blue, dir);
						rFlg = moveRed(red, blue, dir);
					}
					if (dir == 3) {
						// 기울인 방향이 위쪽인 경우
						rFlg = moveRed(red, blue, dir);
						bFlg = moveBlue(red, blue, dir);
					}
				} else {
					// blue가 더 위족인 경우
					if (dir == 2) {
						// 기울인 방향이 아래인 경우
						rFlg = moveRed(red, blue, dir);
						bFlg = moveBlue(red, blue, dir);
					}
					if (dir == 3) {
						// 기울인 방향이 위쪽인 경우
						bFlg = moveBlue(red, blue, dir);
						rFlg = moveRed(red, blue, dir);
					}
				}
			} else {
				// 다른 라인인 경우
				// 빨간공
				rFlg = moveRed(red, blue, dir);
				// 파란공
				bFlg = moveBlue(red, blue, dir);
			}
		}
		return rFlg && bFlg;
	}
}
