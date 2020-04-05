package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main_B5430_S {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			Deque<Integer> q = new ArrayDeque<>();
			String s = br.readLine();
			int N = Integer.parseInt(br.readLine());
			String n = br.readLine();
			String[] nums = n.substring(1, n.length()-1).trim().split(",");
			for (int i = 0; i < N; i++) {
				q.add(Integer.parseInt(nums[i]));
			}
			
			int flg = 0;
			boolean r = false;
			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i)=='R') flg = (flg+1)%2;
				else {
					if(q.size() == 0) {
						r = true;
						break;
					}
					if(flg == 0) q.pollFirst();
					else q.pollLast();
				}
			}
			
			if(q.size() == 0 && r) bw.write("error\n");
			else if(q.size() == 0) bw.write("[]\n");
			else {
				bw.write("[");
				if(flg == 0) {
					while(q.size() != 1) bw.write(q.pollFirst()+",");
					bw.write(q.pollFirst()+"]\n");
				} else {
					while(q.size() != 1) bw.write(q.pollLast()+",");
					bw.write(q.pollLast()+"]\n");
				}
			}
		}
		
		br.close();
		bw.close();
	}

}
