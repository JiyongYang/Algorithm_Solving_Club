package test.naver190921;


public class Solution_Q2 {

	public static void main(String[] args) {
		String[] in = {"######",">#*###","####*#","#<#>>#",">#*#*<","######"};
		System.out.println(solution(in));
	}
	
	public static int solution(String[] drum) {
		int[] dx = {0, 1, -1};
		int[] dy = {1, 0, 0};
		int answer = 0;
		int Y = drum.length;
		int X = drum[0].length();
		int[][] map = new int[Y][X];
		for (int y = 0; y < Y; y++) {
			for (int x = 0; x < X; x++) {
				switch(drum[y].charAt(x)) {
				case '#':
					map[y][x] = 0;
					break;
				case '>':
					map[y][x] = 1;
					break;
				case '<':
					map[y][x] = 2;
					break;
				case '*':
					map[y][x] = 3;
					break;
				}
			}
		}
		for (int y = 0; y < Y; y++) {
			for (int x = 0; x < X; x++) {
				System.out.print(map[y][x]+" ");
			}
			System.out.println();
		}
		
		
		for (int x = 0; x < X; x++) {
			int astrickCnt = 0;
			boolean flg = true;
			int xPos = x;
			int yPos = 0;
			
			while(true) {
				
				int val = map[yPos][xPos];
				if(val < 3) {
					yPos += dy[val];
					xPos += dx[val];
				} else {
					astrickCnt++;
					yPos += dy[0];
					xPos += dx[0];
					if(astrickCnt>=2) {
						flg = false;
						break;
					}
				}
				
				if(yPos == Y) {
					break;
				}
			}
			if(flg) answer++;
		}
		
		
		
		return answer;
	}
	
}
