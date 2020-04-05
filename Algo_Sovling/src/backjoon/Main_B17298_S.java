package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_B17298_S {
	static class Element{
		int val;
		int idx;
		public Element(int idx, int val) {
			super();
			this.val = val;
			this.idx = idx;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		st = new StringTokenizer(br.readLine());
		Stack<Element> stack = new Stack<>();
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			if(stack.isEmpty()) stack.add(new Element(i, n));
			else {
				while(!stack.isEmpty() && stack.peek().val < n) {
					Element e = stack.pop();
					nums[e.idx] = n;
				}
				stack.add(new Element(i, n));
			}
		}
		while(!stack.isEmpty()) {
			Element e = stack.pop();
			nums[e.idx] = -1;
		}
		for (int i = 0; i < nums.length; i++) {
			bw.write(nums[i]+" ");
		}
		
		
		br.close();
		bw.close();
	}
}
