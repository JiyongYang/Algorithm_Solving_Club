package test.line190922;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_Q3 {
	static class People implements Comparable<People>{
		int in;
		int out;
		public People(int in, int out) {
			this.in = in;
			this.out = out;
		}
		@Override
		public int compareTo(People o) {
			return (in == o.in) ? out - o.out : in - o.in;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		ArrayList<People> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new People(Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken())));
		}
		Collections.sort(list);
		int cnt = 0;
		int out = 1;
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).in < out) {
				cnt++;
				out = list.get(i).out;
			}
		}
		
		if(cnt == 0) bw.write(1+"");
		else bw.write(cnt+"");
		
		
		br.close();
		bw.close();
	}
	
}
