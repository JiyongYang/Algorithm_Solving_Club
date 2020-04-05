package test.kakao_test_191109;

import java.util.Arrays;

public class Solution_Q5 {

	public static void main(String[] args) {
		Solution_Q5 q5 = new Solution_Q5();
		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		int k = 3;
		
		System.out.println(q5.solution(stones, k));
	}
	
	public int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;
        
        for (int i = 0; i < stones.length-k+1; i++) {
			int maxVal = 0;
			for (int kk = 0; kk < k; kk++) {
				if(stones[i+kk] > maxVal) maxVal = stones[i+kk];
			}
			
			if(answer > maxVal) answer = maxVal;
		}
        
        if(answer == Integer.MAX_VALUE)
        	answer = 0;
        
        return answer;
    }
}
