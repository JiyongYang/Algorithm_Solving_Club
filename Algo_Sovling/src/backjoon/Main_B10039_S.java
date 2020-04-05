package backjoon;

import java.util.Scanner;

public class Main_B10039_S {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		
		
		for (int i = 0; i < 5; i++) {
			int in = sc.nextInt();
			if(in < 40) in = 40;
			sum += in;
		}
		
		System.out.println(sum/5);
	}
}
