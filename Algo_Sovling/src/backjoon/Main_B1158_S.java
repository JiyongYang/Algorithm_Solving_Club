package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_B1158_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] numList = new int[N];
		boolean[] checkList = new boolean[N+1];
		
		if(N == 1) {
			bw.write("<"+N+">");
			bw.close();
			return;
		}
		
		int cnt = 0;
		int offset = 0;
		int i = 0;
		bw.write("<");
		while(true) {
			if(cnt == N) break;
			i = (i+1)%N;
			if(checkList[i] == false) {
				offset++;
			}
			if(offset == K) {
				offset = 0;
				checkList[i] = true;
				cnt++;
				if(i == 0 && cnt == N) {
					bw.write(N+">");
				}
				else if(i == 0 && cnt != N) {
					bw.write(N+", ");
				}
				else if(cnt == N) {
					bw.write(i+">");
					break;
				}
				else {
					bw.write(i+", ");
				}
			}
		}
		
		br.close();
		bw.close();
	}
}
