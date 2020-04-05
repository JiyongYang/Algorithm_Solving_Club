package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_B10828_S {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	public static void main(String[] args) throws IOException {
		Stack<Integer> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			if(s.split(" ").length > 1) {
				stack.add(Integer.parseInt(s.split(" ")[1]));
				continue;
			}
			
			if(s.equals("size")) {
				bw.write(stack.size()+"\n");
				continue;
			}
			if(s.equals("empty")) {
				if(stack.isEmpty()) bw.write(1+"\n");
				else bw.write(0+"\n");
				continue;
			}
			
			if(stack.isEmpty()) {
				bw.write((-1)+"\n");
				continue;
			}
			
			if(s.equals("pop")) bw.write(stack.pop()+"\n");
			if(s.equals("top")) bw.write(stack.peek()+"\n");
		}
		
		br.close();
		bw.close();
	}
}
