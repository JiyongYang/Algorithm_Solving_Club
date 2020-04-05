package swea;
import java.util.Scanner;

public class Solution_S1986_S {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			int sum = 0;
			
			for (int j = 1; j <= N; j++) {
				if(j%2 == 0) sum -= j;
				else sum += j;
				
			}
			
			System.out.println("#"+i+" "+sum);
		}
		
		sc.close();
	}

}
