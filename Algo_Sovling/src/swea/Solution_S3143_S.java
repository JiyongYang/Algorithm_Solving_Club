package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_S3143_S {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			String[] inputString = br.readLine().split(" ");
			String result = inputString[0].replace(inputString[1], "z");
			System.out.println("#"+t+" "+result.length());
			
			
		}
	}

}
