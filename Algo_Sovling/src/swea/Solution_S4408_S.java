package swea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_S4408_S {
	static class FromTo implements Comparable<FromTo>{
		int from;
		int to;
		public FromTo(int from, int to) {
			super();
			this.from = from;
			this.to = to;
		}
		@Override
		public int compareTo(FromTo o) {
			return this.to - o.to;
		}
		@Override
		public String toString() {
			return "[f=" + from + ", t=" + to + "]\n";
		}
		
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int N = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			FromTo[] ft = new FromTo[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				if(s%2!=0) s+=1;
				if(e%2!=0) e+=1;
				ft[i] = new FromTo(s > e ? e : s, Math.abs(e-s));
			}
			
			Arrays.sort(ft);
			bw.write(Arrays.toString(ft)+"\n");
			bw.flush();
//			
			bw.write("#"+t+" "+run(ft)+"\n");
		}
		
		br.close();
		bw.close();
	}
	
	public static int run(FromTo[] ft) {
		boolean[] ftCheck = new boolean[ft.length];
		int cnt = 0, time = 0;
		while(cnt < N) {
			boolean[] check = new boolean[401];
			for (int i = 0; i < ft.length; i++) {
				if(ftCheck[i]) continue;
				if(check[ft[i].from]) continue;
				boolean flg = false;
				for (int os = ft[i].from+1; os <= ft[i].from+ft[i].to; os++) {
					if(check[os]) {
						flg = true;
						break;
					}
				}
				if(flg) continue;
				for (int os = ft[i].from; os <= ft[i].from+ft[i].to; os++) {
					check[os] = true;
				}
				ftCheck[i] = true;
				cnt++;
			}
			check = new boolean[401];
			time++;
		}
		
		return time;
	}
}

