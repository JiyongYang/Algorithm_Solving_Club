package test.monthtest_190823;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algo2_구미_2반_양지용 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		int NumOfDeli = Integer.parseInt(br.readLine());
		int[] farmW = new int[W];
		int[] farmH = new int[H];
		int deliWcnt = 0;
		int deliHcnt = 0;
		
		for (int i = 0; i < NumOfDeli; i++) {
			st = new StringTokenizer(br.readLine());
			int ty = Integer.parseInt(st.nextToken());
			int pos = Integer.parseInt(st.nextToken());
			if(ty==0) {
				farmH[pos] = 1;
				deliHcnt++;
			}
			else {
				farmW[pos] = 1;
				deliWcnt++;
			}
		}
		
		int[] farmHSize = new int[deliHcnt+1];
		int[] farmWSize = new int[deliWcnt+1];
		int hOffset = 0;
		int wOffset = 0;
		int innerCnt = 0;
		for (int i = 0; i < farmH.length; i++) {
			if(farmH[i] == 1) {
				farmHSize[hOffset++] = innerCnt;
				innerCnt = 1;
			} else {
				innerCnt++;
			}
			
			if(i == farmH.length-1) {
				farmHSize[hOffset] = innerCnt;
			}
		}
		innerCnt = 0;
		for (int i = 0; i < farmW.length; i++) {
			if(farmW[i] == 1) {
				farmWSize[wOffset++] = innerCnt;
				innerCnt = 1;
			} else {
				innerCnt++;
			}
			
			if(i == farmW.length-1) {
				farmWSize[wOffset] = innerCnt;
			}
		}
		
		Arrays.sort(farmHSize);
		Arrays.sort(farmWSize);
		
		int result = farmHSize[farmHSize.length-1]*farmWSize[farmWSize.length-1];
		bw.write(result+"");
		
		bw.close();
		br.close();
	}

}
