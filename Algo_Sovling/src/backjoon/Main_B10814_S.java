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

public class Main_B10814_S {
	static class Account implements Comparable<Account>{
		int age;
		String name;
		int idx;
		public Account(int age, String name) {
			super();
			this.age = age;
			this.name = name;
			this.idx = id++;
		}
		@Override
		public int compareTo(Account o) {
			if(age > o.age) return 1;
			if(age == o.age) return (idx-o.idx); 
			return -1;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return age+" "+name;
		}
		
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int id = 0;

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		Account[] list = new Account[N];
		for (int i = 0; i < N; i++) {
			String[] sl = br.readLine().split(" ");
			list[i] = new Account(Integer.parseInt(sl[0]), sl[1]);
		}
		Arrays.sort(list);
		for (int i = 0; i < list.length; i++) {
			bw.write(list[i]+"\n");
		}
		
		br.close();
		bw.close();
	}

}
