package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_B2607_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		StringBuilder[] words = new StringBuilder[N];
		
		for (int i = 0; i < N; i++) {
			words[i] = new StringBuilder(br.readLine());
		}
		
		bw.write(getDiff(words)+"");
		br.close();
		bw.close();
	}

	private static int getDiff(StringBuilder[] words) {
		int simWord = 0;
		int[] baseCnt = new int[26];
		for (int j = 0; j < words[0].length(); j++) {
			baseCnt[words[0].charAt(j)-65]++;
		}
		
		for (int i = 1; i < words.length; i++) {
			int[] wordCnt = new int[26];
			for (int j = 0; j < words[i].length(); j++) {
				wordCnt[words[i].charAt(j)-65]++;
			}
			
			// 기준 단어와의 차이값
			int[] diffCnt = new int[26];
			int diffCharCnt = 0;
			for (int j = 0; j < diffCnt.length; j++) {
				diffCnt[j] = baseCnt[j] - wordCnt[j];
				if(diffCnt[j] != 0) diffCharCnt++;
			}
			
			// 기준 단어와 차이가 3개 이상 나는 경우
			// 해당 단어는 더 이상 확인 X
			if(diffCharCnt >= 3) continue;
			
			int tempSum = 0;
			int absOverTwo = 0;
			for (int j = 0; j < diffCnt.length; j++) {
				tempSum += diffCnt[j];
				// 기준 단어와의 차이가 2개 이상나는 경우
				if(Math.abs(diffCnt[j]) > 1) absOverTwo++;
				// 2개 이상나는 경우가 2번 이상인 경우
				if(absOverTwo >= 2) break;
			}
			// 해당 단어는 더 이상 확인 필요 X
			if(absOverTwo >= 2) continue;
			
			if((tempSum == 1 && diffCharCnt == 1) || tempSum == 0 ||
					(tempSum == -1 && diffCharCnt == 1)) {
				simWord++;
			}
		}
		return simWord;
	}
}
