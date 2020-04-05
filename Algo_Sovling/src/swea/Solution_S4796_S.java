package swea;
import java.io.IOException;
import java.util.*;

public class Solution_S4796_S {

    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();
    	for (int t = 1; t <= T; t++) {
    		int n = sc.nextInt();
    		int[] num = new int[n];
    		for (int i = 0; i < n; i++) {
				num[i] = sc.nextInt();
			}
    		
    		int inMax = num[0];
    		int lCnt = 0;
    		int rCnt = 0;
    		int totalCnt = 0;
    		boolean uflg = false;
    		boolean dflg = false;
    		
    		if(num[0] < num[1]) {
    			uflg = true;
    			lCnt = 1;
    		} else {
    			dflg = true;
    			rCnt = 1;
    		}
    		
    		for (int i = 1; i < num.length; i++) {
				if(num[i] > num[i-1]) {
					if(uflg) {
						lCnt++;
					} else {
						// 계산 시점
						if(lCnt == 0 || rCnt == 0) {
							lCnt = 2;
							rCnt = 0;
							uflg = true;
							dflg = false;
							continue;
						}
						totalCnt += lCnt*rCnt;
						
						// 계산 이후 초기화
						lCnt = 2;
						rCnt = 0;
						uflg = true;
						dflg = false;
					}
				} else {
					// 내려가는 구조
					if(!dflg) {
						inMax = num[i-1];
						if(lCnt != 1) lCnt--;
						uflg = false;
						dflg = true;
						rCnt = 1;
					} else {
						rCnt++;
					}
				}
				
			}
    		if(lCnt != 0 && rCnt != 0) {
    			totalCnt += lCnt*rCnt;
    		}
    		
    		System.out.println("#"+t+" "+totalCnt);
    		
    		
		}
    }
}