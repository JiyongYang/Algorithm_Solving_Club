package test.nhn_190929;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_Q3 {
	static class Follower{
		ArrayList<Integer> list = new ArrayList<>();
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		Follower[] p = new Follower[n];
		for (int i = 0; i < p.length; i++) {
			p[i] = new Follower();
		}
		int[] sweet = new int[n];
		
		String[] command = br.readLine().split(" ");
		int turn = 0;
		for (int s = 0; s < command.length; s++) {
			if(command[s].equals("Q")) {
				for (int i = 0; i < sweet.length; i++) {
					sweet[i]++;
				}
			} else if(command[s].equals("K")) {
				int to = Integer.parseInt(command[++s]);
				p[turn].list.add(to);
				
				
			} else if(command[s].equals("J")) {
				sweet[(turn+1)%n]++;
				if(turn-1 >= 0) sweet[(turn-1)%n]++;
				else sweet[n-1]++;
				// follower
				boolean[][] check = new boolean[n][n];
				followerAdd(turn, sweet, p, check);
			} else {
				sweet[turn]++;
				// follower
				boolean[][] check = new boolean[n][n];
				followerAdd(turn, sweet, p, check);
			}
			
			System.out.println(turn+" "+command[s]+" "+Arrays.toString(sweet));
			turn = (turn+1)%n;
		}
		for (int i = 0; i < sweet.length; i++) {
			bw.write(sweet[i]+" ");
		}
		
		bw.close();
		br.close();
	}
	
	public static void followerAdd(int turn, int[] sweet, Follower[] p, boolean[][] check) {
		if(p[turn].list.size() == 0) return;
		for (int i = 0; i < p[turn].list.size(); i++) {
			int to = p[turn].list.get(i);
			if(!check[turn][to]) {
				sweet[to]++;
				check[turn][to] = true;
				followerAdd(to, sweet, p, check);
			}
		}
	}
}
