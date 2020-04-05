package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_B11866_S {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;

	public static void main(String[] args) throws IOException {
		Deque<Integer> q = new ArrayDeque<>();
		st =  new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		
		int offset = 0;
		bw.write("<");
		while(q.size() != 1) {
			int a = q.poll();
			offset++;
			if(offset%K== 0) {
				bw.write(a+", ");
				continue;
			}
			q.addLast(a);
		}
		
		bw.write(q.peek()+">");
		
		br.close();
		bw.close();
	}

}
