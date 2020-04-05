package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_B1874_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		Stack<Integer> s = new Stack<>();
		int offset = 1;
		s.add(offset++);
		StringBuilder sb = new StringBuilder();
		sb.append("+\n");
		for (int i = 0; i < N; i++) {
			try {
				while (s.isEmpty() || s.peek() != nums[i]) {
					if(offset == N+1) throw new Exception();
					s.add(offset++);
					sb.append("+\n");
				}
				if (s.peek() == nums[i]) {
					s.pop();
					sb.append("-\n");
				}
			} catch (Exception e) {
				sb.setLength(0);
				sb.append("NO\n");
				break;
			}
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
