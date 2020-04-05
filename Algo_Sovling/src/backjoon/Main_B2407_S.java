package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.*;

public class Main_B2407_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static BigInteger[][] mem = null;

    public static void main(String[] args) throws IOException {
    	st = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	mem = new BigInteger[n+1][m+1];
    	for (int i = 0; i < mem.length; i++) {
    		for (int j = 0; j < mem[i].length; j++) {
				mem[i][j] = new BigInteger("0");
			}
		}
    	
    	bw.write(nCm1(n, m)+"");
    	
    	br.close();
    	bw.close();
    }
    
    public static BigInteger nCm1(int n, int m) {
    	if(m==0 || n==m) return new BigInteger("1");
    	else {
    		if(!mem[n][m].equals(new BigInteger("0"))) return mem[n][m];
    		else {
    			mem[n][m] = nCm1(n-1, m-1).add(nCm1(n-1, m));
    			return mem[n][m];
    		}
    	}
    }
}