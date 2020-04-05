package test.kakao_test_191109;

import java.util.Arrays;
import java.util.Stack;

public class Solution_Q1 {
	
	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0},
				{0,0,1,0,3},
				{0,2,5,0,1},
				{4,2,4,4,2},{3,5,1,3,1}
				};
		int[] moves = {1,5,3,5,1,2,1,4};
		
		
		System.out.println(solution(board, moves));
	}
	
	public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        int n = board.length;
        
        Stack<Integer>[] stack = new Stack[n+1];
        for (int i = 0; i <= n; i++) {
			stack[i] = new Stack<>();
		}
        
        for (int x = 0; x < n; x++) {
			for (int y = n-1; y >= 0; y--) {
				if(board[y][x] == 0) continue;
				stack[x+1].add(board[y][x]);
			}
		}
        
        
        Stack<Integer> result = new Stack<>();
        
        for (int i = 0; i < moves.length; i++) {
			int mv = moves[i];
			if(stack[mv].isEmpty()) continue;
			
			int poped = stack[mv].pop();
			if(result.isEmpty()) {
				result.add(poped);
			} else {
				if(result.peek() == poped) {
					result.pop();
					answer += 2;
				} else {
					result.add(poped);
				}
			}
		}
        
        return answer;
    }
}
