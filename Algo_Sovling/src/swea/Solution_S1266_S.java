package swea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_S1266_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int skillOfMasterA = Integer.parseInt(st.nextToken());
			int skillOfMasterB = Integer.parseInt(st.nextToken());
			int failOfMasterA = 100 - skillOfMasterA;
			int failOfMasterB = 100 - skillOfMasterB;
			Double[][] cnt = new Double[19][2];
			double sum1= 0.0;
			double sum2= 0.0;
			
			for (int i = 1; i < cnt.length; i++) {
				Double upper = fac(new Long(18), i, 0);
				Double lower = fac(new Long(i), i, 0);
				cnt[i][0] = ((upper/lower) * Math.pow((skillOfMasterA/100.0), i) * Math.pow((failOfMasterA/100.0), 18-i));
				cnt[i][1] = ((upper/lower) * Math.pow((skillOfMasterB/100.0), i) * Math.pow((failOfMasterB/100.0), 18-i));
				
				if(i==2 || i==3 || i==5 || i==7 || i==11 || i==13 || i==17) {
					sum1+=cnt[i][0];
					sum2+=cnt[i][1];
				}
			}
			
			bw.write(String.format("#%d %.6f | %.6f\n",t, ((sum1+sum2)-sum1*sum2), 1-(1-sum1)*(1-sum2)));
			
		}
		bw.close();
		br.close();
	}
	
	public static Double fac(Long n, int m, int depth) {
		if(m == depth) return 1.0;
		else {
			Double result = n*fac(n-1, m, depth+1);
			return result;
		}
	}
}
