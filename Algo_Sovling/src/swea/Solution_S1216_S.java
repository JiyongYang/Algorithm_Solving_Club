package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_S1216_S {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		String _in = "";
		
		
		for (int t = 1; t <= 10; t++) {
			try {
				_in = br.readLine();
			} catch (IOException e) { System.out.println(e); }
			
			char[][] wordMap = new char[100][100];
			
			for (int i = 0; i < 100; i++) {
				try {
					_in = br.readLine();
				} catch (IOException e) { System.out.println(e); }
				
				for (int j = 0; j < 100; j++) {
					wordMap[i][j] = _in.charAt(j); 
				}
			}
			
			int maxLen = -1;
			for (int lenPd = 1; lenPd < 100; lenPd++) {
				for (int y = 0; y < wordMap.length; y++) {
					for (int x = 0; x < wordMap.length; x++) {
						//System.out.println(String.format("[IN]%d, %d ", y, x));
						if(x <= wordMap.length - lenPd) {
							
							char[] tempWord = new char[lenPd];
							for (int k = 0; k < tempWord.length; k++) {
								tempWord[k] = wordMap[y][x+k];
							}
							if(checkPalinDrome(tempWord)) {
								if(maxLen < tempWord.length) maxLen = tempWord.length;
//								System.out.println(String.format("[r]%d, %d ", y, x));
							}
						}
						
						if(y <= wordMap.length - lenPd) {
							char[] tempWord = new char[lenPd];
							for (int k = 0; k < tempWord.length; k++) {
								tempWord[k] = wordMap[y+k][x];
							}
							
							if(checkPalinDrome(tempWord)) {
								if(maxLen < tempWord.length) maxLen = tempWord.length;
//								System.out.println(String.format("[d]%d, %d ", y, x));
							}
						}
					}
				}
			}
			
			System.out.println("#"+t+" "+maxLen);
		}
	}
	
	
	private static boolean checkPalinDrome(char[] word) {
		for (int i = 0; i < word.length/2; i++) 
			if(word[i] != word[word.length-1-i]) return false;
		return true;
	}
}
