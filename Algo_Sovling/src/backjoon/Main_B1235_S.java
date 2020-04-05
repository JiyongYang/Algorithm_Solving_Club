package backjoon;
import java.util.*;
import java.io.*;

public class Main_B1235_S {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] stNum = new String[N];
		for (int i = 0; i < N; i++) {
			stNum[i] = sc.next();
		}
		int len = stNum[0].length();
		HashSet<String> hs = new HashSet<>();
		for (int k = 1; k <= len; k++) {
			if(k == len) {
				System.out.println(k);
				return;
			}
			hs.clear();
			for (int i = 0; i < N; i++) {
				hs.add(stNum[i].substring(len-k));
			}
			if(hs.size() == N) {
				System.out.println(k);
				return;
			}
		}
	}
}
