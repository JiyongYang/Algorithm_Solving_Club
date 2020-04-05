package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Chicken{
	int x;
	int y;
	public Chicken(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main_B15686_S {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int[][] map;
	static int minDist = 9999999;
	static int M;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		List<Chicken> cList = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==2) cList.add(new Chicken(j, i));
			}
		}
		boolean[] check = new boolean[cList.size()];
		
		perm_2(check, 0, cList);
		System.out.println(minDist);
	}
	
	public static void perm_2(boolean[] check, int pos, List<Chicken> cList) {
		if(pos == check.length) {
			int cnt = 0;
			for (int i = 0; i < check.length; i++) {
				if(check[i] == true) cnt++;
			}
			if(cnt == M) {
				List<Chicken> tList = new ArrayList<>();
				for (int i = 0; i < check.length; i++) {
					if(check[i] == true) {
						Chicken tC = cList.get(i);
						tList.add(new Chicken(tC.x, tC.y));
					}
				}
				int result = calMinDist(map, tList);
				if(minDist > result) minDist = result;
			}
			return;
		}
		
		check[pos] = true;
		perm_2(check, pos+1, cList);
		check[pos] = false;
		perm_2(check, pos+1, cList);
	}
	
	public static int calMinDist(int[][] map, List<Chicken> cList) {
		int sum = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				if(map[i][j] == 1) {
					int minDist = 999999;
					for (int k = 0; k < cList.size(); k++) {
						int dist = Math.abs(i - cList.get(k).y) + Math.abs(j - cList.get(k).x);
						if(dist < minDist) minDist = dist;
					}
					sum += minDist;
				}
			}
		}
		return sum;
	}
}
