package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_B1003_S {
	static class ZO{
		int zCnt;
		int oCnt;
		ZO(int zCnt, int oCnt){
			this.zCnt = zCnt;
			this.oCnt = oCnt;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			Map<Long, Long> mem = new HashMap<>();
			Map<Long, ZO> counter = new HashMap<>();
			Long input = Long.parseLong(br.readLine());
			Long result = fib(input, mem, counter);
			bw.write(counter.get(input).zCnt+ " "+ counter.get(input).oCnt+"\n");
			bw.flush();
		}
		br.close();
		bw.close();
	}
	
	public static long fib(long n, Map<Long, Long> mem, Map<Long, ZO> counter) {
		if(mem.containsKey(n)) return mem.get(n);
		if(n == 0) {
			if(!counter.containsKey(n)) counter.put(n, new ZO(0, 0));
			counter.get(n).zCnt = 1;
			return 0;
		}
		if(n == 1) {
			if(!counter.containsKey(n)) counter.put(n, new ZO(0, 0));
			counter.get(n).oCnt = 1;
			return 1;
		}
		Long r = fib(n-1, mem, counter) + fib(n-2, mem, counter);
		if(!mem.containsKey(n)) mem.put(n, r);
		if(!counter.containsKey(n)) {
			ZO n_1 = counter.get(n-1);
			ZO n_2 = counter.get(n-2);
			counter.put(n, new ZO(n_1.zCnt+n_2.zCnt, n_1.oCnt+n_2.oCnt));
		}
		return r;
	}
}
