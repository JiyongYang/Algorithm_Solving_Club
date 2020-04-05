package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_S1215_S {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		String _in = "";
		
		
		for (int t = 1; t <= 10; t++) {
			try {
				_in = br.readLine();
			} catch (IOException e) {
				System.out.println(e);
			}
			
			int lenPd = Integer.parseInt(_in);
			char[][] wordMap = new char[8][8];
			
			for (int i = 0; i < 8; i++) {
				try {
					_in = br.readLine();
				} catch (IOException e) {
					System.out.println(e);
				}
				
				for (int j = 0; j < 8; j++) {
					wordMap[i][j] = _in.charAt(j); 
				}
			}
			
			int cnt = 0;
			for (int y = 0; y < wordMap.length; y++) {
				for (int x = 0; x < wordMap.length; x++) {
					//System.out.println(String.format("[IN]%d, %d ", y, x));
					if(x <= wordMap.length - lenPd) {
						
						char[] tempWord = new char[lenPd];
						for (int k = 0; k < tempWord.length; k++) {
							tempWord[k] = wordMap[y][x+k];
						}
						if(checkPalinDrome(tempWord)) {
							cnt++;
//							System.out.println(String.format("[r]%d, %d ", y, x));
						}
					}
					
					if(y <= wordMap.length - lenPd) {
						char[] tempWord = new char[lenPd];
						for (int k = 0; k < tempWord.length; k++) {
							tempWord[k] = wordMap[y+k][x];
						}
						
						if(checkPalinDrome(tempWord)) {
							cnt++;
//							System.out.println(String.format("[d]%d, %d ", y, x));
						}
					}
				}
			}
			
			System.out.println("#"+t+" "+cnt);
			
		}
		
	}

	private static boolean checkPalinDrome(char[] word) {
		for (int i = 0; i < word.length/2; i++) 
			if(word[i] != word[word.length-1-i]) return false;
		return true;
	}
}
