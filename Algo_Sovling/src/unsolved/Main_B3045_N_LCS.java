package unsolved;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_B3045_N_LCS {
	static class Op{
		char op;
		int nodeX;
		int nodeY;
		Op(char op, int nodeX, int nodeY){
			this.op = op;
			this.nodeX = nodeX;
			this.nodeY = nodeY;
		}
		@Override
		public String toString() {
			return "Op [op=" + op + ", nodeX=" + nodeX + ", nodeY=" + nodeY + "]";
		}
	}
	static class Node implements Comparable<Node>{
		double pos;
		int idx;
		Node(int idx, double pos){
			this.pos = pos;
			this.idx = idx;
		}
		@Override
		public int compareTo(Node o) {
			if(this.pos - o.pos > 0)
				return 1;
			else if(this.pos - o.pos < 0)
				return -1;
			else
				return 0;
		}
		@Override
		public String toString() {
			return idx+" ["+ pos+"]  ";
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Op[] opList = new Op[M];
		Node[] idx = new Node[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			Op op = new Op(st.nextToken().charAt(0), 
					Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()));
			opList[i] = op;
		}
		
		// A X -> front Y
		// B X -> Y end
//		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i <= N; i++) {
//			list.add(i+1);
			idx[i] = new Node(i, i);
		}
		
		for (int i = 0; i < M; i++) {
			Op op = opList[i];
			if(op.op == 'A') {
				idx[op.nodeX].pos = idx[op.nodeY].pos-0.001;
			}
			else {
				idx[op.nodeX].pos = idx[op.nodeY].pos+0.001;
			}
		}
		
		Arrays.sort(idx);
//		bw.write(Arrays.toString(idx));
		
//		LinkedList<Integer> list = new LinkedList<>();
		Node[] nIdx = new Node[N+1];
		for (int i = 0; i <= N; i++) {
			nIdx[i] = new Node(idx[i].idx, idx[i].idx);
//			list.add(idx[i].idx);
		}
		bw.write(Arrays.toString(nIdx));
		
		
		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		
		// LCS
		

		nIdx[0] = new Node(0, 0);
//		bw.write(Arrays.toString(nIdx));
		Arrays.sort(nIdx);
		bw.write(cnt+"\n"+sb);
//		bw.write(Arrays.toString(nIdx));
		
		br.close();
		bw.close();
	} // end main
	
	
}
