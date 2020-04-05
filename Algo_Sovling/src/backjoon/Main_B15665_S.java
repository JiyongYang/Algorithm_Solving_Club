package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_B15665_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int N = 0;
	static int M = 0;
	static int[] num;
	
	static int[] nums;
	static int[] cnts;
	static HashMap<Integer, Integer> cnt = new HashMap<>();
	static HashMap<String, Integer> checker = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		num = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			if(cnt.containsKey(num[i])) cnt.put(num[i], cnt.get(num[i])+1);
			else cnt.put(num[i], 1);
		}
		Arrays.sort(num);
		Set<Integer> keys = cnt.keySet();
		ArrayList<Integer> list = new ArrayList<>(keys);
		N = list.size();
		cnts = new int[N];
		nums = new int[N];
		Collections.sort(list);
		for (int i = 0; i < cnts.length; i++) {
			cnts[i] = M;
			nums[i] = list.get(i);
		}
		
		ArrayList<Integer> arr = new ArrayList<>();
		boolean[] check = new boolean[N];
		sequence(arr);
		
		br.close();
		bw.close();
	}
	
	public static void sequence(List<Integer> arr) throws IOException {
		if(arr.size() == M) {
			for (int i = 0; i < arr.size(); i++) {
				bw.write(arr.get(i)+" ");
			}
			bw.write("\n");
			bw.flush();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(cnts[i] > 0) {
//				if(!arr.isEmpty() && arr.get(arr.size()-1) > nums[i]) continue;
				cnts[i]--;
				arr.add(nums[i]);
				sequence(arr);
				arr.remove(arr.size()-1);
				cnts[i]++;
			}
		}
	}
}
