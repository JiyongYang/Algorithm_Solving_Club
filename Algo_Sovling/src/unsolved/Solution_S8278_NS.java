package unsolved;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution_S8278_NS {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static long N = 0L;
	static long M = 0L;
	static HashMap<Long, Long> hm = new HashMap<>();
	static int size = 100000000;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Long.parseLong(st.nextToken());
			M = Long.parseLong(st.nextToken());
			
			/*Long[] list = new Long[size];
			
			Long temp1 = 0L;
			Long temp2 = 1L;
			
			if(N/size == 0) {
				list[0] = temp1;
				list[1] = temp2;
				for (int j = 2; j <= N; j++) {
					list[j] = ((list[j-2]*list[j-2]*list[j-2])+
							(list[j-1]*list[j-1]*list[j-1]))%M;
				}
			}
			else {
				for (int i = 0; i <= N/size; i++) {
					list[0] = temp1;
					list[1] = temp2;
					if(i == N/size) {
						
						for (int j = 2; j < N%size; j++) {
							System.out.println("1");
							list[j] = ((list[j-2]*list[j-2]*list[j-2])+
									(list[j-1]*list[j-1]*list[j-1]))%M;
						}
					}
					else {
						for (int j = 2; j < size; j++) {
							System.out.println("2");
							list[j] = ((list[j-2]*list[j-2]*list[j-2])+
									(list[j-1]*list[j-1]*list[j-1]))%M;
						}
						temp1 = list[size-2];
						temp2 = list[size-1];
					}
				}
			}*/
			
			
//			bw.write("#"+t+" "+list[(int) (N%size)]+"\n");
			bw.write("#"+t+" "+dd(N)+"\n");
			bw.flush();
		}
		br.close();
		bw.close();
	}
	
	public static Long dd(Long n) {
		if(hm.containsKey(n%1000000)) {
			return hm.get(n%1000000);
		}
		if(n == 0) return 0L;
		if(n == 1) return 1L;
		
		Long a = dd(n-1);
		Long b = dd(n-2);
		Long result = (a*a*a + b*b*b)%M;
		if(!hm.containsKey(n%1000000)) hm.put(n%1000000, result);
		return result;
	}
}