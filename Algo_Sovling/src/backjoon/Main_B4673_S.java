package backjoon;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main_B4673_S {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		boolean[] check = new boolean[10001];
		for (int i = 1; i < 10001; i++) {
			int q = i;
			while((q = d(q)) <= 10000) {
				check[q] = true;
			}
		}
		
		for (int i = 1; i < check.length; i++) {
			if(!check[i]) bw.write(i+"\n");
		}
		
		bw.close();
	}
	
	public static int d(int n) {
		int sum = n;
		
		while(n>=1) {
			sum += n%10;
			n /= 10;
		}
		return sum;
	}
}
