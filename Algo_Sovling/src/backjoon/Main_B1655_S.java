package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_B1655_S {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pqL = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> pqR = new PriorityQueue<>();
		int mid = Integer.parseInt(br.readLine());
		bw.write(mid+"\n");
//		bw.write(pqL.toString()+" || "+pqR.toString()+"\n\n");
		for (int i = 1; i < N; i++) {
			int base = Integer.parseInt(br.readLine());
			if(base > mid) {
				if(pqL.size() == pqR.size()) {
					pqR.add(base);
				} else if(pqL.size() < pqR.size()) {
					pqL.add(mid);
					pqR.add(base);
					mid = pqR.poll();
				}
			} else if(base < mid) {
				if(pqL.size() == pqR.size()) {
					pqR.add(mid);
					pqL.add(base);
					mid = pqL.poll();
				} else if(pqL.size() < pqR.size()) {
					pqL.add(base);
				}
			} else {
				if(pqL.size() == pqR.size()) {
					pqR.add(base);
				} else if(pqL.size() < pqR.size()) {
					pqL.add(base);
				}
			}
			bw.write(mid+"\n");
//			bw.write(pqL.toString()+" || "+pqR.toString()+"\n\n");
		}
		
		br.close();
		bw.close();
	}
}
