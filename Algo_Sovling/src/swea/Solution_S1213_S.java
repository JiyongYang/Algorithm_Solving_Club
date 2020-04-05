package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_S1213_S {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		String _in = "";
		String _cmp = "";
		
		for (int t = 1; t <= 10; t++) {
			try {
				br.readLine();
				_cmp = br.readLine();
				_in = br.readLine();
			} catch (IOException e) {
				System.out.println(e);
			}
			
			int cnt = 0;
			int pos = 0;
			String subString = _in.substring(pos, _in.length());
			
			while(subString.contains(_cmp)) {
				cnt++;
				pos = subString.indexOf(_cmp, 0)+_cmp.length();
				subString = subString.substring(pos, subString.length());
			}
			
			System.out.println("#"+t+" "+cnt);
			
		}
	}

}
