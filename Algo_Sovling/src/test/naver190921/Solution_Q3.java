package test.naver190921;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution_Q3 {

	public static void main(String[] args) {
		int[][] data = {{1, 0, 5},{2, 2, 2},{3, 3, 1},{4, 4, 1},{5, 10, 2}};
		System.out.println(Arrays.toString(solution(data)));
		int[][] data1 = {{1, 0, 3}, {2, 1, 3}, {3, 3, 2}, {4, 9, 1}, {5, 10, 2}};
		System.out.println(Arrays.toString(solution(data1)));
		int[][] data2 = {{1, 2, 10}, {2, 5, 8}, {3, 6, 9}, {4, 20, 6}, {5, 25, 5}};
		System.out.println(Arrays.toString(solution(data2)));
	}
	
	public static int[] solution(int[][] data) {
		PriorityQueue<Doc> pq = new PriorityQueue<>();
		
		int gTime = 0;
		int cnt = 0; //이미 처리한 데이터 개수
		int offset = 0;
		int N = data.length; // 전체 데이터 개수
		int[] answer = new int[N];
		int printing = 0;
		while(true) {
			if(cnt < N) {
				int[] cur = data[cnt];
				if(cur[1] <= gTime) {
					pq.add(new Doc(cur[0], cur[1], cur[2]));
					cnt++;
				}
			}
			if(printing > 0) printing--;
			// 대기열이 비어 있음
			if(printing == 0) {
				if(!pq.isEmpty()) {
					Doc doc = pq.poll();
					System.out.println(doc);
					printing = doc.pages;
					answer[offset++] = doc.num;
				}
			}
			
			gTime++;
			if(cnt == N && offset == N) break;
		}
		
		
		return answer;
	}
	
	static class Doc implements Comparable<Doc>{
		int num;
		int time;
		int pages;
		public Doc(int num, int time, int pages) {
			this.num = num;
			this.time = time;
			this.pages = pages;
		}
		@Override
		public int compareTo(Doc o) {
			return (pages == o.pages) ? time - o.time : pages - o.pages;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Doc [num=" + num + ", time=" + time + ", pages=" + pages + "]";
		}
	}
}
