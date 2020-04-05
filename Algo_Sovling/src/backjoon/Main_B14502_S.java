package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_B14502_S {
	static class Point{
		int x;
		int y;
		Point(int p1, int p2){
			this.x = p1;
			this.y = p2;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static ArrayList<Integer> zeroList;
	static ArrayList<Integer> twoList;
	static ArrayList<Integer> oneList;
	static int maxSafeZone;
	static int N;
	static int M;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		maxSafeZone = 0;
		
		map = new int[N][M];
		
		zeroList = new ArrayList<>();
		twoList = new ArrayList<>();
		oneList = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				// 이건 필요한가?
//				map1d[i*N+j] = Integer.parseInt(st.nextToken());
				// dfs, bfs 용
				map[i][j] = Integer.parseInt(st.nextToken());
				// zero들의 위치정보
				if(map[i][j] == 0) zeroList.add(i*M+j);
				if(map[i][j] == 1) oneList.add(i*M+j);
				if(map[i][j] == 2) twoList.add(i*M+j);
			}
		}
		
		boolean[] checked = new boolean[N*M];
		
		// 3개의 벽을 세울 수 있는 포인트 위치들 구하기
		combi(checked, 0, -1);
				
		
		// 각 오염된 지역으로부터 시작해서 bfs call
		// checked 배열은 공용으로 사용
		
		// checked 배열과 벽 정보 마스킹하여 남은 0의 개수 카운드
		
		bw.write(maxSafeZone+"");
		
		bw.close();
		br.close();
	} // end of main
	
	public static void combi(boolean[] checked, int size, int pos) {
		if(size == 3) {
			int idx = 0;
			int[] combiPos = new int[3];
			for (int i = 0; i < checked.length; i++) {
				if(checked[i]) {
					combiPos[idx++] = i;
					// 구한 위치 조합을 기준으로 특정 3개의 포인트에 벽을 세움
//					System.out.println(combiPos[i]/M+", "+combiPos[i]%M);
					map[i/M][i%M] = 1;
				}
			}
			bfs(combiPos);
			
			// 세운 벽을 다시 원상태로 복귀
			for (int i = 0; i < combiPos.length; i++) {
				map[combiPos[i]/M][combiPos[i]%M] = 0;
			}
			
			return;
		}
		
		for (int i = pos+1; i < checked.length; i++) {
			int y = i/M;
			int x = i%M;
			if(map[y][x] == 0) {
	//			if(checked[i]) continue;
				checked[i] = true;
				combi(checked, size+1, i);
				checked[i] = false;
			}
		}
	}
	
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	public static void bfs(int[] combiPos) {
		
		Queue<Integer> q = new LinkedList<>();
		int[][] check = new int[N][M];
		
		for (int i = 0; i < twoList.size(); i++) {
			int p = twoList.get(i);
			int y = p/M;
			int x = p%M;
			q.add(p);
			check[y][x] = 2;
			while(!q.isEmpty()) {
				int qPos = q.poll();
				y = qPos/M;
				x = qPos%M;
				for (int k = 0; k < 4; k++) {
					int ny = y + dy[k];
					int nx = x + dx[k];
					if(ny < N && ny >= 0 &&
					   nx < M && nx >= 0) {
						if(map[ny][nx] == 0 && check[ny][nx] == 0) {
							q.add(ny*M+nx);
							check[ny][nx] = 2;
						}
					}
				}
			}
		} // end for
		
		for (int i = 0; i < oneList.size(); i++) {
			int p = oneList.get(i);
			int y = p/M;
			int x = p%M;
//			if(check[y][x] == 0) {
				check[y][x] = 1;
//			}
		}
		
		for (int i = 0; i < combiPos.length; i++) {
			check[combiPos[i]/M][combiPos[i]%M] = 4;
		}
		
		int subResult = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(check[i][j] == 0) {
					subResult++;
					sb.append("□");
				}else if(check[i][j] == 1) {
					sb.append("■");
				}else if(check[i][j] == 2){
					sb.append("*");
				}else {
					sb.append("▣");
				}
			}
			sb.append("\n");
		}
		
//		System.out.println(sb);
//		System.out.println(subResult);
		if(subResult > maxSafeZone) maxSafeZone = subResult;
	}
}
 