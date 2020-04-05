package swea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_S3459_S {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            long N = Long.parseLong(br.readLine());
            String s = "Alice";
            while(N > 10) {
                N = (N/2) + 1;
                N = (N/2) - 1;
            }
            if( N == 1 || (N >= 6 && N <= 9)){
                s = "Bob";
            }
            bw.write("#"+t+" "+s+"\n");
        }
        br.close();
        bw.close();
    }
}
