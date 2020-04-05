package jungol;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main_J1733_S {
	static class Pos implements Comparable<Pos>{
		int y;
		int x;
		
		public Pos(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

		@Override
		public int compareTo(Pos o) {
			return x==o.x? y-o.y: x- o.x;
		}
		
	}
	
	static int[][] map = null;
	static int gy = 0;
	static int gx = 0;
	static ArrayList<Pos> list = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[19][19];
		
		for (int y = 0; y < 19; y++) {
			for (int x = 0; x < 19; x++) {
				map[y][x] = sc.nextInt();
			}
		}
		int result = run();
		System.out.println(result);
		if(result != 0) {
			System.out.println(gy+" "+gx);
//			System.out.println(list);
			
		}
		
	}
	
	public static int run() {
		int result = 0;
		for (int y = 0; y < 19; y++) {
			for (int x = 0; x < 19; x++) {
				if(map[y][x] == 0) continue;
				result = check(map[y][x], y, x, list);
				if(result != 0) {
					Collections.sort(list);
					gy = list.get(0).y+1;
					gx = list.get(0).x+1;
					return result;
				}
			}
		}
		return result;
	}
	
	static int[] dx = {1, 0, -1, 1};
	static int[] dy = {0, 1, 1, 1};
	
	public static int check(int base, int y, int x, ArrayList<Pos> list) {
		int result = 0;
		boolean flg = true;
		for (int k = 0; k < 4; k++) {
			flg = true;
			list.clear();
			list.add(new Pos(y, x));
			for (int os = 1; os < 5; os++) {
				int ny = y+dy[k]*os;
				int nx = x+dx[k]*os;
				if(ny < 19 && ny >= 0 && nx < 19 && nx >= 0 && base == map[ny][nx]) {
					list.add(new Pos(ny, nx));
					continue;
				}
				flg = false;
				break;
			}
			if(flg) {
//				System.out.println(y+" "+x+" ::"+base);
				// 양방향 확인
				int ny1 = y+dy[k]*5;
				int nx1 = x+dx[k]*5;
				int ny2 = y+dy[k]*(-1);
				int nx2 = x+dx[k]*(-1);
				boolean flg2 = false;
				if(ny1 >= 19 || ny1 < 0 || nx1 >= 19 || nx1 < 0) {
					if(map[ny2][nx2] != base) {
						result = base;
						break;
					}
				}
				if(ny2 >= 19 || ny2 < 0 || nx2 >= 19 || nx2 < 0) {
					if(map[ny1][nx1] != base) {
						result = base;
						break;
					}
				}
				if(ny1 >= 19 || ny1 < 0 || nx1 >= 19 || nx1 < 0 || 
				   ny2 >= 19 || ny2 < 0 || nx2 >= 19 || nx2 < 0) break;
				
				if(map[ny1][nx1] != base && map[ny2][nx2] != base) {
					result = base;
					break;
				}
			}
		}
		
		return result;
	}
}
