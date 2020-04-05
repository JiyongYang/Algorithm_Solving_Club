package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main_B1021_S {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;

	public static void main(String[] args) throws IOException {
		Deque<Integer> q = new ArrayDeque<>();
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] targetNum = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			targetNum[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++) {
			q.add(i+1);
		}
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			int target = targetNum[i];
			
			int lcnt = 0;
			int rcnt = 0;
			for (Iterator iterator = q.iterator(); iterator.hasNext();) {
				Integer num = (Integer) iterator.next();
				if(target == num) break;
				lcnt++;
			}
			if(lcnt == 0) q.pollFirst();
			else {
				rcnt = q.size()-lcnt;
				if(lcnt < rcnt) {
					for (int offset = 0; offset < lcnt; offset++) {
						int a = q.pollFirst();
						q.addLast(a);
						cnt++;
					}
				} else {
					for (int offset = 0; offset < rcnt; offset++) {
						int a = q.pollLast();
						q.addFirst(a);
						cnt++;
					}
				}
				q.pollFirst();
			}
//			bw.write(q.toString()+"\n");
//			bw.write(lcnt+" "+rcnt+" "+cnt+"\n");
		}
		bw.write(cnt+"");

		br.close();
		bw.close();
	}

}
