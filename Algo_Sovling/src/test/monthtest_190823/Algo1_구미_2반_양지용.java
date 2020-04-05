package test.monthtest_190823;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Algo1_구미_2반_양지용 {
	static class Point{
		int y;
		int x;
		Point(int y, int x){
			this.y=y;
			this.x=x;
		}
		@Override
		public String toString() {
			return "G [" + y + ", " + x + "]";
		}
		
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static final int dx[] = {1, 0, -1, 0};
	static final int dy[] = {0, 1, 0, -1};
	static int[][] map = null;
	static int H = 0, W = 0;
	static int tCnt = 0;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			ArrayList<Point> gList = new ArrayList<>();
			String s = "";
			tCnt = 0;
			int in = 0;
			// 0 빈칸, -1 벽, 1 총잡이, 2 목표물
			for (int y = 0; y < H; y++) {
				st = new StringTokenizer(br.readLine());
				for (int x = 0; x < W; x++) {
					s = st.nextToken().trim();
					switch (s.charAt(0)) {
					case 'T':
						in = 2;
						break;
					case '0':
						in = 0;
						break;
					case 'G':
						gList.add(new Point(y, x));
						in = 1;
						break;
					case 'W':
						in = -1;
						break;
					default:
						bw.write(s.charAt(0)+" Input Error\n");
						break;
					}
					map[y][x] = in;
				}
			}
			
			run(gList);
			
			bw.write("#"+t+" "+tCnt+"\n");
			bw.flush();
		}
		
		
		br.close();
		bw.close();
	}
	
	// 0 빈칸, -1 벽, 1 총잡이, 2 목표물
	public static void run(ArrayList<Point> gList) throws IOException {
		for (Point pt : gList) {
			for (int k = 0; k < 4; k++) {
				Point temp = new Point(pt.y, pt.x);
				while(true) {
					int ny = temp.y+dy[k];
					int nx = temp.x+dx[k];
					temp.y = ny;
					temp.x = nx;
					if(ny >= 0 && ny < H && nx >= 0 && nx < W) {
						// 벽이나 총잡이를 만나면 다음 방향 확인
						if(map[ny][nx] == 1 || map[ny][nx] == -1) break;
						// 목표물을 만나면 증가 시키고 종료
						if(map[ny][nx] == 2) {
							map[ny][nx] = 1;
							tCnt++;
							break;
						}
					} else {
						break;
					}
				}
			}
		}
	}
}
