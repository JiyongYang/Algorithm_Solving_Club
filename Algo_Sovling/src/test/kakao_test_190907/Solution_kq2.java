package test.kakao_test_190907;
import java.util.Stack;

class Solution_kq2 {
	public static void main(String[] args) {
		System.out.println(solution("(()())()"));
	}
    public static String solution(String p) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        
        for (int i = 0; i < p.length(); i++) {
        	char base = p.charAt(i);
        	if(base=='(') {
        		s1.add('(');
        		if(s1.size()==s2.size()) {
//        			System.out.println(s2.size()+"");
        			StringBuilder t1 = new StringBuilder();
        			StringBuilder t2 = new StringBuilder();
        			while(!s1.isEmpty()) {
        				t1.append(s1.pop()+"");
        			}
        			while(!s2.isEmpty()) {
        				t2.append(s2.pop()+"");
        			}
        			sb.append(t1.toString()+t2.toString());
        		}
        	}
        	if(base==')') {
        		s2.add(')');
        		if(s1.size()==s2.size()) {
//        			System.out.println(s2.size()+"");
        			StringBuilder t1 = new StringBuilder();
        			StringBuilder t2 = new StringBuilder();
        			while(!s1.isEmpty()) {
        				t1.append(s1.pop()+"");
        			}
        			while(!s2.isEmpty()) {
        				t2.append(s2.pop()+"");
        			}
        			sb.append(t1.toString()+t2.toString());
        		}
        	}
		}
        
        return sb.toString();
    }
}