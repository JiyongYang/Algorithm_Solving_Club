package swea;
import java.util.Scanner;

public class Solution_S3307_S {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int z = 1; z <= T; z++) {
			int N = sc.nextInt();
			int[] input = new int[N+1];
			
			for (int j = 1; j <= N; j++) {
				input[j] = sc.nextInt();
			}
			
			int[] weight = new int[N+1];
			int[] memWeight = new int[N+1];
			
			int cnt = 1;
			weight[1] = 1;
			memWeight[1] = input[1]; 
			for (int j = 2; j <= N; j++) {
				for (int k = cnt; k >= 1 ; k--) {
					if(input[j] > memWeight[k] && k == cnt) {
						memWeight[++cnt] = input[j];
						weight[j] = cnt;
						break;
					}
					if(input[j] > memWeight[k] && k < cnt) {
						memWeight[k+1] = input[j];
						weight[j] = cnt;
						break;
					}
					if(k == 1) {
						memWeight[k] = input[j] < memWeight[k] ? input[j] : memWeight[k];
						weight[j] = cnt;
						break;
					}
				}
			}
			
			// result
			int maxV = -1;
			for (int i = 1; i <= N; i++) {
				if(maxV < weight[i]) {
					maxV = weight[i];
				}
			}
			System.out.println("#"+z+" "+maxV);
		}
		
		sc.close();
	}

}
