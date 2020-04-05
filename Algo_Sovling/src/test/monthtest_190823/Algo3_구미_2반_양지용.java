package test.monthtest_190823;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Algo3_구미_2반_양지용 {
	static class Node{
		int id;
		ArrayList<Integer> smaller;
		ArrayList<Integer> bigger;
		Node(int id){
			this.id = id;
			smaller = new ArrayList<>(5000);
			bigger = new ArrayList<>(5000);
		}
		@Override
		public String toString() {
			return "Node [id=" + id + ", smaller=" + smaller + ", bigger=" + bigger + "]";
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int N = 0, M = 0;
	static Node[] num = null;
	static Node[] checker = null;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		num = new Node[N+1];
		checker = new Node[N+1];
		
		for (int i = 1; i < num.length; i++) {
			num[i] = new Node(i);
			checker[i] = new Node(i);
		}
		
		// 0 작은 케이스
		// 1 큰 케이스
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			
			num[s].bigger.add(b);
			num[b].smaller.add(s);
		}
		
//		for (int i = 1; i < num.length; i++) {
//			bw.write(num[i]+"\n");
//		}
//		bw.write("\n");
		run();
		
		int cnt = 0;
		for (int i = 1; i < checker.length; i++) {
//			bw.write(checker[i]+"\n");
			if((checker[i].bigger.size() > 1 && checker[i].smaller.size() == 0) 
			|| (checker[i].smaller.size() > 1 && checker[i].bigger.size() == 0)) cnt++;
		}
		
		bw.write(cnt+"");
		
		br.close();
		bw.close();
	}
	
	public static void run() {
		for (int i = 1; i < num.length; i++) {
			// 큰거
			if(num[i].bigger.size() != 0) {
				for (int k = 0; k < num[i].bigger.size(); k++) {
					// 기본적인 큰거 더해주기
					// i는 현재 값
					int biggerV = num[i].bigger.get(k);
					checker[i].bigger.add(biggerV);
					ArrayList<Integer> inBigList = new ArrayList<>(5000);
					recur_bigger(i, biggerV, inBigList);
					
					checker[i].bigger.addAll(inBigList);
					// 리커시브하게 찾은 것들 추가해주기
//					for (int bb = 0; bb < inBigList.size(); bb++) {
//						checker[i].bigger.add(inBigList.get(bb));
//						checker[inBigList.get(bb)].smaller.add(i);
//					}
				}
			}
			
			// 작은것
			if(num[i].smaller.size() != 0 ) {
				for (int k = 0; k < num[i].smaller.size(); k++) {
					// 기본적인 큰거 더해주기
					int smallerV = num[i].smaller.get(k);
					checker[i].smaller.add(smallerV);
					
					ArrayList<Integer> inSmallList = new ArrayList<>(5000);
					recur_smaller(i, smallerV, inSmallList);
					
					checker[i].smaller.addAll(inSmallList);
					// 리커시브하게 찾은 것들 추가해주기
//					for (int bb = 0; bb < inSmallList.size(); bb++) {
//						checker[i].smaller.add(inSmallList.get(bb));
//						checker[inSmallList.get(bb)].bigger.add(i);
//					}
				}
			}
		}
	}
	
	public static void recur_bigger(int baseId, int checkId, ArrayList<Integer> result) {
		if(num[checkId].bigger.size() != 0) {
			for (int k = 0; k < num[checkId].bigger.size(); k++) {
				int biggerV = num[checkId].bigger.get(k);
				result.add(biggerV);
				if(num[biggerV].bigger.size() != 0) {
					recur_bigger(baseId, biggerV, result);
				}
			}
		}
	}
	
	public static void recur_smaller(int baseId, int checkId, ArrayList<Integer> result) {
		if(num[checkId].smaller.size() != 0) {
			for (int k = 0; k < num[checkId].smaller.size(); k++) {
				int smallerV = num[checkId].smaller.get(k);
				result.add(smallerV);
				if(num[smallerV].smaller.size() != 0) {
					recur_smaller(baseId, smallerV, result);
				}
			}
		}
	}
}
