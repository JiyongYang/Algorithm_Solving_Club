package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_S5658_S {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			String in = br.readLine();
			st = new StringTokenizer(in);
			int N = Integer.parseInt(st.nextToken());
			int lenOfLine = N/4;
			int cntOfList = N/lenOfLine;
			int K = Integer.parseInt(st.nextToken());
			String numberList = br.readLine();
			String[] slicedList = new String[cntOfList];
			ArrayList<String> resultList = new ArrayList<>();
			
			for (int i = 0; i < lenOfLine; i++) {
				for (int j = 0; j < slicedList.length; j++) {
					slicedList[j] = numberList.substring(j*lenOfLine, j*lenOfLine + lenOfLine);
				}
				
				for (int j = 0; j < slicedList.length; j++) {
					if(!resultList.contains(slicedList[j])) {
						resultList.add(slicedList[j]);
					}
				}
				numberList = rotateString(numberList);
			}
			
			int[] resultNumberList = new int[resultList.size()];
			for (int j = 0; j < resultList.size(); j++) {
				resultNumberList[j] = Integer.parseInt(resultList.get(j), 16);
			}
			
			Arrays.sort(resultNumberList);
			System.out.println("#"+t+" "+resultNumberList[resultNumberList.length - K]);
		}
	}
	
	public static String rotateString(String in) {
		char lastChar = in.charAt(in.length()-1);
		return lastChar + in.substring(0, in.length()-1);
	}
}
