package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_B11286_S {
	static class ABS implements Comparable<ABS>{
		int val;
		int absV;
		public ABS(int val, int absV) {
			this.val = val;
			this.absV = absV;
		}
		@Override
		public int compareTo(ABS o) {
			return (absV == o.absV) ?  val - o.val : absV - o.absV;
		}
		@Override
		public String toString() {
			return val+"";
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<ABS> pq = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			int cmd = Integer.parseInt(br.readLine());
			if(cmd == 0) {
				if(pq.isEmpty()) bw.write("0\n");
				else bw.write(pq.poll()+"\n");
			} else {
				pq.add(new ABS(cmd, Math.abs(cmd)));
			}
		}
		
		br.close();
		bw.close();
	}
}
