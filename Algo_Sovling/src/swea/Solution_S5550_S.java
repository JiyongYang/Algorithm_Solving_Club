package swea;
import java.util.*;
import java.io.*;

public class Solution_S5550_S {
	static class Frog implements Comparable<Frog>{
		char[] c;
		int size;
		public Frog(char c, int size) {
			this.c = new char[5];
			this.c[0] = c;
			this.size = size;
		}
		@Override
		public int compareTo(Frog o) {
			return o.size - size;
		}
	}
	
	static int[] cnt = null;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] words = new String[N];
		
		for (int i = 0; i < words.length; i++) {
			words[i] = sc.next();
			System.out.println("#"+(i+1)+" "+run(words[i]));
			
		}
		
	}
	
	public static int run(String word) {
		cnt = new int[5];
		int result = 0;
		
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			switch(ch) {
			case 'c':
				cnt[0]++;
				break;
			case 'r':
				if(cnt[0] > 0) {
					cnt[0]--;
					cnt[1]++;
				} else {
					return -1;
				}
				break;
			case 'o':
				if(cnt[1] > 0) {
					cnt[1]--;
					cnt[2]++;
				} else {
					return -1;
				}
				break;
			case 'a':
				if (cnt[2] > 0) {
					cnt[2]--;
					cnt[3]++;
				} else {
					return -1;
				}
				break;
			case 'k':
				if (cnt[3] > 0) {
					cnt[3]--;
				} else {
					return -1;
				}
				break;
			}
			
			int temp = 0;
			for (int k = 0; k < 5; k++) {
				temp += cnt[k];
			}
			if(result < temp) result = temp;
		}
		for (int k = 0; k < 5; k++) {
			if(cnt[k] > 0) result = -1;
		}
		
		return result;
	}
}
