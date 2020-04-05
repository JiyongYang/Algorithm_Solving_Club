package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_B2108_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		int[] cnt = new int[8002];
		int sum = 0;
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			sum += nums[i];
			cnt[nums[i]+4000]++;
		}
		int maxVal = 0;
		int pos = 0;
		boolean flg = true;
		for (int i = 1; i < cnt.length; i++) {
			if(maxVal < cnt[i]) {
				maxVal = cnt[i];
				pos = i;
				flg = true;
			} else if(maxVal == cnt[i] && flg) {
				pos = i;
				flg = false;
			}
			
		}
		Arrays.sort(nums);
		
		bw.write(String.format("%.0f\n", sum/(double)N));
		bw.write(nums[N/2]+"\n");
		bw.write((pos-4000)+"\n");
		bw.write((nums[N-1]-nums[0])+"");
		br.close();
		bw.close();
	}
	
}
