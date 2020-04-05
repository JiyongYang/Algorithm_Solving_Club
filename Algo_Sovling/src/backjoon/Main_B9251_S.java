package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B9251_S {
	static class Pair implements Comparable<Pair>{
		int pos;
		int val;
		Pair(int pos, int val){
			this.pos = pos;
			this.val = val;
		}
		@Override
		public int compareTo(Pair o) {
			return this.pos - o.pos;
		}
		@Override
		public String toString() {
			return "[" + pos + ", " + val + "]";
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N+1];
		Pair[] pList = new Pair[N+1];
		int[] lis = new int[N+1];
		int[] luTable = new int[N+1];
		
		
		pList[0] = new Pair(0, 0);
		for (int i = 1; i < pList.length; i++) {
			st = new StringTokenizer(br.readLine());
			pList[i] = new Pair(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(pList);
		for (int i = 0; i < pList.length; i++) {
			nums[i] = pList[i].val;
		}
		
		lis[0] = 0;
		luTable[0] = 0;
		int offset = 0;
		for (int i = 1; i < lis.length; i++) {
			for (int j = offset; j >= 0; j--) {
				if(nums[luTable[j]] < nums[i]) {
					luTable[j+1] = i;
					lis[i] = j+1;
					if(j == offset) offset++;
					break;
				}
			}
		}
		
		bw.write((N-offset)+"\n");
		
		bw.close();
		br.close();
	}
	
}
