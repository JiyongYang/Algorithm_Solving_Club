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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_B1966_S {
	static class Doc{
		int v;
		int id;
		public Doc(int v, int id) {
			super();
			this.v = v;
			this.id = id;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			Deque<Doc> q = new ArrayDeque<>();
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int pos = -1;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int in = Integer.parseInt(st.nextToken());
				q.add(new Doc(in, i));
			}
			
			int cnt = 0;
			while(!q.isEmpty()) {
				boolean flg = true;
				Doc base = q.pollFirst();
				for (Iterator iter = q.iterator(); iter.hasNext();) {
					Doc i = (Doc) iter.next();
					if(base.v < i.v) {
						flg = false;
						break;
					}
				}
				if(!flg) {
					q.addLast(base);
				} else {
					cnt++;
					if(base.id == M) {
						bw.write(cnt+"\n");
						break;
					}
				}
			}
		}
		
		
		br.close();
		bw.close();
	}

}
