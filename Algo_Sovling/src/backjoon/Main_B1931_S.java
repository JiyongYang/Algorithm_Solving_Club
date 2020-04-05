package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B1931_S {
	static class Meeting implements Comparable<Meeting>{
		int s;
		int e;
		Meeting(int s, int e){
			this.s = s;
			this.e = e;
		}
		@Override
		public int compareTo(Meeting o) {
			if(this.e == o.e) return this.s - o.s;
			return this.e-o.e;
		}
		@Override
		public String toString() {
			return "[" + s + ", " + e + "]";
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		Meeting[] arr = new Meeting[N];
		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = new Meeting(Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(arr);
		int cnt = 1;
		int curEndTime = arr[0].e;
		for (int i = 1; i < arr.length; i++) {
			if(arr[i].s < curEndTime) continue;
			curEndTime = arr[i].e;
			cnt++;
		}
		bw.write(cnt+"");
		bw.close();
		br.close();
	}
}
