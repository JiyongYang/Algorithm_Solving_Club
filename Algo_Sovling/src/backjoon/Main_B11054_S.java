package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B11054_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N+1];
		int[] lis = new int[N+1];
		int[] luTable = new int[N+1];
		int[] lis_r = new int[N+1];
		int[] luTable_r = new int[N+1];
		st = new StringTokenizer(br.readLine());
		nums[0] = 0;
		for (int i = 1; i < nums.length; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		lis[0] = 0;
		luTable[0] = 0;
		int offset = 0;
		for (int i = 1; i < lis.length; i++) {
			for (int j = offset; j >= 0; j--) {
				if(nums[luTable[j]] < nums[i]) {
					luTable[j+1] = i;
					lis[i] = j+1;
					if(j == offset) offset++;
					break;
				}
			}
		}
		
		lis_r[0] = 0;
		luTable_r[0] = 0;
		int offset2 = 0;
		for (int i = 1; i < lis_r.length; i++) {
			for (int j = offset2; j >= 0; j--) {
				if(nums[luTable_r[j]] < nums[N-i+1]) {
					luTable_r[j+1] = N-i+1;
					lis_r[i] = j+1;
					if(j == offset2) offset2++;
					break;
				}
			}
		}
		
		int maxSum = 0;
		for (int i = 1; i < lis.length; i++) {
			int lmaxV = 0;
			int lmaxVPos = 0;
			for (int j = 1; j <= i; j++) {
				if(lmaxV < lis[j]) {
					lmaxV = lis[j];
					lmaxVPos = j;
				}
			}
			int rmaxV = 0;
			int rmaxVPos = i+1;
			for (int j = 1; j <= N-i+1; j++) {
				if(rmaxV < lis_r[j]) {
					rmaxV = lis_r[j];
					rmaxVPos = N-j+1;
				}
			}
			
			int temp = lmaxV+rmaxV;
			if(lmaxVPos == rmaxVPos) temp -= 1;
			else {
				if(nums[lmaxVPos] == nums[rmaxVPos]) temp -= 1;
			}
			if(temp > maxSum) maxSum = temp;
		}
		
		bw.write(maxSum+"\n");
		
		bw.close();
		br.close();
	}
	
}
