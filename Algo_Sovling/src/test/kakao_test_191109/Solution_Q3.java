package test.kakao_test_191109;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Solution_Q3 {
	public static void main(String[] args) {
		Solution_Q3 q3 = new Solution_Q3();
		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id = {"fr*d*", "abc1**"};
		String[] user_id2 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id2 = {"fr*d*", "*rodo", "******", "******"};
		String[] user_id3 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id3 = {"*rodo", "*rodo", "******"};
		
		System.out.println(q3.solution(user_id, banned_id));
		System.out.println(q3.solution(user_id3, banned_id3));
		System.out.println(q3.solution(user_id2, banned_id2));
	}
	
	
	public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        
        ArrayList<String>[] candidateList = new ArrayList[banned_id.length];
        for (int i = 0; i < candidateList.length; i++) {
			candidateList[i] = new ArrayList<>();
		}
        
        for (int i = 0; i < banned_id.length; i++) {
			String base = banned_id[i];
			ArrayList<String> temp = new ArrayList<>();
			for (int j = 0; j < user_id.length; j++) {
				if(user_id[j].length() != base.length()) continue;
				temp.add(user_id[j]);
			}
//			System.out.println(temp);
			
			// 각 후보군 별로 banned_id에 매칭되는 문자열 찾기
			ArrayList<String> tempResult = new ArrayList<>();
			for (int j = temp.size()-1; j >= 0 ; j--) {
				for (int k = 0; k < base.length(); k++) {
					if(base.charAt(k) == temp.get(j).charAt(k)) continue;
					if(base.charAt(k) == '*') continue;
					temp.remove(j);
					break;
				}
			}
			
			// 찾은 문자열 넣기
			candidateList[i].addAll(temp);
			
		}
        
//        System.out.println(Arrays.toString(candidateList));
        
        ArrayList<String> arr = new ArrayList<>();
        HashSet<String> result = new HashSet<>();
        
        dfs(arr, candidateList, banned_id.length, 0, result);
//        System.out.println(result);
        
        return result.size();
    }
	
	public void dfs(ArrayList<String> arr, ArrayList<String>[] candidateList, 
			int size, int start, HashSet<String> result) {
		if(arr.size() == size) {
			ArrayList<String> temp = new ArrayList<>();
			temp.addAll(arr);
			Collections.sort(temp);
//			System.out.println(temp.toString());
			result.add(temp.toString());
			return;
		}
		for (int i = start; i < candidateList.length; i++) {
			for (int k = 0; k < candidateList[i].size(); k++) {
				if(arr.contains(candidateList[i].get(k))) continue;
				
				arr.add(candidateList[i].get(k));
				dfs(arr, candidateList, size, i+1, result);
				arr.remove(arr.size()-1);
			}
		}
	}
}
