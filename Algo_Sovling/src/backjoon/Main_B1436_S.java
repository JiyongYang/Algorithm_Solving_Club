package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_B1436_S {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int[] num666 = new int[10001];
	static int RANGE = 700000000;
//	static int RANGE = 700000000;
	
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int offset = 0;
		num666[offset++] = 666;
		outer:for (int i = 1666; i < RANGE; i++) {
			String s = Integer.toString(i);
			for (int k = 0; k < s.length()-2; k++) {
				if(s.charAt(k)=='6' && s.charAt(k+1)=='6' && s.charAt(k+2)=='6') {
					num666[offset++] = i;
					if(offset==10000) break outer;
					break;
				}
			}
		}
//		for (int i = 0; i < 20; i++) {
//			bw.write(i+" "+num666[i]+"\n");
//		}
		
		bw.write(num666[n-1]+"");
		
		br.close();
		bw.close();
	}
}
