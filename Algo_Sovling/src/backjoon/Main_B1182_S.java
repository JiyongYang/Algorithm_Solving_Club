package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_B1182_S {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
//	static boolean[] check;
	static int N;
	static int S;
	static int cnt;
	static int[] nums;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		cnt = 0;
		boolean[] check = new boolean[N+1];
		
		nums = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		powerset(check, 0, 0);
		
		bw.write(cnt+"");
		bw.close();
		br.close();
	}

	private static void powerset(boolean[] check, int depth, int pos) {
		if(depth <= N) {
			int subSum = 0;
			int falseCnt = 0;
			for (int i = 1; i < check.length; i++) {
				if(check[i]) subSum += nums[i];
				else falseCnt++;
			}
			if(subSum == S && falseCnt != check.length-1) {
//				for (int i = 1; i < check.length; i++) {
//					if(check[i]) System.out.print(i+" ");
//				}
				cnt++;
//				System.out.println();
			}
//			for (int i = 0; i < check.length; i++) {
//				if(check[i]) System.out.print(i+" ");
//			}
//			System.out.println("");
		}
		else {
			return;
		}
		
		for (int i = pos+1; i < N+1; i++) {
			check[i] = true;
//			System.out.println("1st depth"+depth+1+"  i:"+i+"== true");
			powerset(check, depth+1, i);
//			System.out.println("2nd depth"+depth+1+"  i:"+i+"== false");
			check[i] = false;
//			powerset(depth+1, i);
		}
		
	}
}
