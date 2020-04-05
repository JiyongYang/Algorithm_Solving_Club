package swea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_S1240_S {
	static class Node{
		int data;
		Node parent;
		ArrayList<Node> child = new ArrayList<>();
		Node(int data){
			this.data = data;
		}
		Node(int data, Node t){
			this.data = data;
			this.parent = t;
		}
		Node(){
		}
		
		public void add(Node a) {
			if(a != null) {
				a.parent = this;
				child.add(a);
			}
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int[][] code = { {3,2,1,1,0}, {2,2,2,1,1}, {2,1,2,2,2}, {1,4,1,1,3},
			{1,1,3,2,4}, {1,2,3,1,5}, {1,1,1,4,6}, {1,3,1,2,7}, {1,2,1,3,8}, {3,1,1,2,9} };
	static Node root;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		
		// code tree
		root = new Node();
		
		for (int i = 0; i < code.length; i++) {
			makeTree(root, code[i], 0);
		}
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			List<Integer>[] list = new ArrayList[8];
			for (int i = 0; i < 8; i++) {
				list[i] = new ArrayList<>();
			}
			
			
			int[][] codeList = new int[N][M];
			String in = "";
			for (int j = 0; j < N; j++) {
				in = br.readLine();
				for (int i = 0; i < M; i++) {
					codeList[j][i] = in.charAt(i)-'0';
				}
			}
			int result = 0;
			boolean verticalFalse = false;
			
			outer:for (int j = 0; j < N; j++) {
				for (int i = 0; i < M-56; i++) {
					if(codeList[j][i] == 1) {
						// 세로 길이 최소 5인지 판별
						for (int k = 1; k < 5; k++) {
							// 세로 길이 충족 X
							if(codeList[j+k][i] != 1) {
								verticalFalse = true;
								break outer;
							}
						}
						// 마지막 1 찾기
						int lastOnePos = 0;
						for (int k = 0; k < M; k++) {
							if(codeList[j][k] == 1) lastOnePos = k;
						}
						// 패턴 찾기
						int startPos = lastOnePos-56+1;
						int cnt = 0;
						ArrayList<Integer> tList = new ArrayList<>();
						int offset = 0;
						for (int k = 1; k <= 56; k++) {
//							System.out.print(codeList[j][startPos+k-1]);
							if(k == 56) {
								cnt++;
								tList.add(cnt);
								list[offset].addAll(tList);
								tList.clear();
								cnt = 0;
								result = checker(list);
								break;
							}
							
							if(codeList[j][startPos+k-1] != codeList[j][startPos+k]) {
								cnt++;
								if(tList.size() == 0 && codeList[j][startPos+k-1] == 1) {
									break outer;
								}
								tList.add(cnt);
								cnt = 0;
							}
							else {
								cnt++;
							}
							
							if(k%7==0) {
								list[offset++].addAll(tList);
								tList.clear();
//								System.out.println();
							}
						}
//						System.out.println("\n"+Arrays.toString(list));
						break outer;
					}
				}
			}
			
			if(verticalFalse) result = 0;
			bw.write("#"+t+" "+result+"\n");
			bw.flush();
		} // end for
		
		br.close();
		bw.close();
	}
	private static void makeTree(Node parent, int[] is, int idx) {
		if(idx == is.length) {
			return;
		}
		boolean flg = true;
		int pos = 0;
		for (int i = 0; i < parent.child.size(); i++) {
			if(parent.child.get(i).data == is[idx]) {
				pos = i;
				flg = false;
				break;
			}
		}
		if(flg) {
			parent.child.add(new Node(is[idx], parent));
			makeTree(parent.child.get(parent.child.size()-1), is, idx+1);				
		}
		else {
			makeTree(parent.child.get(pos), is, idx+1);
		}
	}
	public static int checker(List<Integer>[] list) {
		int oddSum = 0;
		int evenSum = 0;
		int veriCode = 0;
		for (int i = 0; i < list.length; i++) {
			Node temp = root;
			for (int j = 0; j < list[i].size(); j++) {
				int code = list[i].get(j);
				int pos = 0;
				for (int k = 0; k < temp.child.size(); k++) {
					if(temp.child.get(k).data == code) {
						pos = k;
						temp = temp.child.get(k);
						break;
					}
//					System.out.println("No code");
//					return -1;
				}
			}
			if(i == list.length-1) veriCode = temp.child.get(0).data;
			else if(i%2 == 0) oddSum += temp.child.get(0).data;
			else evenSum += temp.child.get(0).data;
			
//			System.out.print(temp.child.get(0).data);
		}
//		System.out.println();
		int totalsum = oddSum*3+evenSum;
		int result = 0;
		if((totalsum+veriCode)%10==0) result = oddSum+evenSum+veriCode;
//		System.out.println(result);
		return result;
	}
	
}
