package test.mocktest_190827;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_Q2 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int N = 0;

	static int minShuffleCnt = -1;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			minShuffleCnt = -1;
			N = Integer.parseInt(br.readLine());
			int[] nums = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}

			run(0, nums.clone());
			
			bw.write("#"+t+" "+minShuffleCnt+"\n");
			bw.flush();
		}
		
		bw.close();
		br.close();
	}
	
	public static void run(int cnt, int[] nums) {
		if(cnt <= 5) {
			// ��������, �������� Ȯ��
			boolean upFlg = true;
			boolean downFlg = true;
			for (int i = 0; i < nums.length-1; i++) {
				if(nums[i] > nums[i+1]) upFlg = false;
				if(nums[i] < nums[i+1]) downFlg = false;
			}
//			System.out.println(Arrays.toString(nums));
			
			if((upFlg || downFlg) && (cnt < minShuffleCnt || minShuffleCnt == -1)) {
				minShuffleCnt = cnt;
				return;
			}
		} else {
			return;
		}
		
		for (int i = 0; i < N; i++) {
			int[] temp = nums.clone();
			shuffle(i, temp);
			run(cnt+1, temp);
		}
		
	}
	
	public static void shuffle(int x, int[] nums) {
		Queue<Integer> lDeck = new LinkedList<>();
		Queue<Integer> rDeck = new LinkedList<>();
		Queue<Integer> r = new LinkedList<>();
		
		
		for (int i = 0; i < nums.length; i++) {
			if(i < N/2) lDeck.add(nums[i]);
			else rDeck.add(nums[i]);
		}
		
		if(x < N/2) {
			for (int i = 0; i < N/2-x-1; i++) {
				r.add(lDeck.poll());
			}
		} else {
			for (int i = 0; i < x-N/2+1; i++) {
				r.add(rDeck.poll());
			}
		}
		while(!lDeck.isEmpty() || !rDeck.isEmpty()) {
			if(!lDeck.isEmpty()) r.add(lDeck.poll());
			if(!rDeck.isEmpty()) r.add(rDeck.poll());
		}
		
//		System.out.print(r.size()+", "+nums.length+"  ");
//		System.out.println(r.toString());
		for (int i = 0; i < nums.length; i++) {
			nums[i] = r.poll();
		}
	}
}
