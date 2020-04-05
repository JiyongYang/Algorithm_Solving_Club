package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main_B15663_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int N = 0;
	static int M = 0;
	static int[] nums;
	static int[] cnts;
	static HashMap<Integer, Integer> cnt = new HashMap<>();
	static HashMap<String, Integer> checker = new HashMap<>();
	
	static ArrayList<Integer> arr2 = new ArrayList<>();
	static int[] counter = new int[8];
	static int[] numbers = new int[8];
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		cnts = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			if(cnt.containsKey(nums[i])) cnt.put(nums[i], cnt.get(nums[i])+1);
			else cnt.put(nums[i], 1);
		}
		Arrays.sort(nums);
		
		ArrayList<Integer> arr = new ArrayList<>();
		boolean[] check = new boolean[N];
		sequence(arr, check);
//		count();
//		solve(0);
		
		br.close();
		bw.close();
	}
	
	public static void sequence(List<Integer> arr, boolean[] check) throws IOException {
		if(arr.size() == M) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < arr.size(); i++) {
				sb.append(arr.get(i)+" ");
			}
			if(!checker.containsKey(sb.toString())) {
				checker.put(sb.toString(), 1);
				bw.write(sb+"\n");
				bw.flush();
			}
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(cnt.get(nums[i]) > 0) {
				cnt.put(nums[i], cnt.get(nums[i])-1);
				arr.add(nums[i]);
				sequence(arr, check);
				arr.remove(arr.size()-1);
				cnt.put(nums[i], cnt.get(nums[i])+1);
			}
		}
//		checker.clear();
	}

	public static void count() throws IOException {
		int number = nums[0];
	    int counts = 1;
	    int len = 0;
	    for (int i=1; i<N; i++) {
	        if (number == nums[i]) {
	            counts += 1;
	        } else {
	        	counter[len] = counts;
	        	numbers[len] = number;
	            counts = 1;
	            number = nums[i];
	            len += 1;
	        }
	    }
	    counter[len] = counts;
	    numbers[len] = number;
	    N = len;
	}
	
	public static void solve(int depth) throws IOException {
	    if (depth == M) {
	    	for (int i = 0; i < arr2.size(); i++) {
				bw.write(arr2.get(i)+" ");
			}
	    	bw.write("\n");
	    	bw.flush();
	        return;
	    }
	    for (int i=0; i<=N; i++) {
	        if (counter[i] > 0) {
	        	counter[i] -= 1;
	            arr2.add(nums[i]);
	            solve(depth+1);
	            arr2.remove(arr2.size()-1);
	            counter[i] += 1;
	        }
	    }
	}

}
