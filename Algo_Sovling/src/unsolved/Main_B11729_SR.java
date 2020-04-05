package unsolved;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_B11729_SR {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int cnt = 0;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		hanoi(N, 1, 2, 3);
		bw.write(cnt+"\n"+sb.toString());
		
		bw.close();
		br.close();
	}
	
	public static void hanoi(int num, int from, int by, int to) throws IOException {
		bw.write(String.format("[H] %d From::%-2d By::%-2d To::%-2d\n", num, from, by, to));
		cnt++;
		if(num == 1) sb.append(from+" "+to+"\n");
		else {
			hanoi(num-1, from, to, by);
			sb.append(from+" "+to+"\n");
			hanoi(num-1, by, from, to);
		}
	}
}
