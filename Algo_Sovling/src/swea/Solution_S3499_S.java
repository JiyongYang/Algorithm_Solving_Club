package swea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_S3499_S {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			String[] deck = br.readLine().split(" ");
			
			StringBuilder sb = new StringBuilder();
			int x = 0;
			try {
				if(N%2== 1) {
					for (int i = 0; i < deck.length/2+1; i++) {
						if(i == deck.length/2) {
							sb.append(deck[i]);
							break;
						}
						sb.append(deck[i]+" "+deck[i+(deck.length/2+1)]+" ");
					}
				}
				else {
					for (int i = 0; i < deck.length/2; i++) {
						sb.append(deck[i]+" "+deck[i+(deck.length/2)]+" ");
					}
				}
			} catch (Exception e) {
//				System.out.println(x);
			}
			
			bw.write("#"+t+" "+sb+"\n");
			bw.flush();
		}
		
		bw.close();
		br.close();
	}
}
