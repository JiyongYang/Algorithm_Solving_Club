package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B2920_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int[] nums = new int[8];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		boolean asc = true;
		boolean dsc = true;
		for (int i = 0; i < nums.length-1; i++) {
			if(nums[i] == nums[i+1]+1) asc = false;
			else if(nums[i] == nums[i+1]-1) dsc = false;
			else {
				asc = false;
				dsc = false;
			}
		}
		if(asc) bw.write("ascending");
		else if(dsc) bw.write("descending");
		else bw.write("mixed");
		
		bw.close();
		br.close();
	}
}
