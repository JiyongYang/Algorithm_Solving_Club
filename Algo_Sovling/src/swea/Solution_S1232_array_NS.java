package swea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_S1232_array_NS {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static Stack<Double> stack = new Stack<>();
	
	public static void main(String[] args) throws IOException {
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			int h = 1;
			int tN = N;
			while(tN/2 > 1) {
				tN/=2;
				h++;
			}
			int[] tree = new int[(int)Math.pow(2, h+1)];
			
			// -1 +
			// -2 -
			// -3 *
			// -4 /
			for (int i = 1; i <= N; i++) {
				String[] in = br.readLine().split(" ");
				
				if(in.length > 2) {
					// 연산자
					int pos = Integer.parseInt(in[2])/2;
					int op = 0;
					if(in[1].contains("+")) op = -1;
					if(in[1].contains("-")) op = -2;
					if(in[1].contains("*")) op = -3;
					if(in[1].contains("/")) op = -4;
					tree[pos] = op;
				}
				else {
					// 값
					int pos = Integer.parseInt(in[0]);
					tree[pos] = Integer.parseInt(in[1]);
				}
			}
			//bw.write(Arrays.toString(tree));
			inorder_traverse(tree, 1, tree.length);
			
			bw.write("#"+t+" "+(stack.pop()).intValue()+" "+stack.size()+"\n");
			bw.flush();
		}
		
		br.close();
		bw.close();
	}
	
	public static void inorder_traverse(int[] tree, int n, int size) {
		if(n <= size && tree[n] != 0) {
			inorder_traverse(tree, 2*n, size);
			inorder_traverse(tree, 2*n+1, size);
//			System.out.println(tree[n]);
			if(tree[n] > 0) {
				stack.add(new Double(tree[n]));
//				System.out.println(stack.peek());
			}
			if(tree[n] < 0) {
				Double a = stack.pop();
				Double b = stack.pop();
				Double r = 0.0;
				switch(tree[n]) {
				case -1:
					r = b + a;
					break;
				case -2:
					r = b - a;
					break;
				case -3:
					r = b * a;
					break;
				case -4:
					r = b / a;
					break;
				}
				stack.add(r);
//				System.out.println(stack.peek());
			}
		}
	}
}
