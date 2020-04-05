package swea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_S7810_S {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int[] nums = new int[N];
			for (int i = 0; i < nums.length; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(nums);
			ArrayList<Integer> list = new ArrayList<>();
			for (int i = nums.length-1; i >= 0; i--) {
				int cnt = nums.length-i;
				if(nums[i] >= cnt) list.add(cnt);
				else break;
			}
			if(list.size() == 0) bw.write("#"+t+" "+0+"\n");
			else bw.write("#"+t+" "+list.get(list.size()-1)+"\n");
		}
		br.close();
		bw.close();
	}
}
