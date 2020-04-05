package test.line190922;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_Q2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int maxSize = 0;
	static int[] cnt = null;
	static int gCnt = 0;
	static int idx = 0;
	static boolean flg = false;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		while(st.hasMoreTokens()) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		maxSize = list.size();
		cnt = new int[maxSize];
		for (int i = 0; i < maxSize; i++) {
			cnt[i] = 1;
		}
		Collections.sort(list);
		idx = Integer.parseInt(br.readLine());
		
		ArrayList<Character> arr = new ArrayList<>();
		seq(arr, list, 0);
		
		br.close();
		bw.close();
	}
	
	public static void seq(ArrayList<Character> arr, ArrayList<Integer> list, int s) throws IOException {
		if(flg) return;
		if(arr.size() == maxSize) {
			gCnt++;
			if(gCnt == idx) {
				for (int i = 0; i < arr.size(); i++) {
					bw.write(arr.get(i)+"");
				}
				flg = true;
			}
			return;
		}
		for (int i = 0; i < list.size(); i++) {
			if(cnt[i] > 0) {
				arr.add(Character.forDigit(list.get(i), 10));
				cnt[i]--;
				seq(arr, list, i);
				if(flg) return;
				arr.remove(arr.size()-1);
				cnt[i]++;
			}
		}
	}
}
