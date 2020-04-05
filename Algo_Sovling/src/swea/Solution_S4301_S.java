package swea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.*;

public class Solution_S4301_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;

    public static void main(String[] args) throws IOException {
    	int T = Integer.parseInt(br.readLine());
    	for (int t = 1; t <= T; t++) {
    		st = new StringTokenizer(br.readLine());
    		int n = Integer.parseInt(st.nextToken());
    		int m = Integer.parseInt(st.nextToken());
    		
    		int cnt = 0;
    		int[][] map = new int[n][m];
    		for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if(i <= 1 && j <= 1) {
						map[i][j] = 1;
						cnt++;
						continue;
					}
					if((i>1 && map[i-2][j] == 1) || (j>1 && map[i][j-2] == 1)) continue;
					map[i][j] = 1;
					cnt++;
				}
			}
    		bw.write("#"+t+" "+cnt+"\n");
    		
		}
    	br.close();
    	bw.close();
    }
}