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
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_B1181_S {
	static class Word implements Comparable<Word>{
		String s;

		public Word(String s) {
			super();
			this.s = s;
		}

		@Override
		public int compareTo(Word o) {
			if(s.length() < o.s.length()) return -1;
			if(s.length() == o.s.length()) return s.compareTo(o.s);
			return 1;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return s;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		Word[] list = new Word[N];
		for (int i = 0; i < N; i++) {
			list[i] = new Word(br.readLine());
		}
		Arrays.sort(list);
		for (int i = 0; i < list.length; i++) {
			if(i == list.length-1) {
				bw.write(list[i]+"");
				break;
			}
			if(list[i].s.equals(list[i+1].s)) continue;
			bw.write(list[i]+"\n");
		}
		
		br.close();
		bw.close();
	}

}
