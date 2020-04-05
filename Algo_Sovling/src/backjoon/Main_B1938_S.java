package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_B1938_S {
	static class Log{
		int y;
		int x;
		// 0 ㅡ , 1 ㅣ
		int dir;
		int cnt;
		public Log(int y, int x, int dir, int cnt) {
			super();
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.cnt = cnt;
		}
		@Override
		public String toString() {
			return "Log [y=" + y + ", x=" + x + ", dir=" + dir + ", cnt=" + cnt + "]";
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static Log log = null;
	static Log eEE = null;
	static boolean[][][] check = null;
	static int[][] map = null;
	static int N = 0, totalCnt = 0;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		check = new boolean[N][N][2];
		int bCnt = 0, eCnt = 0;
		ArrayList<Log> clear = new ArrayList<>();
		for (int y = 0; y < N; y++) {
			String in = br.readLine();
			for (int x = 0; x < N; x++) {
				char ch = in.charAt(x);
				if(ch=='B') {
					map[y][x] = 2;
					clear.add(new Log(y, x, 0, 0));
					bCnt++;
					// 중심좌표
					if(bCnt==2) {
						if(x==0 || x==N-1 || map[y-1][x]==2) log = new Log(y, x, 1, 0);
						else if(y==0 || y==N-1 || map[y][x-1]==2) log = new Log(y, x, 0, 0);
					}
				}
				if(ch=='E') {
					map[y][x] = 3;
					clear.add(new Log(y, x, 0, 0));
					eCnt++;
					// 중심좌표
					if(eCnt==2) {
						if(x==0 || x==N-1 || map[y-1][x]==3) eEE = new Log(y, x, 1, 0);
						else if(y==0 || y==N-1 || map[y][x-1]==3) eEE = new Log(y, x, 0, 0);
					}
				}
				if(ch=='0') map[y][x] = 0;
				if(ch=='1') map[y][x] = 1;
			}
		}
		// 통나무, 목표 위치 clear
		for (Log log : clear) {
			map[log.y][log.x] = 0;
		}
//		for (int y = 0; y < N; y++) {
//			for (int x = 0; x < N; x++) {
//				bw.write(map[y][x]+"");
//			}
//			bw.write("\n");
//		}
//		bw.flush();
		
		
//		bw.write(log+"\n");
//		bw.write(eEE+"\n");
//		bw.flush();
		
//		while(true) {
//			String sss = br.readLine();
//			if(sss.charAt(0)=='w') {
//				boolean gFlg = check(log.y-1, log.x, log.dir, false);
//				if(gFlg) { log.y-=1; check[log.y][log.x][log.dir] = true; }
//				bw.write("w(↑):"+gFlg+"\n");
//			}
//			if(sss.charAt(0)=='s') {
//				boolean gFlg = check(log.y+1, log.x, log.dir, false);
//				if(gFlg) { log.y+=1; check[log.y][log.x][log.dir] = true; }
//				bw.write("s(↓):"+gFlg+"\n");
//			}
//			if(sss.charAt(0)=='a') {
//				boolean gFlg = check(log.y, log.x-1, log.dir, false);
//				if(gFlg) { log.x-=1; check[log.y][log.x][log.dir] = true; }
//				bw.write("a(←):"+gFlg+"\n");
//			}
//			if(sss.charAt(0)=='d') {
//				boolean gFlg = check(log.y, log.x+1, log.dir, false);
//				if(gFlg) { log.x+=1; check[log.y][log.x][log.dir] = true;  }
//				bw.write("d(→):"+gFlg+"\n");
//			}
//			if(sss.charAt(0)=='r') {
//				boolean gFlg = check(log.y, log.x, log.dir, true);
//				if(gFlg) { log.dir = (log.dir+1)%2; check[log.y][log.x][log.dir] = true; }
//				bw.write("r(◎):"+gFlg+"\n");
//			}
//			if(sss.charAt(0)=='q') break;
//			print(log);
//			bw.flush();
//		}
		
		bfs();
		
		bw.write(totalCnt+"");
		
		br.close();
		bw.close();
	} // end f:main
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
	// 0 ㅡ , 1 ㅣ
	public static void bfs() throws IOException {
		Queue<Log> q = new LinkedList<Main_B1938_S.Log>();
		q.add(log);
		check[log.y][log.x][log.dir] = true;
		while(!q.isEmpty()) {
			Log tLog = q.poll();
//			print(tLog);
//			System.in.read();
//			System.in.read();
			// 4방향
			for (int k = 0; k < 4; k++) {
				int ny = tLog.y+dy[k];
				int nx = tLog.x+dx[k];
				boolean flg = check(ny, nx, tLog.dir, false);
				if(flg) {
					if(isDest(ny, nx, tLog.dir)) {
						totalCnt = tLog.cnt+1;
						return;
					}
					check[ny][nx][tLog.dir] = true;
					q.add(new Log(ny, nx, tLog.dir, tLog.cnt+1));
				}
			}
			// 회전
			if(check(tLog.y, tLog.x, tLog.dir, true)) {
				if(isDest(tLog.y, tLog.x, (tLog.dir+1)%2)) {
					totalCnt = tLog.cnt+1;
					return;
				}
				check[tLog.y][tLog.x][(tLog.dir+1)%2] = true;
				q.add(new Log(tLog.y, tLog.x, (tLog.dir+1)%2, tLog.cnt+1));
			}
		}
		
	} // end f:bfs
	
	public static boolean isDest(int y, int x, int dir) {
		if(y==eEE.y && x==eEE.x && dir==eEE.dir) return true;
		else return false;
	}
	
	// 회전하는 경우 y,x 값은 기존 위치
	// 상하좌우로 이동하는 경우는 이동할 위치의 중심 좌표
	public static boolean check(int y, int x, int dir, boolean dirC) {
		
		// 방향 전환하는 경우
		if(dirC) {
			if(x<1 || x>=N-1 || y<1 || y>=N-1) return false;
			// 이미 해당 좌표에 방향 전환
			if(check[y][x][(dir+1)%2]) return false;
			
			for (int ty = y-1; ty <= y+1; ty++) {
				// 가로 방향일 때 위,아래만 확인
				if(dir==0 && ty==y) continue;
				for (int tx = x-1; tx <= x+1; tx++) {
					// 세로 방향일 때 좌,우만 확인
					if(dir==1 && tx==x) continue;
					if(map[ty][tx] != 0) {
						// 빈 공간이 아니라면
						return false;
					}
				}
			}
		// 이동하는 경우
		} else {
			if(x>=N || x<0 || y>=N || y<0) return false;
			// 이동하려는 좌표에 해당 방향으로 통나무가 있었던 적이 있으면 false
			if(check[y][x][dir]) return false;
			
			// 가로 통나무 이동
			if(dir==0) {
				if(x-1<0 || x+1>=N) return false;
				// 중심 좌표를 기준으로 양옆이 비어 있거나 통나무인 경우만 통과
				for (int tx = x-1; tx <= x+1; tx++) {
					if(map[y][tx] == 1) return false;
				}
			}
			// 세로 통나무 이동
			if(dir==1) {
				if(y-1<0 || y+1>=N) return false;
				// 중심 좌표를 기준으로 위,아래가 비어 있거나 통나무인 경우만 통과
				for (int ty = y-1; ty <= y+1; ty++) {
					if(map[ty][x] == 1) return false;
				}
			}
		}
		
		return true;
	}
	
	// 0 ㅡ , 1 ㅣ
	public static void print(Log lg) throws IOException {
		int[][] printMap = new int[N][N];
		for (int y = 0; y < N; y++) {
			printMap[y] = map[y].clone();
		}
		if(lg.dir==0) {
			printMap[lg.y][lg.x-1] = 2;
			printMap[lg.y][lg.x] = 2;
			printMap[lg.y][lg.x+1] = 2;
		}
		if(lg.dir==1) {
			printMap[lg.y-1][lg.x] = 2;
			printMap[lg.y][lg.x] = 2;
			printMap[lg.y+1][lg.x] = 2;
		}
		if(eEE.dir==0) {
			printMap[eEE.y][eEE.x-1] = 3;
			printMap[eEE.y][eEE.x] = 3;
			printMap[eEE.y][eEE.x+1] = 3;
		}
		if(eEE.dir==1) {
			printMap[eEE.y-1][eEE.x] = 3;
			printMap[eEE.y][eEE.x] = 3;
			printMap[eEE.y+1][eEE.x] = 3;
		}
		
		
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				if(printMap[y][x] == 0) bw.write("0");
				if(printMap[y][x] == 1) bw.write("1");
				if(printMap[y][x] == 2) bw.write("B");
				if(printMap[y][x] == 3) bw.write("E");
			}
			bw.write("\n");
		}
		bw.flush();
	}
}
