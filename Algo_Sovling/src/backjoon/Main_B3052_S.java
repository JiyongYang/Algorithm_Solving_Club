package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B3052_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int[] nums = new int[10];
		int[] check = new int[42];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = (Integer.parseInt(br.readLine())%42);
		}
		
		int cnt = 0;
		for (int i = 0; i < nums.length; i++) {
			if(check[nums[i]] == 0) {
				cnt++;
				check[nums[i]]++;
			}
		}
		bw.write(cnt+"");
		
		
		bw.close();
		br.close();
	}
}
