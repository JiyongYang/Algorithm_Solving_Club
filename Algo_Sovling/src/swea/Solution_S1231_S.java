package swea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_S1231_S {
	static class Node{
		char alpha;
		int right;
		int left;
		public Node(char alpha, int left, int right) {
			this.alpha = alpha;
			this.right = right;
			this.left = left;
		}
		public Node(char alpha, int left) {
			this.alpha = alpha;
			this.left = left;
		}
		public Node(char alpha) {
			this.alpha = alpha;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static Node[] list;
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
				if(in.length == 2) {
					list[pos] = new Node(in[1].charAt(0));
				} else if(in.length == 3) {
					list[pos] = new Node(in[1].charAt(0), Integer.parseInt(in[2]));
				} else {
					list[pos] = new Node(in[1].charAt(0), Integer.parseInt(in[2]),
							Integer.parseInt(in[3]));
				}
			}
			
			bw.write("#"+t+" ");
			traverse(list[1]);
			bw.write("\n");
			bw.flush();
		} // end testcase loop
		br.close();
		bw.close();
	}
	
	static int cnt = 0;
	public static void traverse(Node node) throws IOException {
		if(node != null) {
			traverse(list[node.left]);
			bw.write(node.alpha+"");
			traverse(list[node.right]);
		}
	}

}
