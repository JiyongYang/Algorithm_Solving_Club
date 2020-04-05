package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.*;

public class Main_B1010_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static BigInteger[][] mem = null;

    public static void main(String[] args) throws IOException {
    	int T = Integer.parseInt(br.readLine());
    	for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
    		
			bw.write(nCm(Math.max(n, m), Math.min(n, m))+"\n");
		}
    	br.close();
    	bw.close();
    }
    
    public static BigInteger nCm(int n, int m) {
    	mem = new BigInteger[n+1][m+1];
    	
    	for (int i = 0; i < mem.length; i++) {
			for (int j = 0; j <= Math.min(i, m); j++) {
				if(j==0 || i==j) mem[i][j] = BigInteger.ONE;
				else mem[i][j] = mem[i-1][j].add(mem[i-1][j-1]);
			}
		}
    	return mem[n][m];
    }
    
}