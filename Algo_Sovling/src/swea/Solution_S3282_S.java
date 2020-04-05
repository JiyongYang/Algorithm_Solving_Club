package swea;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_S3282_S {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[][] item = new int[N+1][2];
			for (int i = 1; i <= N; i++) {
				item[i][0] = sc.nextInt();
				item[i][1] = sc.nextInt();
			}
			
			
			int[][] knapsack = new int[N+1][K+1];
			for (int i = 1; i <= N; i++) {
				for (int k = 1; k <= K; k++) {
					if(item[i][0] > k) {
						knapsack[i][k] = Math.max(0, knapsack[i-1][k]);
					}
					else {
						knapsack[i][k] = Math.max(knapsack[i-1][(k-item[i][0])]+item[i][1], knapsack[i-1][k]); 
					}
				}
			}
			
//			for (int[] is : knapsack) {
//				System.out.println(Arrays.toString(is));
//			}
			
			System.out.println("#"+t+" "+knapsack[N][K]);
		}
		
	}
}
