package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_B14890_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	public static void main(String[] args) throws IOException {
		int N = 0, L = 0;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		boolean[][] check = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int resultCnt = 0;
		
		// Vertical
		for (int x = 0; x < N; x++) {
			boolean flg = true;
			outer:for (int y = 0; y < N-1; y++) {
				if(map[y][x] == map[y+1][x]) 
					continue;
				if(map[y][x] - map[y+1][x] == 1) {
					if(y+L < N) {
						// 앞이 더 큰 경우
						int base = map[y+1][x];
						for (int i = 1; i <= L; i++) {
							if(base != map[y+i][x] || check[y+i][x]) {
								flg = false;
								break outer;
							}
							check[y+i][x] = true;
						}
						y = y+L-1;
					}
					else {
						flg = false;
						break;
					}
				}
				else if (map[y][x] - map[y+1][x] == -1) {
					// 뒤가 더 큰 경우
					if((y+1)-L >= 0) {
						int base = map[y][x];
						for (int i = 0; i < L; i++) {
							if(base != map[y-i][x] || check[y-i][x]) {
								flg = false;
								break outer;
							}
							check[y-i][x] = true;
						}
					}
					else {
						flg = false;
						break;
					}
				}
				// 차이가 2 이상
				else {
					flg = false;
					break;
				}
			}
			if(flg) {
//				System.out.println("x:"+x+"["+pos+"]");
				resultCnt++;
			}
		}
		
		check = new boolean[N][N];
		// Horizon
		for (int y = 0; y < N; y++) {
			boolean flg = true;
			outer:for (int x = 0; x < N-1; x++) {
				if(map[y][x] == map[y][x+1]) continue;
				if(map[y][x] - map[y][x+1]== 1) {
					if(x+L < N) {
						// 앞이 더 큰 경우
						int base = map[y][x+1];
						for (int i = 1; i <= L; i++) {
							if(base != map[y][x+i] || check[y][x+i]) {
								flg = false;
								break outer;
							}
							check[y][x+i] = true;
						}
						x = x+L-1;
					}
					else {
						flg = false;
						break;
					}
				}
				else if (map[y][x] - map[y][x+1] == -1) {
					// 뒤가 더 큰 경우
					if((x+1)-L >= 0) {
						int base = map[y][x];
						for (int i = 0; i < L; i++) {
							if(base != map[y][x-i] || check[y][x-i]) {
								flg = false;
								break outer;
							}
							check[y][x-i] = true;
						}
					}else {
						flg = false;
						break;
					}
				}
				// 차이가 2 이상
				else {
					flg = false;
					break;
				}
			}
			if(flg) {
//				System.out.println("y:"+y+"["+pos+"]");
				resultCnt++;
			}
		}
		System.out.println(resultCnt);
	}

}
