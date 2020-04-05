package test.kakao_test_190907;
import java.util.Stack;

class Solution_kq3 {
//	public static void main(String[] args) {
//		int[][] key = {{0,0,0}, {1,0,0}, {0,1,1}};
//		int[][] lock = {{1,1,1}, {1,1,0}, {1,0,1}};
//		System.out.println(solution(key, lock));
//	}
	public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        int kN = key.length;
        int lN = lock.length;
        int cnt = 0;
        for (int y = 0; y < lN; y++) {
			for (int x = 0; x < lN; x++) {
				if(lock[y][x]==0) cnt++;
			}
		}
        int[][] lockSpan = new int[lN+kN*2][lN+kN*2];
        for (int y = 0; y < lN; y++) {
			for (int x = 0; x < lN; x++) {
				lockSpan[kN+y][kN+x] = lock[y][x];
			}
		}
        
        // 회전
        answer = test(makeKey(kN, key), lockSpan, cnt, lN);
        
        return answer;
	}
	public static boolean test(int[][][] keys, int[][] lockSpan, int cnt, int lN) {
		int kS = keys[0].length;
		for (int y = 0; y < lockSpan.length-kS; y++) {
			for (int x = 0; x < lockSpan.length-kS; x++) {
				
				for (int i = 0; i < 4; i++) {
					boolean innerResult = true;
					int innerCnt = 0;
					for (int dy = 0; dy < kS; dy++) {
						for (int dx = 0; dx < kS; dx++) {
							if(lockSpan[y+dy][x+dx] == 0 && keys[i][dy][dx] == 1) {
								if(y+dy >= kS && y+dy < kS+lN && 
										x+dx >= kS && x+dx < kS+lN ) {
									innerCnt++;
								}
								continue;
							}
							if(lockSpan[y+dy][x+dx] == 1 && keys[i][dy][dx] == 0) continue;
							if(lockSpan[y+dy][x+dx] == 0 && keys[i][dy][dx] == 0) continue;
							if(lockSpan[y+dy][x+dx] == 1 && keys[i][dy][dx] == 1) {
								innerResult = false;
								break;
							}
						}
					}
					
					if(innerResult && innerCnt == cnt) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	
	public static int[][][] makeKey(int kN, int[][] key){
		int[][][] keys = new int[4][kN][kN];
        
        for (int y = 0; y < kN; y++) {
			for (int x = 0; x < kN; x++) {
				keys[0][y][x] = key[y][x];
			}
		}
        for (int y = 0; y < kN; y++) {
        	for (int x = 0; x < kN; x++) {
        		keys[1][y][x] = key[x][kN-1-y];
        	}
        }
        for (int y = 0; y < kN; y++) {
        	for (int x = 0; x < kN; x++) {
        		keys[2][y][x] = keys[1][x][kN-1-y];
        	}
        }
        for (int y = 0; y < kN; y++) {
        	for (int x = 0; x < kN; x++) {
        		keys[3][y][x] = keys[2][x][kN-1-y];
        	}
        }
        
//        for (int i = 0; i < 4; i++) {
//			for (int y = 0; y < kN; y++) {
//				for (int x = 0; x < kN; x++) {
//					System.out.print(keys[i][y][x]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println("\n");
//		}
        
        return keys;
	}
}