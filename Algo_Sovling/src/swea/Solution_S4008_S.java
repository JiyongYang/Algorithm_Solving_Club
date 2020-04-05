package swea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution_S4008_S {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int N = 0;
	static HashMap<String, Integer> list = new HashMap<>();
	static int maxVal = -Integer.MAX_VALUE;
	static int minVal = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			maxVal = -Integer.MAX_VALUE;
			minVal = Integer.MAX_VALUE;
			
			N = Integer.parseInt(br.readLine());
			int[] operator = new int[4];
//			int[] operators = new int[N-1];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				operator[i] = Integer.parseInt(st.nextToken());
			}
			
//			int offset = 0;
//			int pos = 0;
//			while(true) {
//				if(operator[offset] != 0) {
//					operator[offset]--;
//					operators[pos++] = offset;
//				}
//				else {
//					if(offset+1 == 4) { break; }
//					else { offset++; }
//				}
//			}
			
			st = new StringTokenizer(br.readLine());
			int[] operand = new int[N];
			for (int i = 0; i < N; i++) {
				operand[i] = Integer.parseInt(st.nextToken());
			}
			ArrayList<Integer> arr = new ArrayList<>(); 
			
			getOp(arr, operator, operand);
			
			bw.write("#"+t+" "+(maxVal-minVal)+"\n");
			bw.flush();
		} // end for
		
		br.close();
		bw.close();
	}
	
	public static void getOp(ArrayList<Integer> arr, int[] operator, int[] operand) {
		if(arr.size() == N-1) {
			int sum = 0;
			sum += operand[0];
			for (int i = 1; i <= arr.size(); i++) {
				switch(arr.get(i-1)) {
				case 0:
					sum+=operand[i];
					break;
				case 1:
					sum-=operand[i];
					break;
				case 2:
					sum*=operand[i];
					break;
				case 3:
					sum/=operand[i];
					break;
				}
			}
			if(sum > maxVal) maxVal = sum;
			if(sum < minVal) minVal = sum;
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if(operator[i] > 0) {
				operator[i]--;
				arr.add(i);
				getOp(arr, operator, operand);
				arr.remove(arr.size()-1);
				operator[i]++;
			}
		}
		
//		for (int i = depth; i < N-1; i++) {
//			swap(operators, depth, i);
//			if(!list.containsKey(Arrays.toString(operators))){
//				getOp(operators, operand, depth+1);
//			}
//			if(!list.containsKey(Arrays.toString(operators))) {
//				list.put(Arrays.toString(operators), 1);
//			}
//			swap(operators, depth, i);
//		}
	}
	
	public static void swap(int[] operators, int x, int y) {
		int temp = operators[x];
		operators[x] = operators[y];
		operators[y] = temp;
	}
}
