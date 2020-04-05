package swea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_S5644_S {
	static class Point{
		int x;
		int y;
		int dist;
		Point(Point pt, int dist){
			this.x = pt.x;
			this.y = pt.y;
			this.dist = dist;
		}
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
		Point(int x, int y, int dist){
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		@Override
		public String toString() {
			return "(" + x + ", " + y + ")";
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
		
		
	}
	
	static class BC{
		int id;
		Point pt;
		int c;
		int p;
		BC(int id, Point pt, int c, int p){
			this.id = id;
			this.pt = pt;
			this.c = c;
			this.p = p;
		}
		@Override
		public String toString() {
			return "BC [" + pt + ", c=" + c + ", p=" + p + "]";
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static StringTokenizer st2 = null;
	static final int dx[] = {0, 0, 1, 0, -1};
	static final int dy[] = {0, -1, 0, 1, 0};
	static int M = 0;
	static int A = 0;
	static int result = 0;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			
			int[] moveA = new int[M];
			int[] moveB = new int[M];
			
			st = new StringTokenizer(br.readLine());
			st2 = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				moveA[i] = Integer.parseInt(st.nextToken());
				moveB[i] = Integer.parseInt(st2.nextToken());
			}
			
			BC[] bc = new BC[A];
			
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				bc[i] = new BC(0, new Point(Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken())),
						Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()));
			}
			
			HashMap<Point, ArrayList<BC>> hm = createMap(bc);
			result = 0;
			run(moveA, moveB, hm);
			bw.write("#"+t+" "+result+"\n");
			bw.flush();
		}
		
		br.close();
		bw.close();
	}
	
	
	public static void checker(HashMap<Point, ArrayList<BC>> hm, Point ptA, Point ptB) {
		BC[] idxA = null;
		BC[] idxB = null;
		if(hm.containsKey(ptA)) {
			ArrayList<BC> listA = hm.get(ptA);
			idxA = new BC[listA.size()];
			for (int i = 0; i < listA.size(); i++) {
				idxA[i] = listA.get(i);
			}
		}
		if(hm.containsKey(ptB)) {
			ArrayList<BC> listB = hm.get(ptB);
			idxB = new BC[listB.size()];
			for (int i = 0; i < listB.size(); i++) {
				idxB[i] = listB.get(i);
			}
		}
		if(idxA != null && idxB != null) {
			// 두 개 다 어느 지점에 있는 경우
			int tempSum = 0;
			for (int i = 0; i < idxB.length; i++) {
				for (int j = 0; j < idxA.length; j++) {
					BC bcB = idxB[i];
					BC bcA = idxA[j];
					int ttSum = 0;
					if(bcB.id == bcA.id) ttSum += bcB.p;
					else ttSum += bcB.p + bcA.p;
					if(ttSum > tempSum) tempSum = ttSum;
				}
			}
			result += tempSum;
			
		} else if(idxA == null && idxB != null) {
			// B 사람만 충전 범위에 들어와 있는 경우
			int maxBP = 0;
			for (int i = 0; i < idxB.length; i++) {
				if(maxBP <= idxB[i].p) maxBP = idxB[i].p;
			}
			result += maxBP;
			
		} else if(idxA != null && idxB == null) {
			// A 사람만 충전 범위에 들어와 있는 경우
			int maxAP = 0;
			for (int i = 0; i < idxA.length; i++) {
				if(maxAP <= idxA[i].p) maxAP = idxA[i].p;
			}
			result += maxAP;
		} else {
			// 둘 다 안들어와 있는 경우
		}
	}
	
	public static void run(int[] moveA, int[] moveB, HashMap<Point, ArrayList<BC>> hm) {
		// 처음 위치 확인
		Point ptA = new Point(1,1);
		Point ptB = new Point(10,10);
		
		checker(hm, ptA, ptB);
		
		// 이동 경로 확인
		for (int k = 0; k < M; k++) {
			ptA.x += dx[moveA[k]];
			ptA.y += dy[moveA[k]];
			ptB.x += dx[moveB[k]];
			ptB.y += dy[moveB[k]];
			
			checker(hm, ptA, ptB);
		}
	}
	
	public static HashMap<Point, ArrayList<BC>> createMap(BC[] bc) {
		HashMap<Point, ArrayList<BC>> hm = new HashMap<>();
		
		for (int i = 0; i < bc.length; i++) {
			Queue<Point> q = new LinkedList<>();
			boolean[][] check = new boolean[11][11];
			int maxProcess = bc[i].c;
			
			Point pt = new Point(bc[i].pt, 0);
			if(hm.containsKey(pt)) {
				hm.get(pt).add(new BC(i+1, pt, 0, bc[i].p));
			}
			else {
				ArrayList<BC> fList = new ArrayList<>();
				fList.add(new BC(i+1, pt, 0, bc[i].p));
				hm.put(pt, fList);
			}
			check[pt.y][pt.x] = true;
			q.add(pt);
			while(!q.isEmpty()) {
				Point qPt = q.poll();
				int dist = qPt.dist;
				if(dist >= maxProcess) continue;
				for (int k = 1; k <= 4; k++) {
					int ny = qPt.y + dy[k];
					int nx = qPt.x + dx[k];
					if(ny>=1 && ny<=10 && nx>=1 && nx<=10) {
						if(check[ny][nx]) continue;
						
						check[ny][nx] = true;
						Point ptTemp = new Point(nx, ny, dist+1);
						if(hm.containsKey(ptTemp)) {
							hm.get(ptTemp).add(new BC(i+1, ptTemp, dist+1, bc[i].p));
						}
						else {
							ArrayList<BC> tList = new ArrayList<>();
							tList.add(new BC(i+1, ptTemp, dist+1, bc[i].p));
							hm.put(ptTemp, tList);
						}
						q.add(ptTemp);
					}
				}
			}
			q.clear();
		}
		return hm;
	}
}
