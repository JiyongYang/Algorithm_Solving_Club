package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_B12100_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int N = 0;
	static int[][] map = null;
	static int maxBlock = 0;
	static ArrayList<Integer> arr;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		arr = new ArrayList<>();
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		run(0);
		bw.write(maxBlock+"\n");
		
		br.close();
		bw.close();
	}
	
	public static void run(int depth) throws IOException {
		if(depth==5) {
			return;
		}
		int[][] tMap = new int[N][N];
		arrayCopy(map, tMap);
		for (int i = 0; i < 4; i++) {
			move(i+1);
			run(depth+1);
			arrayCopy(tMap, map);
		}
	}
	
	public static void arrayCopy(int[][] array, int[][] copy) {
		for (int i = 0; i < array.length; i++) {
			copy[i] = array[i].clone();
		}
	}
	
	public static void move(int dir) {
		if(dir == 1) { // ←
			for (int i = 0; i < N; i++) {
				LinkedList<Integer> s = new LinkedList<>();
				int sum = 0;
				for (int j = 0; j <= N-1; j++) {
					if(j == N-1 && sum != 0 && map[i][j] == 0 ) {
						s.add(sum);
					}
					if(map[i][j] == 0) continue;
					if(sum == 0) {
						sum += map[i][j];
					} else if(sum != 0 && sum==map[i][j]) {
						sum += map[i][j];
						s.add(sum);
						sum = 0;
					} else {
						s.add(sum);
						sum = map[i][j];
					}
					if(j == N-1 && sum != 0) {
						s.add(sum);
					}
					map[i][j] = 0;
				}
				
				int offset = 0;
				while(!s.isEmpty()) {
					int block = s.pop();
					map[i][offset++] = block;
					if(block > maxBlock) maxBlock = block;
				}
			}
		} else if(dir == 2) { // →
			for (int i = 0; i < N; i++) {
				LinkedList<Integer> s = new LinkedList<>();
				int sum = 0;
				for (int j = N-1; j >= 0; j--) {
					if(j == 0 && sum != 0 && map[i][j] == 0 ) {
						s.add(sum);
					}
					if(map[i][j] == 0) continue;
					if(sum == 0) {
						sum += map[i][j];
					} else if(sum != 0 && sum==map[i][j]) {
						sum += map[i][j];
						s.add(sum);
						sum = 0;
					} else {
						s.add(sum);
						sum = map[i][j];
					}
					if(j == 0 && sum != 0) {
						s.add(sum);
					}
					map[i][j] = 0;
				}
				
				int offset = N-1;
				while(!s.isEmpty()) {
					int block = s.pop();
					map[i][offset--] = block;
					if(block > maxBlock) maxBlock = block;
				}
			}
		} else if(dir == 3) { // ↑
			for (int i = 0; i < N; i++) {
				LinkedList<Integer> s = new LinkedList<>();
				int sum = 0;
				for (int j = 0; j <= N-1; j++) {
					if(j == N-1 && sum != 0 && map[j][i] == 0) {
						s.add(sum);
					}
					if(map[j][i] == 0) continue;
					if(sum == 0) {
						sum += map[j][i];
					} else if(sum != 0 && sum==map[j][i]) {
						sum += map[j][i];
						s.add(sum);
						sum = 0;
					} else {
						s.add(sum);
						sum = map[j][i];
					}
					if(j == N-1 && sum != 0) {
						s.add(sum);
					}
					map[j][i] = 0;
				}
				
				int offset = 0;
				while(!s.isEmpty()) {
					int block = s.pop();
					map[offset++][i] = block;
					if(block > maxBlock) maxBlock = block;
				}
			}
		} else { // ↓
			for (int i = 0; i < N; i++) {
				LinkedList<Integer> s = new LinkedList<>();
				int sum = 0;
				for (int j = N-1; j >= 0; j--) {
					if(j == 0 && sum != 0 && map[j][i] == 0) {
						s.add(sum);
					}
					if(map[j][i] == 0) continue;
					if(sum == 0) {
						sum += map[j][i];
					} else if(sum != 0 && sum==map[j][i]) {
						sum += map[j][i];
						s.add(sum);
						sum = 0;
					} else {
						s.add(sum);
						sum = map[j][i];
					}
					if(j == 0 && sum != 0) {
						s.add(sum);
					}
					map[j][i] = 0;
				}
				
				int offset = N-1;
				while(!s.isEmpty()) {
					int block = s.pop();
					map[offset--][i] = block;
					if(block > maxBlock) maxBlock = block;
				}
			}
		}
	}
}
