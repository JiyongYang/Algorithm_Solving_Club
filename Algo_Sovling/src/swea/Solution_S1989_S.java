package swea;
import java.util.Scanner;

public class Solution_S1989_S {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int i = 1; i <= T; i++) {
			String input = sc.next();
			
			int flg = 1;
			for (int j = 0; j < (input.length()/2); j++) {
				if(input.charAt(j) != input.charAt(input.length()-1-j))
					flg = 0;
			}
			
			System.out.println("#"+i+" "+flg);
		}
		sc.close();
	}

}
