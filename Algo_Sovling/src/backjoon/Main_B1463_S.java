package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_B1463_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[] result = new int[N+1];
		result[N] = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		while(!q.isEmpty()) {
			int base = q.poll();
			if(base == 1) break;
			if(base%3==0) {
				if(result[base/3] == 0)	result[base/3] = result[base]+1;
				else result[base/3] = (result[base/3] > result[base]+1) ? result[base]+1 : result[base/3];
				q.add(base/3);
				if(base/3 == 1) break;
			}
			if(base%2==0) {
				if(result[base/2] == 0)	result[base/2] = result[base]+1;
				else result[base/2] = result[base/2] > result[base]+1 ? result[base]+1 : result[base/2];
				q.add(base/2);
				if(base/2 == 1) break;
			}
			if(result[base-1] == 0)	result[base-1] = result[base]+1;
			else result[base-1] = result[base-1] > result[base]+1 ? result[base]+1 : result[base-1];
			if(base-1==1) break;
			q.add(base-1);
		}
		bw.write(result[1]+"\n");
		bw.close();
		br.close();
	}
}
