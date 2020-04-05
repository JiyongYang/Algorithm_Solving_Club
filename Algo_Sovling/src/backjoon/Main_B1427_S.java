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

public class Main_B1427_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;

	public static void main(String[] args) throws IOException {
		String s = br.readLine();
		ArrayList<Integer> num = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			num.add(s.charAt(i)-'0');
		}
		Collections.sort(num);
		Collections.reverse(num);
		
		for (int i = 0; i < num.size(); i++) {
			bw.write(num.get(i)+"");
		}
		
		br.close();
		bw.close();
	}

}
