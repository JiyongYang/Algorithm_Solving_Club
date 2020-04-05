package backjoon;
import java.util.Scanner;

public class Main_B1110_S {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int base = sc.nextInt();
		int num = base;
		int cnt = 0;
		while(true) {
			
			int a = num/10;
			int b = num%10;
			int r = a+b;
			num = b*10+r%10;
			cnt++;
			if(num == base) break;
		}
		
		System.out.println(cnt);
	}
}
