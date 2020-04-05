package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_B2981_S {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int N = 0;
	static int[] nums = null;
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
 		}
		Arrays.sort(nums);
		int g = nums[1] - nums[0];
		for (int i = 1; i < N-1; i++) {
			g = gcd(g, nums[i+1]-nums[i]);
		}
		List<Integer> result = cd(g);
		Collections.sort(result);
		
		for (Integer i : result) {
			if(i != 1) bw.write(i+" ");
		}
		
		br.close();
		bw.close();
	}
	
	public static List<Integer> cd(int n){
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i*i <= n; i++) {
			if(n%i==0) {
				list.add(i);
				if(i != n/i) list.add(n/i);
			}
		}
		return list;
	}
	
	public static int gcd(int a, int b) {
		if(b == 0) return a;
		return gcd(b, a%b);
	}
}
