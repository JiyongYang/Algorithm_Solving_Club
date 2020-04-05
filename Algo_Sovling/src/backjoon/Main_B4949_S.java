package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_B4949_S {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	public static void main(String[] args) throws IOException {
		Stack<Character> stack = new Stack<>();
		while(true) {
			boolean flg = true;
			String s = br.readLine();
			if(s.equals(".")) break;
			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);
				if(ch == '(') stack.add('(');
				if(ch == '[') stack.add('[');
				if(ch == ')') {
					if(stack.isEmpty() || stack.pop() != '(') {
						flg = false;
						break;
					}
				}
				if(ch == ']') {
					if(stack.isEmpty() || stack.pop() != '[') {
						flg = false;
						break;
					}
				}
			}
			if(!stack.isEmpty()) flg = false;
			if(flg) bw.write("yes\n");
			else bw.write("no\n");
			stack.clear();
		}
		
		
		br.close();
		bw.close();
	}
}
