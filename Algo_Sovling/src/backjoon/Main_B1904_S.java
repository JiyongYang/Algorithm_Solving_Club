package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_B1904_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	public static void main(String[] args) throws IOException {
		Map<Long, Long> mem = new HashMap<Long, Long>();
		Long result = fib(Long.parseLong(br.readLine()), mem);
		bw.write(result+"");
		br.close();
		bw.close();
	}
	
	public static long fib(long n, Map<Long, Long> mem) {
		if(mem.containsKey(n)) return mem.get(n);
		if(n == 1) return 1;
		if(n == 2) return 2;
		Long r = (fib(n-1, mem) + fib(n-2, mem))%15746;
		if(!mem.containsKey(n)) mem.put(n, r);
		return r;
	}
}
