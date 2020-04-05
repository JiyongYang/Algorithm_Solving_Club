package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_B14889_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		int[][] ability = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				ability[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean[] select = new boolean[N];
		ArrayList<Integer> result = new ArrayList<>();
		getMembers(N, 0, select, result, ability);
		Collections.sort(result);
		System.out.println(result.get(0));
	}
	
	public static int getSubSetSumMinDiff(int N, int[][] ability, boolean[] select) {
		int sum1 = 0;
		int sum2 = 0;
		
		for (int i = 0; i < ability.length; i++) {
			for (int j = 0; j < ability.length; j++) {
				if(select[i] && select[j]) sum1 += ability[i][j];
				else if(!select[i] && !select[j]) sum2 += ability[i][j];
			}
		}
		return Math.abs(sum1-sum2);
	}
	
	public static void getMembers(int N, int cs, boolean[] select, ArrayList<Integer> result
			, int[][] ability) {
		if(N == cs) {
			int cnt = 0;
			for (int i = 0; i < select.length; i++) {
				if(select[i]) cnt++;
			}
			if(cnt == N/2) result.add(getSubSetSumMinDiff(N, ability, select));
			return; 
		}
		select[cs] = true;
		getMembers(N, cs+1, select, result, ability);
		select[cs] = false;
		getMembers(N, cs+1, select, result, ability);
	}

}
