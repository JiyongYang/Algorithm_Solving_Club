package swea;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution_S2112_S {
	static int[][] temp = null;
	static int[][] film = null;
	static int minCnt = 0;
	static int D = 0, W = 0, K = 0;
	static boolean greedy = false;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			minCnt = D;
			greedy = false;

			film = new int[D][W];
			temp = new int[D][W];

			for (int y = 0; y < D; y++) {
				for (int x = 0; x < W; x++) {
					film[y][x] = sc.nextInt();
				}
			}
			
			if(check(film)) {
				minCnt = 0;
			} else {
				for (int i = 1; i <= K; i++) {
					ArrayList<Integer> arr = new ArrayList<>();
					if(greedy) break;
					boolean[] cnt = new boolean[D+1];
					dfs1(arr, i, cnt, 0);
				}
			}
			System.out.println("#" + t + " " + minCnt);
		}
	}

	public static void dfs1(ArrayList<Integer> arr, int size, boolean[] check, int s) {
		if(greedy) return;
		if (arr.size() == size) {
			ArrayList<Integer> list = new ArrayList<>();
			dfs(list, size, arr);
			return;
		}
		
		for (int i = s; i < D; i++) {
			if(check[i]) continue;
			
			check[i] = true;
			arr.add(i);
			dfs1(arr, size, check, i);
			if(greedy) return;
			check[i] = false;
			arr.remove(arr.size() - 1);
		}
	}

	public static void dfs(ArrayList<Integer> list, int size, ArrayList<Integer> arr) {
		if(greedy) return;
		if (list.size() == size) {
			for (int i = 0; i < film.length; i++) {
				temp[i] = film[i].clone();
			}
			
			int cnt = arr.size();
			for (int i = 0; i < arr.size(); i++) {
				int pos = arr.get(i);
				for (int of = 0; of < temp[i].length; of++) {
					int flg = list.get(i);
					if(flg == 0) { temp[pos][of] = 0; } 
					else { temp[pos][of] = 1; }
				}
			}

			if (check(temp)) {
				if (minCnt > cnt) {
					minCnt = cnt;
					greedy = true;
				}
			}
			
			return;
		}

		for (int i = 0; i < 2; i++) {
			list.add(i);
			dfs(list, size, arr);
			if(greedy) return;
			list.remove(list.size() - 1);
		}
	}

	public static boolean check(int[][] film) {
		boolean[] innerChecker = new boolean[W];
		for (int x = 0; x < W; x++) {
			for (int y = 0; y <= D - K; y++) {
				boolean tempCheck = true;
				for (int i = 1; i < K; i++) {
					if (film[y][x] == film[y + i][x])
						continue;
					tempCheck = false;
				}
				if (tempCheck) {
					innerChecker[x] = true;
					break;
				}
			}
			if(!innerChecker[x]) return false;
		}
		return true;
	}
}