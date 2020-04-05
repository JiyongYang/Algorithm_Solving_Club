package swea;
import java.io.IOException;
import java.util.*;

public class Solution_S8500_S {

    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();
    	for (int t = 1; t <= T; t++) {
    		int n = sc.nextInt();
    		int maxVal = 0;
    		int sum = 0;
    		for (int i = 0; i < n; i++) {
				int num = sc.nextInt();
				if(num > maxVal) maxVal = num;
				sum += num;
			}
    		sum += n+maxVal;
    		System.out.println("#"+t+" "+sum);
    		
		}
    }
}