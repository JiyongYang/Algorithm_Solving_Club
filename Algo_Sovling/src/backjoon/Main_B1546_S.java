package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B1546_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		double[] result = new double[N];
		st = new StringTokenizer(br.readLine());
		int maxV = 0;
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			if(maxV < nums[i]) maxV = nums[i];
		}
		double sum = 0.0;
		for (int i = 0; i < nums.length; i++) {
			result[i] = nums[i]/(double)maxV*100.0;
			sum += result[i];
		}
		bw.write((sum/N)+"");
		
		bw.close();
		br.close();
	}
}
