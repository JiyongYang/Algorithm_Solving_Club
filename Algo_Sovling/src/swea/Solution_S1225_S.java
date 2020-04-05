package swea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_S1225_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		for (int t = 1; t <= 10; t++) {
			br.readLine();
			String in = br.readLine();
			st = new StringTokenizer(in);
			int[] nums = new int[8];
			for (int i = 0; i < 8; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}
			
			bw.write("#"+t+" "+decoder(nums)+"\n");
			bw.flush();
		}
		bw.close();
		br.close();
	}
	
	public static String decoder(int[] nums) {
		int cnt = 0;
		int pos = 0;
		while(true) {
			nums[pos%8] -= (cnt++)%5+1;
			if(nums[pos%8] <= 0) {
				nums[pos%8] = 0;
				break;
			}
			pos = (++pos);
		}
		
		//shift
		for (int i = 0; i < (pos+1)%8; i++) {
			int temp = nums[0];
			for (int j = 0; j < 7; j++) {
				nums[j] = nums[j+1];
			}
			nums[7] = temp;
		}
		
		String result = "";
		for (int i = 0; i < nums.length; i++) {
			result += nums[i]+" ";
		}
		return result;
	}
	
}
