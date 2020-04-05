package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_B9461_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	public static void main(String[] args) throws IOException {
		Map<Long, Long> mem = new HashMap<Long, Long>();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			Long result = pfib(Long.parseLong(br.readLine()), mem);
			bw.write(result+"\n");
			bw.flush();
		}
		
		br.close();
		bw.close();
	}
	
	public static long pfib(long n, Map<Long, Long> mem) {
		if(mem.containsKey(n)) return mem.get(n);
		if(n == 1) return 1;
		if(n == 2) return 1;
		if(n == 3) return 1;
		if(n == 4) return 2;
		if(n == 5) return 2;
		
		Long r = (pfib(n-1, mem) + pfib(n-5, mem));
		if(!mem.containsKey(n)) mem.put(n, r);
		return r;
	}
}
