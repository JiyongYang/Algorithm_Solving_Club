package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_B9012_S {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	public static void main(String[] args) throws IOException {
		Stack<Character> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			boolean flg = true;
			for (int of = 0; of < s.length(); of++) {
				if(s.charAt(of)=='(') stack.add('(');
				else {
					if(stack.isEmpty() || stack.pop() == ')')
					{
						flg = false;
						break;
					}
				}
			}
			if(stack.size() > 0) flg = false;
			if(flg) bw.write("YES\n");
			else bw.write("NO\n");
			stack.clear();
		}
		
		br.close();
		bw.close();
	}
}
