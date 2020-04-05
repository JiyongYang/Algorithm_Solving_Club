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

public class Main_B10845_S {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;

	public static void main(String[] args) throws IOException {
		Deque<Integer> q = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			if(s.split(" ").length > 1) {
				q.add(Integer.parseInt(s.split(" ")[1]));
				continue;
			}
			
			if(s.equals("size")) {
				bw.write(q.size()+"\n");
				continue;
			}
			if(s.equals("empty")) {
				if(q.isEmpty()) bw.write(1+"\n");
				else bw.write(0+"\n");
				continue;
			}
			
			if(q.isEmpty()) {
				bw.write((-1)+"\n");
				continue;
			}
			
			if(s.equals("front")) bw.write(q.getFirst()+"\n");
			if(s.equals("back")) bw.write(q.getLast()+"\n");
			if(s.equals("pop")) bw.write(q.pollFirst()+"\n");
		}
		
		
		br.close();
		bw.close();
	}

}
