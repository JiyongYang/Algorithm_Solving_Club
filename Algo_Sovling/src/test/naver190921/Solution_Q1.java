package test.naver190921;


public class Solution_Q1 {

	public static void main(String[] args) {
		String[] in = {"@.com"};
		System.out.println(solution(in));
//		String[] in = {"abc.def@x.com", "abc", "abc@defx", "abc@defx.xyz"};
//		System.out.println(solution(in));
	}
	
	public static int solution(String[] emails) {
		int answer = 0;
		
		for (int i = 0; i < emails.length; i++) {
			String[] sEmail = emails[i].split("@");
			if(sEmail.length != 2 || sEmail[0].length() == 0) continue;
			
			String[] domain = sEmail[1].split("\\.");
			if(domain.length != 2 || domain[0].length() == 0) continue;
			
			if(domain[1].equals("com") || domain[1].equals("net") || domain[1].equals("org")) {
				answer++;
			}
		}
		
		return answer;
	}
}
