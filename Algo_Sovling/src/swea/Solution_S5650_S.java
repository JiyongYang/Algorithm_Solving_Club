package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Point{
	public int x;
	public int y;
	Point(int y, int x){
		this.x = x;
		this.y = y;
	}
}

public class Solution_S5650_S {
	static final int[] dx = {1, 0, -1, 0};
	static final int[] dy = {0, -1, 0, 1};
	static int sx = 0;
	static int sy = 0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			Map<Integer, List<Point>> dict = new HashMap<>();
			
			for (int i = 0; i < N; i++) {
				String in = br.readLine();
				st = new StringTokenizer(in);
				for (int j = 0; j < N; j++) {
					int val = Integer.parseInt(st.nextToken());
					map[i][j] = val;
					if(val >= 6 && val <= 10) {
						if(dict.containsKey(val)) dict.get(val).add(new Point(i, j));
						else {
							List<Point> temp = new ArrayList<Point>();
							temp.add(new Point(i, j));
							dict.put(val, temp);
						}
					}
				}
			}
			
			int maxPoint = 0;
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					sy = y;
					sx = x;
					if(map[y][x] != 0) continue;
					
					int tempPoint = 0;
					for (int k = 0; k < 4; k++) {
						int resultPoint = process(map, y, x, k, 0, dict);
//						String direction = " ";
//						if(k == 0) direction = "R";
//						if(k == 1) direction = "U";
//						if(k == 2) direction = "L";
//						if(k == 3) direction = "D"; 
//						System.out.println(String.format("##R: Start (%d, %d) %s, Cnt: %d", y, x, direction,resultPoint));
						if(resultPoint > tempPoint) tempPoint = resultPoint;
					}
					if(maxPoint < tempPoint) maxPoint = tempPoint;
				}
			}
			
			System.out.println("#"+t+" "+maxPoint);
		}
	}
	
	public static int process(int[][] map, int cy, int cx, 
			int dir, int cnt, Map<Integer, List<Point>> dict) {
		int ny = cy, nx = cx;
		int pre_cnt = -1;
		boolean flg = true, flg2 = false;
		while(true) {
			switch(map[ny][nx]) {
			// Empty space
			case 0:
				flg = false;
				break;
			// LEFT DOWN
			case 1:
				if(dir == 0) { dir = 2; }
				else if(dir == 1) { dir = 3; }
				else if(dir == 2) { dir = 1; }
				else if(dir == 3) { dir = 0; }
				cnt++;
				break;
				// LEFT UP
			case 2:
				if(dir == 0) { dir = 2;  }
				else if(dir == 1) { dir = 0;  }
				else if(dir == 2) { dir = 3;  }
				else if(dir == 3) { dir = 1;  }
				cnt++;
				break;
				// RIGHT UP
			case 3:
				if(dir == 0) { dir = 3;  }
				else if(dir == 1) { dir = 2;  }
				else if(dir == 2) { dir = 0;  }
				else if(dir == 3) { dir = 1;  }
				cnt++;
				break;
				// RIGHT DOWN
			case 4:
				if(dir == 0) { dir = 1;  }
				else if(dir == 1) { dir = 3;  }
				else if(dir == 2) { dir = 0;  }
				else if(dir == 3) { dir = 2;  }
				cnt++;
				break;
				// ALL DIR
			case 5:
				if(dir == 0) { dir = 2;  }
				else if(dir == 1) { dir = 3;  }
				else if(dir == 2) { dir = 0;  }
				else if(dir == 3) { dir = 1;  }
				cnt++;
				break;
				// WARMHALL
			case 6: case 7: case 8: case 9: case 10:
				List<Point> tempList = dict.get(map[ny][nx]);
				Point p1 = tempList.get(0);
				Point p2 = tempList.get(1);
				if(p1.y == ny && p1.x == nx) {
					ny = p2.y;
					nx = p2.x;
				}
				else {
					ny = p1.y;
					nx = p1.x;
				}
				flg2 = true;
				break;
			}
			ny += dy[dir];
			nx += dx[dir];
			
			if(ny < 0) { ny = 0; dir = (dir+2)%4; cnt++; }
			if(ny >= map.length) { ny = map.length-1; dir = (dir+2)%4; cnt++; }
			if(nx < 0) { nx = 0; dir = (dir+2)%4; cnt++; }
			if(nx >= map.length) { nx = map.length-1; dir = (dir+2)%4; cnt++; }
			
//			String direction = " ";
//			if(dir == 0) direction = "R";
//			if(dir == 1) direction = "U";
//			if(dir == 2) direction = "L";
//			if(dir == 3) direction = "D"; 
//			if(flg) {
//				if(flg2)
//					System.out.println(String.format("([%d, %d] %s, %d)", ny, nx, direction, cnt));
//				else
//					System.out.println(String.format("([%d, %d] %s, %d)", ny-dy[dir], nx-dx[dir], direction, cnt));
//			}
			flg = true;
			flg2 = false;
			if(map[ny][nx] == -1 || (ny == sy && nx == sx)) {
				return cnt;
			}
		}
	}
}
