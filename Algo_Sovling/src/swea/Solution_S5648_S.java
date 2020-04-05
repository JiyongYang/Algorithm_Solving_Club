package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_S5648_S {
	static class Atom{
		int x;
		int y;
		int dir;
		int e;
		public Atom(int x, int y, int dir, int e) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.e = e;
		}
	}
	static class Point{
		int y;
		int x;
		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
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
			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "Pt [" + y + ", " + x + "]";
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int[][] map = null;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static ArrayList<Atom> list = null;
	static HashMap<Point, ArrayList<Atom>> hm = new HashMap<>();
	static int totalEnergy = 0;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = (Integer.parseInt(st.nextToken())+1000)*2;
				int y = (Integer.parseInt(st.nextToken())+1000)*2;
				int dir = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				list.add(new Atom(x, y, dir, e));
			}
			totalEnergy = 0;
			run(list);
			bw.write("#"+t+" "+totalEnergy+"\n");
		}
		
		bw.close();
		br.close();
	}
	
	public static void run(ArrayList<Atom> list) throws IOException {
		while(!list.isEmpty()) {
			for (Atom atom : list) {
				int ny = atom.y + dy[atom.dir];
				int nx = atom.x + dx[atom.dir];
				if(ny > 4000 || ny < 0 || nx > 4000 || nx < 0) continue;
				Point temp = new Point(ny, nx);
				atom.y = ny;
				atom.x = nx;
				if(hm.containsKey(temp)) hm.get(temp).add(atom);
				else {
					ArrayList<Atom> tl = new ArrayList<>();
					tl.add(atom);
					hm.put(temp, tl);
				}
			}
			list.clear();
			Set<Point> keys = hm.keySet();
			for (Point k : keys) {
				if(hm.get(k).size() >= 2) {
					for (int i = 0; i < hm.get(k).size(); i++) {
						totalEnergy += hm.get(k).get(i).e;
					}
				} else {
					list.add(hm.get(k).get(0));
				}
			}
			hm.clear();
		}
	}
}
