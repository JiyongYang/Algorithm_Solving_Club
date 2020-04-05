package swea;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_S1984_S {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int i = 1; i <= T; i++) {
			int[] num = new int[10];
			
			for (int j = 0; j < num.length; j++) {
				num[j] = sc.nextInt();
			}
			
			Arrays.sort(num);
			int sumAver = 0;
			
			for (int j = 1; j < num.length-1; j++) {
				sumAver += num[j];
			}
			double result = (double)sumAver/8;
			double point = result - (double)(int)result;
			if(point >= 0.5)
			{
				result +=1;
			}
			System.out.println("#"+i+" "+(int)result);
		}
		
		sc.close();
	}

}
