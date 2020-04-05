package swea;
import java.util.Scanner;

public class Solution_S2005_S {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int[][] pt = new int[12][12];
			
			pt[0][1] = 1;
			for (int y = 1; y <= N; y++) {
				for (int x = 1; x <= y; x++) {
					pt[y][x] = pt[y-1][x] + pt[y-1][x-1];
				}
			}
			
			System.out.println("#"+(i+1));
			for (int y = 1; y <= N; y++) {
				for (int x = 1; x <= y; x++) {
					System.out.print(pt[y][x]+" ");
				}
				System.out.println();
			}
		}
		
		sc.close();
	}
}
