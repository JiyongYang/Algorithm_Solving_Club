package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_S1209_S {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		String _in = "";
		
		for (int t = 1; t <= 10; t++) {
			try {
				_in = br.readLine();
			} catch (IOException e) {
				System.out.println(e);
			}
			
			int[][]	nums = new int[100][100];
			int[] sumNums = new int[202];
			
			for (int i = 0; i < 100; i++) {
				try {
					_in = br.readLine();
					st = new StringTokenizer(_in);
				} catch (IOException e) {
					System.out.println(e);
				}
				
				for (int j = 0; j < 100; j++) {
					nums[i][j]= Integer.parseInt(st.nextToken());
				}
			}
			
			int rdCrossSum = 0;
			int ruCrossSum = 0;
			// row sum, col sum
			for (int i = 0; i < 100; i++) {
				int rowSum = 0;
				int colSum = 0;
				for (int j = 0; j < 100; j++) {
					rowSum += nums[i][j];
					colSum += nums[j][i];
					
					if(i == j) rdCrossSum += nums[i][j];
					if((99-i) == j) ruCrossSum += nums[i][j];
				}
				sumNums[i] = rowSum;
				sumNums[100+i] = colSum;
			}
			sumNums[200] = rdCrossSum;
			sumNums[201] = ruCrossSum;
			
			System.out.println("#"+t+" "+(Arrays.stream(sumNums).max().getAsInt()));
		}
	}
}
