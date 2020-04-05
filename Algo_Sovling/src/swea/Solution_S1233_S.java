package swea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_S1233_S {
	static class Node{
		double data;
		int op;
		int right;
		int left;
		Node(double data){
			this.data = data;
		}
		Node(int op, int left, int right){
			this.data = 0.0;
			this.op = op;
			this.right = right;
			this.left = left;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Node [data=" + data + ", op=" + op + ", right=" + right + ", left=" + left + "]";
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static Node[] list;
	static Stack<Double> stack = new Stack<>();
	static int result = 0;
	static boolean resultFlg = true;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine());
			
			list = new Node[N+1];
			String[] in = null;
			
			resultFlg = true;
			for (int i = 0; i < N; i++) {
				boolean flg = false;
				in = br.readLine().split(" ");
				int pos = Integer.parseInt(in[0]);
				if(in.length > 2) {
					// operator
					int op = 0;
					if(in[1].contains("+")) { flg = true; op = 1; }
					if(in[1].contains("-")) { flg = true; op = 2; }
					if(in[1].contains("*")) { flg = true; op = 3; }
					if(in[1].contains("/")) { flg = true; op = 4; }
					if(flg) {
						if(in.length == 4) {
							list[pos] = new Node(op, Integer.parseInt(in[2]),
									Integer.parseInt(in[3]));
						}else {
							list[pos] = new Node(op, Integer.parseInt(in[2]), 0);
						}
					}
					else {
						resultFlg = false;
					}
				}
				else {
					// operand
					if(in[1].contains("+")) { flg = true; }
					if(in[1].contains("-")) { flg = true; }
					if(in[1].contains("*")) { flg = true; }
					if(in[1].contains("/")) { flg = true; }
					if(flg) {
						resultFlg = false;
					}
					else {
						list[pos] = new Node(new Integer(Integer.parseInt(in[1])).doubleValue());
					}
				}
			}
			
			if(resultFlg) {
				traverse(list[1]);
				if(!stack.isEmpty()) {
					bw.write("#"+t+" "+1+"\n");
					bw.flush();
					continue;
				}
			} 
			bw.write("#"+t+" "+0+"\n");
			bw.flush();
		} // end testcase loop
		br.close();
		bw.close();
	}
	
	static int cnt = 0;
	public static void traverse(Node node) {
		if(node != null && resultFlg) {
			traverse(list[node.left]);
			traverse(list[node.right]);
			if(node.data == 0) {
				// operator
				if(stack.isEmpty()) {
					System.out.println("call empty");
					result = 0;
					resultFlg = false;
					return;
				}
				double a = stack.pop();
				double b = stack.pop();
				double r = 0.0;
				switch(node.op) {
				case 1:
					r = b + a;
					break;
				case 2:
					r = b - a;
					break;
				case 3:
					r = b * a;
					break;
				case 4:
					r = b / a;
					break;
				default:
					System.out.println("call default");
					result = 0;
					resultFlg = false;
					return;
				}
				stack.add(r);
			}
			else {
				// operand
				stack.add(node.data);
			}
		}
	}

}
