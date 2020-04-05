package test.kakao_test_191109;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

public class Solution_Q4 {
	static class Room implements Comparable<Room>{
		Long num;
		Long next;
		public Room(Long num, Long next) {
			this.num = num;
			this.next = next;
		}
		@Override
		public int compareTo(Room o) {
			return num.compareTo(o.num);
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((num == null) ? 0 : num.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Room other = (Room) obj;
			if (num == null) {
				if (other.num != null)
					return false;
			} else if (!num.equals(other.num))
				return false;
			return true;
		}
	}
	
	public static void main(String[] args) {
		Solution_Q4 q4 = new Solution_Q4();
		
		long k = 10;
		long[] room_number = {1,3,4,1,3,1};
		
		System.out.println(Arrays.toString(q4.solution(k, room_number)));
	}
	
	
	public long[] solution1(long k, long[] room_number) {
        long[] answer = {};
        
        TreeSet<Long> ts = new TreeSet<>();
        ArrayList<Long> result = new ArrayList<>();
        
        for (int i = 0; i < room_number.length; i++) {
			if(!ts.contains(room_number[i])) {
				ts.add(room_number[i]);
				result.add(room_number[i]);
			} else {
				Long temp = ts.ceiling(room_number[i]);
				while(true) {
					temp += 1;
					if(!ts.contains(temp)) {
						ts.add(temp);
						result.add(temp);
						break;
					}
				}
//				System.out.println(temp);
			}
//			System.out.println(ts);
		}
        answer = new long[ts.size()];
        for (int i = 0; i < answer.length; i++) {
			answer[i] = result.get(i);
		}
        
        return answer;
    }
	
	public long[] solution(long k, long[] room_number) {
		long[] answer = {};
		HashMap<Long, Room> hm = new HashMap<>();
		ArrayList<Long> result = new ArrayList<>();
		for (int i = 0; i < room_number.length; i++) {
			Long num = room_number[i];
			
			if(hm.containsKey(num)) {
				// 이미 값이 있는 경우
				Long find = num+1;
				ArrayList<Long> temp = new ArrayList<>();
				while(hm.containsKey(find)) {
					temp.add(find);
					find = hm.get(find).next;
				}
				hm.put(find, new Room(find, find+1));
				for (Long key : temp) {
					hm.put(key, new Room(key, find+1));
				}
				
				result.add(find);
			} else {
				// 이미 값이 없는 경우
				hm.put(num, new Room(num, num+1));
				result.add(num);
			}
		}
		
		answer = new long[result.size()];
        for (int i = 0; i < answer.length; i++) {
			answer[i] = result.get(i);
		}
		
		return answer;
	}
	
}
