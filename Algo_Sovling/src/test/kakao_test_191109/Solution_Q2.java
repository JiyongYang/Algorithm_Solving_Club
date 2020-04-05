package test.kakao_test_191109;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_Q2 {
	public static void main(String[] args) {
		Solution_Q2 q2 = new Solution_Q2();
		
		System.out.println(Arrays.toString(q2.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
		System.out.println(Arrays.toString(q2.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
		System.out.println(Arrays.toString(q2.solution("{{20,111},{111}}")));
		System.out.println(Arrays.toString(q2.solution("{{123}}")));
		System.out.println(Arrays.toString(q2.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")));
	}
	
	public int[] solution(String s) {
        int[] answer = {};
        
        ArrayList<Integer> result = new ArrayList<>();
        
        String subs = s.substring(1, s.length()-1);
//        System.out.println(subs);
        
        String[] subSet = subs.split("}");
//        System.out.println(Arrays.toString(subSet));
        for (int i = 0; i < subSet.length; i++) {
			subSet[i] = subSet[i].replace("{", "");
		}
//        System.out.println(Arrays.toString(subSet));
        
        ArrayList<Integer>[] list = new ArrayList[501];
        for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
        
        for (int i = 0; i < subSet.length; i++) {
        	String[] splitedSet = subSet[i].split(",");
//        	System.out.println(Arrays.toString(splitedSet));
        	
        	ArrayList<Integer> tempList = new ArrayList<>();
        	for (int j = 0; j < splitedSet.length; j++) {
				if(splitedSet[j].length() == 0) continue;
//				System.out.println(splitedSet[j]);
				tempList.add(Integer.parseInt(splitedSet[j]));
			}
        	list[tempList.size()].addAll(tempList);
        }
        
        for (int i = 1; i < list.length; i++) {
			if(list[i].size()==0) break;
//			System.out.println(list[i]);
			
			for (int k = 0; k < list[i].size(); k++) {
				if(!result.contains(list[i].get(k))) {
					result.add(list[i].get(k));
					break;
				}
			}
			
		}
        
        
        answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
			answer[i] = result.get(i);
		}
        
        return answer;
    }
}
