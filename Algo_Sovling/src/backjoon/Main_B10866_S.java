package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main_B10866_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;

	public static void main(String[] args) throws IOException {
		Deque<Integer> q = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			if (s.split(" ").length > 1) {
				if (s.split(" ")[0].equals("push_back"))
					q.addLast(Integer.parseInt(s.split(" ")[1]));
				if (s.split(" ")[0].equals("push_front"))
					q.addFirst(Integer.parseInt(s.split(" ")[1]));
				continue;
			}

			if (s.equals("size")) {
				bw.write(q.size() + "\n");
				continue;
			}
			if (s.equals("empty")) {
				if (q.isEmpty())
					bw.write(1 + "\n");
				else
					bw.write(0 + "\n");
				continue;
			}

			if (q.isEmpty()) {
				bw.write((-1) + "\n");
				continue;
			}

			if (s.equals("front"))
				bw.write(q.getFirst() + "\n");
			if (s.equals("back"))
				bw.write(q.getLast() + "\n");
			if (s.equals("pop_front"))
				bw.write(q.pollFirst() + "\n");
			if (s.equals("pop_back"))
				bw.write(q.pollLast() + "\n");
		}

		br.close();
		bw.close();
	}

}
