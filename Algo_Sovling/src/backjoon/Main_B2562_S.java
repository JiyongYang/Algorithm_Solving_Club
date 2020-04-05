package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B2562_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int[] nums = new int[9];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		int maxVal = nums[0];
		int pos = 0;
		for (int i = 1; i < nums.length; i++) {
			if(nums[i] > maxVal) {
				maxVal = nums[i];
				pos = i;
			}
		}
		
		bw.write(maxVal+"\n"+(pos+1));
		
		bw.close();
		br.close();
	}
}
