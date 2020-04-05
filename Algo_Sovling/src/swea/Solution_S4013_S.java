package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_S4013_S {
	private static final int RIGHT_POS = 2;
	private static final int LEFT_POS = 6;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int K = Integer.parseInt(br.readLine());
			int[][] mag = new int[4][8];
			for (int i = 0; i < 4; i++) {
				String in = br.readLine();
				st = new StringTokenizer(in);
				for (int j = 0; j < 8; j++) {
					mag[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < K; i++) {
				String in = br.readLine();
				int pos = Integer.parseInt(in.split(" ")[0])-1;
				int dir = Integer.parseInt(in.split(" ")[1]);
				int[] rotationDir = new int[4];
				boolean[] result = checker(mag, rotationDir, pos, dir);
				
				rotater(mag, result, rotationDir);
			}
			
			System.out.println("#"+t+" "+calPoint(mag));
		}
	}
	
	public static int calPoint(int[][] mag) {
		int result = 0;
		for (int i = 0; i < 4; i++) {
			result += (mag[i][0] == 1 ? 1 : 0) * Math.pow(2, i);
		}
		return result;
	}
	
	public static void rotater(int[][] mag, boolean[] result, int[] rotationDir) {
		for (int i = 0; i < rotationDir.length; i++) {
			if(result[i]) {
				rotate(mag, i, rotationDir[i]);
			}
		}
	}
	
	public static boolean[] checker(int[][] mag, int[] rotationDir, int pos, int dir) {
		boolean[] result = new boolean[4];
		rotationDir[pos] = dir;
		result[pos] = true;
		
		// left side
		if(pos >= 1) {
			for (int i = pos-1; i >= 0; i--) {
				if(result[i+1] && 
				   ((mag[i][RIGHT_POS] == 1 && mag[i+1][LEFT_POS] == 0) ||
				    (mag[i][RIGHT_POS] == 0 && mag[i+1][LEFT_POS] == 1)))	{
					result[i] = true;
				}
				rotationDir[i] = (rotationDir[i+1] == 1) ? -1 : 1;
			}
		}
		// right side
		if(pos <= 2) {
			for (int i = pos+1; i <= 3; i++) {
				if(result[i-1] && 
				  ((mag[i][LEFT_POS] == 1 && mag[i-1][RIGHT_POS] == 0) || 
				   (mag[i][LEFT_POS] == 0 && mag[i-1][RIGHT_POS] == 1))) {
					result[i] = true;
				}
				rotationDir[i] = (rotationDir[i-1] == 1) ? -1 : 1;
			}
		}
		
		return result;
	}
	
	public static void rotate(int[][] mag, int pos, int dir) {
		int temp = -1;
		if(dir == 1) {
			// 시계방향
			// 마지막 값 저장
			temp = mag[pos][7];
			for (int i = 7; i > 0; i--) {
				mag[pos][i] = mag[pos][i-1];
			}
			mag[pos][0] = temp;
		}
		else {
			// 반시계 방향
			temp = mag[pos][0];
			for (int i = 0; i < 7; i++) {
				mag[pos][i] = mag[pos][i+1];
			}
			mag[pos][7] = temp;
		}
	}
}
