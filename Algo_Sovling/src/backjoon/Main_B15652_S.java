package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_B15652_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int N = 0;
	static int M = 0;
	static int[] nums;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = i+1;
		}
		ArrayList<Integer> arr = new ArrayList<>();
		boolean[] check = new boolean[N];
		sequence(arr, check);
		
		br.close();
		bw.close();
	}
	
	public static void sequence(List<Integer> arr, boolean[] check) throws IOException {
		if(arr.size() == M) {
			for (int i = 0; i < arr.size(); i++) {
				bw.write(arr.get(i)+" ");
			}
			bw.write("\n");
			bw.flush();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(!arr.isEmpty() && arr.get(arr.size()-1) > i+1) continue;
			
			check[i] = true;
			arr.add(i+1);
			sequence(arr, check);
			arr.remove(arr.size()-1);
			check[i] = false;
		}
	}
}
