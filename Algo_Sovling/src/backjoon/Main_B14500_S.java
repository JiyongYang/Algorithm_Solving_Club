package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_B14500_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int[][][] blocks = {
			{ { 0,1 },{ 0,2 },{ 0,3 } }, // ㅡ 
			{ { 1,0 },{ 2,0 },{ 3,0 } }, // ㅣ
			{ { 1,0 },{ 1,1 },{ 1,2 } }, // ㄴ (옆으로 길게)
			{ { 1,0 },{ 2,0 },{ 2,-1 } }, // ㄴ 좌우 반전(위로 길게)
			{ { 0,1 },{ 0,2 },{ -1,2 } }, // ㄴ 좌우 반전(옆으로 길게)
			{ { 1,0 },{ 2,0 },{ 2,1 } }, // ㄴ (위로 길게)
			{ { 0,1 },{ 1,0 },{ 2,0 } }, // ㄱ 좌우 반전 (아래로 길게)
			{ { 0,1 },{ 0,2 },{ 1,2 } }, // ㄱ (옆으로 길게)
			{ { 0,1 },{ 0,2 },{ 1,0 } }, // ㄱ 좌우 반전 (옆으로 길게)
			{ { 0,1 },{ 1,1 },{ 2,1 } }, // ㄱ (아래로 길게)
			{ { 0,1 },{ 1,0 },{ 1,1 } }, // ㅁ
			{ { 0,1 },{ -1,1 },{ -1,2 } }, // ㅢ`
			{ { 1,0 },{ 1,1 },{ 2,1 } }, // ㄴ+ㄱ 
			{ { 0,1 },{ 1,1 },{ 1,2 } }, // ㄱ+ㄴ
			{ { 1,0 },{ 1,-1 },{ 2,-1 } }, // ㄴ+ㄱ 좌우 반번
			{ { 0,1 },{ 0,2 },{ -1,1 } }, // ㅗ
			{ { 0,1 },{ 0,2 },{ 1,1 } }, // ㅜ
			{ { 1,0 },{ 2,0 },{ 1,1 } }, // ㅏ
			{ { 1,0 },{ 2,0 },{ 1,-1 } }, // ㅓ
			};
	static int[][] map;
	static int N;
	static int M;
	static int maxVal = 0;
	
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int y = 0; y < N; y++) {
			st = new StringTokenizer(br.readLine());
			for (int x = 0; x < M; x++) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int y = 0; y < N; y++) {
			for (int x = 0; x < M; x++) {
				dfs(y, x);
			}
		}
		bw.write(maxVal+"");
		
		br.close();
		bw.close();
	}
	
	public static void dfs(int y, int x) {
		for (int i = 0; i < blocks.length; i++) {
			int sum = map[y][x];
			for (int j = 0; j < blocks[i].length; j++) {
				int ny = y + blocks[i][j][0];
				int nx = x + blocks[i][j][1];
				
				if(ny >= N || ny < 0 || nx >= M || nx < 0) break;
				
				sum += map[ny][nx];
			}
			if(sum > maxVal) maxVal = sum;
		}
	}
}
