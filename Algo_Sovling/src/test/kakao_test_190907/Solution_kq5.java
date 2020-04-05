package test.kakao_test_190907;
import java.util.Arrays;

class Solution_kq5 {
    public int solution(int n, int[] weak, int[] dist) {
        int answer = 10;
        int cnt = weak.length;
        int[] map = new int[n*3];
        for (int i = 0; i < 3; i++) {
			for (int k = 0; k < weak.length; k++) {
				map[n*i+weak[k]] = weak[k];
			}
		}
        Arrays.sort(dist);
        for (int i = 0; i < map.length-n; i++) {
			int inCnt = 0;
			boolean[] check = new boolean[n+1];
			int offset = 0;
			int pos = 0;
				for (int j = i; j < map.length; j++) {
					if(map[j] != 0) {
						pos = j;
						
						for (int q = pos; q < dist[offset]; q++) {
							if(map[q] != 0 && !check[map[q]]) {
								check[map[q]] = true;
								inCnt++;
								if(inCnt == cnt) {
									if(answer > offset)
									break;
								}
							}
						}
						
					}
				}
			
		}
        
        
        return answer;
    }
}