package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B11053_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N+1];
		int[] lcs = new int[N+1];
		int[] luTable = new int[N+1];
		st = new StringTokenizer(br.readLine());
		nums[0] = 0;
		for (int i = 1; i < nums.length; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		lcs[0] = 0;
		luTable[0] = 0;
		int offset = 0;
		for (int i = 1; i < lcs.length; i++) {
			boolean flg = true;
			for (int j = offset; j >= 0; j--) {
				if(nums[luTable[j]] < nums[i]) {
					luTable[j+1] = i;
					lcs[i] = j+1;
					flg = false;
					if(j == offset) offset++;
					break;
				}
			}
		}
		/*for (int i = 1; i < lcs.length; i++) {
			int pos = -1;
			int maxV = -1;
			for (int j = i-1; j >= 0; j--) {
				if(nums[j] < nums[i]) {
					if(maxV < lcs[j]) {
						pos = j;
						maxV = lcs[j];
						luTable[maxV] = pos;
					}
				}
			}
			lcs[i] = maxV+1;
		}*/
		
//		bw.write(Arrays.toString(lcs)+"\n");
//		bw.write(Arrays.toString(luTable));
		bw.write(offset+"");
		
		bw.close();
		br.close();
	}
	
}
