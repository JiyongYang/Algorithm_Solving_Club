package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_B2999_S {
	static class Num implements Comparable<Num>{
		int r;
		int c;
		public Num(int r, int c) {
			this.r = r;
			this.c = c;
		}
		@Override
		public String toString() {
			return "Num [r=" + r + ", c=" + c + "]";
		}
		@Override
		public int compareTo(Num o) {
			return o.r-r;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	public static void main(String[] args) throws IOException {
		String s = br.readLine();
		int N = s.length();
		
		ArrayList<Num> list = new ArrayList<>();
		for (int i = 1; i < N/2; i++) {
			if(N%i==0) {
				if(i <= N/i) list.add(new Num(i, N/i));
			}
		}
		Collections.sort(list);
		int h = list.get(0).r;
		int w = list.get(0).c;
		char[][] rsa = new char[h][w];
		int offset = 0;
		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) {
				rsa[y][x] = s.charAt(offset++);
			}
		}
		
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				bw.write(rsa[y][x]+"");
			}
		}
		
		br.close();
		bw.close();
	}
}
