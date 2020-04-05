package swea;
import java.util.Scanner;

public class Solution_S1926_S {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for (int i = 1; i <= N; i++) {
			
			if(i == 3 || i == 6 || i == 9) {
				System.out.print("- ");
			}
			else if(i > 9) {
				int checker = i;
				boolean flg = false;
				while(checker >= 1) {
					int dit = checker % 10;
					if(dit == 3 || dit == 6 || dit == 9) {
						System.out.print("-");
						flg = true;
					}
					checker = (int)(checker/10);
					
					if(checker < 1 && flg == false) {
						System.out.print(i);
					}
				}
				System.out.print(" ");
			}
			else
			{
				System.out.print(i+" ");
			}
		}
		sc.close();
	}

}
