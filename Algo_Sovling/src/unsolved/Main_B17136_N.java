package unsolved;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_B17136_N {
	static class Point{
		int x;
		int y;
		Point(int y, int x){
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "[" + x + ", " + y + "]";
		}
		
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static List<Point>[] mask = new ArrayList[5];
	static int[] maskCnt = new int[5];
	static final int[] maskSize = {1, 4, 9, 16, 25};
	static int minCnt = 100;
	static int gcnt = 0;
//	static int oneCnt = 0;
	
	public static void main(String[] args) throws IOException {
		int oneCnt = 0;
		int[][] map = new int[10][10];
		boolean[][] visited = new boolean[10][10];
		for (int i = 0; i < mask.length; i++) {
			mask[i] = new ArrayList<>();
			for (int y = 0; y < i+1; y++) {
				for (int x = 0; x < i+1; x++) {
					mask[i].add(new Point(y, x));
				}
			}
		}
		
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < map.length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) oneCnt++;
			}
		}
		for (int i = 0; i < maskCnt.length; i++) {
			maskCnt[i] = 5;
		}
		if(oneCnt == 0) {
			bw.write(0+"");
			bw.close();
			br.close();
			return;
		}
		bw.write("OneCnt: "+oneCnt+"\n");
		
		for (int y = 0; y < map.length; y++) {
			for (int x = 0; x < map.length; x++) {
				if(map[y][x] == 1) {
					counter(map, visited, y, x, 0, oneCnt);
				}
			}
		}
		if(minCnt == 100)
			bw.write(-1+"");
		else
			bw.write(minCnt+"");
		bw.close();
		br.close();
		
	}
	
	public static void counter(int[][] map, boolean[][] visited, int y, int x, int cnt, int oneCnt) {
		// 색종이로 덮을 구역이 더 이상 없는 경우
//		System.out.println(gcnt++);
//		System.out.println(String.format(" --(%d, %d) start recursive", y,x, minCnt));
		if(oneCnt == 0) {
			if(minCnt > cnt) minCnt = cnt;
			System.out.println(String.format(" --(%d, %d) oneCnt exit condition(minCnt:%d)", y,x, minCnt));
			return;
		}
		// 더 이상 남은 색종이가 없는 경우
		if(maskCnt[0] == 0 && maskCnt[1] == 0 && maskCnt[2] == 0
				&& maskCnt[3] == 0 && maskCnt[4] == 0) {
			System.out.println("out of colored papers");
			return;
		}
		
		// 시작 위치에서 5가지 색종이 마스킹 시켜보기
		for (int i = 0; i < 5; i++) {
			boolean flg = false;
			
			// 색종이를 다 사용한 경우 넘어가기
			if(maskCnt[i] == 0) {
//				System.out.println(String.format(" --(%d, %d) %d 사이즈 색종이 다 사용", y,x,i+1));
				continue;
			}
			
			for (int j = 0; j < mask[i].size(); j++) {
				Point pt = mask[i].get(j);
				int ny = y + pt.y;
				int nx = x + pt.x;
				
				//맵의 범위를 초과하는 경우
				if(ny >= map.length || ny < 0 || nx >= map.length || nx < 0) {
					flg = true;
//					System.out.println(String.format(" --(%d, %d) %d 범위초과", y,x,i+1));
					break;
				}
				
				// 정상적인 경우
				if(map[ny][nx] == 1 && visited[ny][nx] == false) continue;
				
				// 사이즈를 초과하는 경우
				flg = true;
//				System.out.println(String.format(" --(%d, %d) %d 사이즈초과", y,x,i+1));
				break;
			}
			// 해당 사이즈의 색종이를 사용할 수 없는 경우
			if(flg) {
				// 더 큰 종이 사이즈를 확인할 필요 없으니깐 종료
//				System.out.println(String.format(" --(%d, %d) %d 더 큰 사이즈 확인 필요 x", y,x,i+1));
				flg = false;
				break;
			}
			else {
				// 정상적으로 색종이를 덮을 수 있는 경우
				// 덮은 색종이 만큼 visited로 설정
				// ** 이 부분은 아래 재귀에서 더 이상 확인할 수 없는 경우 다시 원상복귀해야함
				for (int j = 0; j < mask[i].size(); j++) {
					Point pt = mask[i].get(j);
					int ny = y + pt.y;
					int nx = x + pt.x;
					visited[ny][nx] = true;
				}
				maskCnt[i] -= 1;
				oneCnt -= maskSize[i];
				for (int ry = 0/*y+(i+1)*/; ry < visited.length; ry++) {
					for (int rx = 0/*x+(i+1)*/; rx < visited.length; rx++) {
						if(map[ry][rx] == 1 && visited[ry][rx] == false) counter(map, visited, ry, rx, cnt+1, oneCnt);
					}
				}
				maskCnt[i] += 1;
				oneCnt += maskSize[i];
				for (int j = 0; j < mask[i].size(); j++) {
					Point pt = mask[i].get(j);
					int ny = y + pt.y;
					int nx = x + pt.x;
					visited[ny][nx] = false;
				}
				
			}
		}
	}

}
