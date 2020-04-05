package swea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution_S1244_S {
	static class Key{
		int nums;
		int depth;
		public Key(int nums, int depth) {
			super();
			this.nums = nums;
			this.depth = depth;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + depth;
			result = prime * result + nums;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Key other = (Key) obj;
			if (depth != other.depth)
				return false;
			if (nums != other.nums)
				return false;
			return true;
		}
		
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int maxVal = 0;
	static Map<Key, Integer> mem = new HashMap<>();
	static int ccnt = 0;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			String in_nums = st.nextToken();
			int cnt = Integer.parseInt(st.nextToken());
			int[] nums = new int[in_nums.length()];
			for (int i = 0; i < nums.length; i++) {
				nums[i] = in_nums.charAt(i)-'0';
			}
			
			dfs(nums, 0, cnt, 0);
			
			bw.write("#"+t+" "+maxVal+"\t\t"+ccnt+"\n");
			maxVal = 0;
		}
		
		br.close();
		bw.close();
	}

	private static void dfs(int[] nums, int depth, int cnt, int qq) {
		if(depth == cnt) {
			int sum = 0;
			for (int i = 0; i < nums.length; i++) {
				sum += nums[i] * Math.pow(10, nums.length-i-1);
			}
			if(sum > maxVal) maxVal = sum;
			return;
		}
		
		for (int i = qq; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				swap(nums, i, j);
				if(!mem.containsKey(new Key(getKey(nums), depth)))
					dfs(nums, depth+1, cnt, i);
				else
					ccnt++;
				Key k = new Key(getKey(nums), depth);
				if(!mem.containsKey(k)) {
					mem.put(k, k.nums);
				}
				swap(nums, i, j);
			}
		}
	}
	
	private static void swap(int[] nums, int p1, int p2) {
		int temp = nums[p1];
		nums[p1] = nums[p2];
		nums[p2] = temp;
	}
	
	private static int getKey(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i] * Math.pow(10, nums.length-i-1);
		}
		return sum;
	}
}
