package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_S1983_S {

	public static void main(String[] args) {
		int brE = 1;
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputString = "";
		try {
			inputString = br.readLine();
		}catch(IOException e) {
			System.out.println(brE++);
			e.printStackTrace();
		}
		
		int T = Integer.parseInt(inputString);
		
		for (int i = 1; i <= T; i++) {
			try {
				inputString = br.readLine();
			}catch(IOException e) {
				System.out.println(brE++);
				e.printStackTrace();
			}
			StringTokenizer st = new StringTokenizer(inputString);
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
//			int[][] stu = new int[N][3];
			int[] sumStu = new int[N];
			int val = -1;
			
			for (int j = 0; j < N; j++) {
				try {
					inputString = br.readLine();
				}catch(IOException e) {
					System.out.println(brE++);
					e.printStackTrace();
				}
				st = new StringTokenizer(inputString);
				
				int mid = Integer.parseInt(st.nextToken());
				int fin = Integer.parseInt(st.nextToken());
				int assignment = Integer.parseInt(st.nextToken());
				
				sumStu[j] = (int)(mid*35 + fin*45 + assignment*20);
//				System.out.print(mid + "/" + fin  + "/" + assignment + " >> ");
//				System.out.println(sumStu[j]);
				
				if(j+1 == K) val = sumStu[j];
				
			}
			
			Arrays.sort(sumStu);
			int pos = -1;
			for (int j = 0; j < sumStu.length; j++) {
				if( val == sumStu[j]) {
					pos = j;
					break;			
				}
			}
			
			
			int pos_ratio = (int)(pos/(double)N * 10);
			
			String credit = "";
			switch(pos_ratio) {
				case 0:
					credit = "D0";
					break;
				case 1:
					credit = "C-";
					break;
				case 2:
					credit = "C0";
					break;
				case 3:
					credit = "C+";
					break;
				case 4:
					credit = "B-";
					break;
				case 5:
					credit = "B0";
					break;
				case 6:
					credit = "B+";
					break;
				case 7:
					credit = "A-";
					break;
				case 8:
					credit = "A0";
					break;
				case 9:
				case 10:
					credit = "A+";
					break;
					
			}
			
			System.out.println("#"+i+" "+credit + " || "+ pos);
		}
	}
}
