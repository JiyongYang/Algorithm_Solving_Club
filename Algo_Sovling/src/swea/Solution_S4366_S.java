package swea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Solution_S4366_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int number = -1;
	static boolean flg = false;
	
    public static void main(String[] args) throws IOException {
    	int T = Integer.parseInt(br.readLine());
    	
    	for (int t = 1; t <= T; t++) {
    		String s1 = br.readLine();
    		String s2 = br.readLine();
    		flg = false;
    		number = -1;
    		
    		int[] n1 = new int[s1.length()];
    		int[] n2 = new int[s2.length()];
    		
    		for (int i = 0; i < n1.length; i++) {
				n1[i] = s1.charAt(i)-'0';
			}
    		for (int i = 0; i < n2.length; i++) {
				n2[i] = s2.charAt(i)-'0';
			}
    		
    		genCase(n1, n2);
    		
    		bw.write("#"+t+" "+number+"\n");
		}
    	
    	bw.close();
    	br.close();
    }
    
    public static void genCase(int[] n1, int[] n2) {
    	for (int i = 0; i < n1.length; i++) {
			n1[i] = (n1[i]+1)%2;
			for (int j = 0; j < n2.length; j++) {
				n2[j] = (n2[j]+1)%3;
				// logic
				genNum(n1, n2);
				n2[j] = (n2[j]+1)%3;
				// logic
				genNum(n1, n2);
				n2[j] = (n2[j]+1)%3;
				// restore
				if(flg) return;
			}
			n1[i] = (n1[i]+1)%2;
		}
    }
    
    public static void genNum(int[] n1, int[] n2) {
    	int n1Val = 0;
    	int n2Val = 0;
    	for (int i = n1.length-1, j = 0; i >= 0; i--, j++) {
			n1Val+=n1[i]*((int)Math.pow(2, j));
		}
    	for (int i = n2.length-1, j = 0; i >= 0; i--, j++) {
    		n2Val+=n2[i]*((int)Math.pow(3, j));
    	}
    	if(n1Val == n2Val) {
    		number=n1Val;
    		flg = true;
    	}
    }
}