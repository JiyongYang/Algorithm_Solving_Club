package test.nhn_190929;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_Q1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		String[] words = br.readLine().split(" ");
		HashMap<String, Integer> hm = new HashMap<>();
		
		for (String w : words) {
			if(hm.containsKey(w)) hm.put(w, hm.get(w)+1);
			else hm.put(w, 1);
		}
		
		int category = hm.size();
		Set<String> keys = hm.keySet();
		ArrayList<Integer> arr = new ArrayList<>();
		for (String k : keys) {
			arr.add(hm.get(k));
		}
		boolean flg = true;
		boolean oneflg = false;
		boolean use = false;
		
		Collections.sort(arr);
		int totalCnt = 0;
		for (Integer i : arr) {
			totalCnt += i;
		}
		
		int[] cnt = new int[1001];
		for (int i = 0; i < arr.size(); i++) {
			cnt[arr.get(i)]++;
		}
		
		int cntCnt = 0;
		for (int i = 0; i < cnt.length; i++) {
			if(cnt[i] > 0) cntCnt++;
		}
		
		// 가능한 케이스 없음
		if(cntCnt > 2) {
			flg = false;
		} else {
			if(cntCnt == 1) {
				// 바로 가능한 케이스
				flg = true;
				oneflg = true;
			} else {
				for (int i = 0; i < cnt.length; i++) {
					if(cnt[i] > 0) {
						if(cnt[i] == 1 && cnt[i+1] > 0) {
							flg = true;
						} else {
							flg = false;
						}
						break;
					}
				}
			}
		}
		if(flg) bw.write("Y\n");
		else bw.write("N\n");
		
		if(flg && !oneflg) bw.write(totalCnt+1+"\n");
		else bw.write(totalCnt+"\n");
		
		bw.write(category+"\n");
		
		
		bw.close();
		br.close();
		
		
		/*for (int i = 0; i < arr.size()-1; i++) {
			if(Math.abs(arr.get(i) - arr.get(i+1)) >= 2) {
				flg = false;
				break;
			}
			if(use && Math.abs(arr.get(i) - arr.get(i+1)) == 1) {
				flg = false;
				break;
			}
			if(!use && Math.abs(arr.get(i) - arr.get(i+1)) == 1) {
				use = true;
				if(arr.get(i) < arr.get(i+1)) arr.set(i, arr.get(i)+1);
				else arr.set(i+1, arr.get(i+1)+1);
			}
		}*/
	}
}
