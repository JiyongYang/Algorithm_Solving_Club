package swea;
import java.util.Scanner;

public class Solution_S2001_S {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int i = 1; i <= T; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt(); // fly killer stick size
			
			int[][] fly = new int[N+1][N+1];
			
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {
					fly[x][y] = sc.nextInt();
				}
			}
			
			int maxKill = 0;
			for (int x = 0; x <= N - M; x++) {
				for (int y = 0; y <= N - M; y++) {
					int killedFly = 0;
					for (int k = 0; k < M; k++) {
						for (int q = 0; q < M; q++) {
							killedFly += fly[x+k][y+q];
						}
					}
					
					if(maxKill < killedFly)
						maxKill = killedFly;
					killedFly = 0;
				}
			}
			System.out.println("#"+i+" "+maxKill);
		}
		
		sc.close();
	}

}
