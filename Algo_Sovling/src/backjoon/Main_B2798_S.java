package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B2798_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int N = 0, M = 0;
	static int[] nums = null;
	static int cloestVal = 0;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		ArrayList<Integer> ll = new ArrayList<>();
		perm(ll, 0);
		
		bw.write(cloestVal+"");
		
		br.close();
		bw.close();
	}
	
	public static void perm(ArrayList<Integer> list, int s) {
		if(list.size() == 3) {
			int sum = 0;
			for (Integer ii : list) {
				sum += ii;
			}
			if(sum <= M && sum > cloestVal) cloestVal = sum;
			return;
		}
		for (int i = s; i < nums.length; i++) {
			list.add(nums[i]);
			perm(list, i+1);
			list.remove(list.size()-1);
		}
	}
	

}
