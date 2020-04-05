package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B15649_S {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int[] nums = new int[N];
		int[] numsCnt = new int[N+1];
		for (int i = 0; i < N; i++) {
			nums[i] = i+1;
			numsCnt[i+1] = 1;
		}
//		ArrayList<Integer> arr = new ArrayList<>();
//		sequence(arr, nums, numsCnt, M);
		boolean[] check = new boolean[N+1];
		sequence2(nums, check, 0, 0);
		
		br.close();
		bw.close();
	}
	
	public static void sequence(ArrayList<Integer> arr, int[] nums, 
			int[] numsCnt, int M) throws IOException {
		if(arr.size() == M) {
			for (int i = 0; i < arr.size(); i++) {
				bw.write(arr.get(i)+" ");
			}
			bw.write("\n");
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if(numsCnt[nums[i]] > 0) {
				numsCnt[nums[i]]--;
				arr.add(nums[i]);
				sequence(arr, nums, numsCnt, M);
				arr.remove(arr.size()-1);
				numsCnt[nums[i]]++;
			}
		}
	}
	
	public static void sequence2(int[] nums, 
			boolean[] check, int depth, int idx) throws IOException {
		if(depth == M) {
			for (int i = 0; i < check.length; i++) {
				if(check[i]) bw.write(nums[i]+" ");
			}
			bw.write("\n");
			return;
		}
		for (int i = idx; i < nums.length; i++) {
			if(check[i]) continue;
			check[i] = true;
//				swap(nums, depth, i);
			sequence2(nums, check, depth+1, i);
//				swap(nums, depth, i);
			check[i] = false;
			
		}
	}
	
	public static void swap(int[] nums, int p1, int p2) {
		int temp = nums[p1];
		nums[p1] = nums[p2];
		nums[p2] = temp;
	}

}
