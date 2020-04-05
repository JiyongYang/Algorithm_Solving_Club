package swea;
import java.util.*;
import java.io.*;

public class Solution_S7701_S {
	static class Word implements Comparable<Word>{
		String word;
		int len;
		public Word(String word, int len) {
			this.word = word;
			this.len = len;
		}
		
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + len;
			result = prime * result + ((word == null) ? 0 : word.hashCode());
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
			Word other = (Word) obj;
			if (len != other.len)
				return false;
			if (word == null) {
				if (other.word != null)
					return false;
			} else if (!word.equals(other.word))
				return false;
			return true;
		}

		@Override
		public int compareTo(Word o) {
			return len == o.len? word.compareTo(o.word) : len - o.len;
		}


		@Override
		public String toString() {
			return "Word [word=" + word + "]";
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int t = 1; t <= T; t++) {
			HashSet<Word> hs = new HashSet<>();
			int N = sc.nextInt();
			
			for (int i = 0; i < N; i++) {
				String temp = sc.next();
				hs.add(new Word(temp, temp.length()));
			}
			
			ArrayList<Word> list = new ArrayList<>();
			for (Word w : hs) {
				list.add(w);
			}
			Collections.sort(list);
			
			System.out.println("#"+t);
			for (Word word : list) {
				System.out.println(word.word);
			}
		}
	}
}
