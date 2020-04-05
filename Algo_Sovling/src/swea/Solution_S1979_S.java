package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_S1979_S {

	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String _in = "";
		try {
			_in = bf.readLine();
		}catch(IOException e) {
			System.out.println(e);
			e.getStackTrace();
		}
		
		int T = Integer.parseInt(_in);
		
		for (int z = 1; z <= T; z++) {
			try {
				_in = bf.readLine();
			}catch(IOException e) {
				System.out.println(e);
				e.getStackTrace();
			}
			
			st = new StringTokenizer(_in);
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[][] nums = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				try {
					_in = bf.readLine();
				}catch(IOException e) {
					System.out.println(e);
					e.getStackTrace();
				}
				
				st = new StringTokenizer(_in);
				
				for (int j = 0; j < N; j++) {
					nums[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// algo START
			int cnt = 0;
			for (int j = 0; j < nums.length; j++) {
				for (int i = 0; i < nums.length; i++) {
					boolean flg;
					if(j < nums.length-K+1)
					{
						flg = true;					
						// right
						if((j>0 && nums[j-1][i] == 0) || j == 0) {
							for (int q = 0; q <= K; q++) {
								if(j+q > nums.length) flg = false;
								if(j+q >= nums.length)
									break;
								if((q!=K && nums[j+q][i] == 0) || (q==K && nums[j+q][i] == 1)) {
									flg = false;
									break;
								}
							}
							if(flg) cnt++;
								
						}
					}
					
					if(i < nums.length-K+1)
					{
						flg = true;
						// down
						if((i>0 && nums[j][i-1] == 0) || i == 0) {
							for (int q = 0; q <= K; q++) {
								if(i+q > nums.length) flg = false;
								if(i+q >= nums.length) 
									break;
								if((q!=K && nums[j][i+q] == 0) || (q==K && nums[j][i+q] == 1)) {
									flg = false;
									break;
								}
							}
							if(flg)	cnt++;
						}
					}
				}
			}
			
			System.out.println("#"+z+" "+cnt);
			
			// algo END
		}
	}
}
