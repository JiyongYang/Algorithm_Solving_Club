package backjoon;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_B17143_S {
	static class Point {
		int r;
		int c;
		Point(int r, int c){
			this.r = r;
			this.c = c;
		}
		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + c;
			result = prime * result + r;
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
			if (c != other.c)
				return false;
			if (r != other.r)
				return false;
			return true;
		}
	}
	
	static class SharkPos{
		char id;
		int r;
		int c;
		int s;
		int d;
		int z;
		SharkPos(){
			
		}
		@Override
		public String toString() {
			String str ="";
			if(d == 1) str="U";
			else if(d == 2) str="D";
			else if(d == 3) str="R";
			else if(d == 4) str="L";
			else str = d+"";
			return String.format(" <%c>(r %d, c %d) s:%d d:%s z:%d", id, r, c, s, str, z);
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static ArrayList<SharkPos> spList = new ArrayList<>();
	static int R;
	static int C;
	static int M;
	static int sumOfSize = 0;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken()); // 크기 R
		C = Integer.parseInt(st.nextToken()); // 크기 C
		M = Integer.parseInt(st.nextToken()); // 상어 수 M
		
		char id = 'A';
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			SharkPos tSP = new SharkPos();
			tSP.id = id++;
			tSP.r = Integer.parseInt(st.nextToken());
			tSP.c = Integer.parseInt(st.nextToken());
			tSP.s = Integer.parseInt(st.nextToken());
			tSP.d = Integer.parseInt(st.nextToken());
			tSP.z = Integer.parseInt(st.nextToken());
			spList.add(tSP);
		}
		fishingKing();
		
		bw.write(sumOfSize+"\n");
		
		br.close();
		bw.close();
	}
	
	public static void fishingKing() {
		for (int pos = 1; pos <= C; pos++) {
//			System.out.println("FISHING POS: "+pos);
			// 순차 진행
			int minPos = 500;
			int minShark = 500;
			
			// 낚시왕의 특정 위치에서 가장 까가운 상어 위치 구하기
			for (int i = 0; i < spList.size(); i++) {
				if(spList.get(i).c == pos) {
					if(minPos > spList.get(i).r) {
						minPos = spList.get(i).r;
						minShark = i;
					}
				}
			}
			
			if(minShark == 500) {
				updateSharkPos();
				continue;
			}
			// 먹힌 상어 정보
			
			sumOfSize += spList.get(minShark).z;
//			System.out.println("[E]"+spList.get(minShark) + " total: "+sumOfSize);
			
			spList.remove(minShark);
			updateSharkPos();
		}
	}
	// 0 r(row) |, 1 c(column) ㅡ, 2 s(speed), 3 d(dir), 4 z(size)
	// 1 up, 2 down, 3 right, 4 left
	public static void updateSharkPos() {
		HashMap<Point, SharkPos> counter = new HashMap<>();
		for (int i = 0; i < spList.size(); i++) {
			SharkPos sp = spList.get(i);
			
			int nr = sp.r;
			int nc = sp.c;
			int speed = sp.s;
			int adjust_offset = 0;
			int offset = 0;
			int mok = 0;
			int rest = 0;
			switch(sp.d) {
			case 1:
				// up
				if(nr-speed >= 1) {
					nr = nr-speed;
					break;
				}
				offset = R-1;
				adjust_offset = nr-1;
				speed -= adjust_offset;
				mok = speed/offset;
				rest = speed%offset;
				if(mok%2==0) {
					nr = 1 + rest;
					sp.d = 2;
				}
				else {
					nr = R - rest;
				}
				
				break;
			case 2:
				// down
				if(nr+speed <= R) {
					nr = nr+speed;
					break;
				}
				offset = R-1;
				adjust_offset = R-nr;
				speed -= adjust_offset;
				mok = speed/offset;
				rest = speed%offset;
				if(mok%2==0) {
					nr = R - rest;
					sp.d = 1;
				}
				else {
					nr = 1 + rest;
				}
				break;
			case 3:
				// right
				if(nc+speed <= C) {
					nc = nc+speed;
					break;
				}
				offset = C-1;
				adjust_offset = C-nc;
				speed -= adjust_offset;
				mok = speed/offset;
				rest = speed%offset;
				if(mok%2==0) {
					nc = C - rest;
					sp.d = 4;
				}
				else {
					nc = 1 + rest;
				}
				break;
			case 4:
				// left
				if(nc-speed >= 1) {
					nc = nc-speed;
					break;
				}
				// 1번 위치로 조정
				offset = C-1;
				adjust_offset = nc-1;
				speed -= adjust_offset;
				mok = speed/offset;
				rest = speed%offset;
				if(mok%2==0) {
					nc = 1 + rest;
					sp.d = 3;
				}
				else {
					nc = C - rest;
				}
				break;
			}
			sp.r = nr;
			sp.c = nc;
			
//			System.out.println("[U]"+sp);
			// 중복 체크
			
			Point pointKey = new Point(nr, nc);
			if(!counter.containsKey(pointKey)) {
				counter.put(pointKey, sp);
			}
			else {
				SharkPos tsp = counter.get(pointKey);
				if(tsp.z < sp.z) {
					counter.put(pointKey, sp);
//					System.out.println("--[R]"+tsp);
				}
				else {
					counter.put(pointKey, tsp);
//					System.out.println("--[R]"+sp);
				}
			}
//			System.out.println(counter.keySet().toString());
		} // end for
		// remove sequence
		
		spList.clear();
		Set<Point> set = counter.keySet();
		for (Point ppt : set) {
			spList.add(counter.get(ppt));
		}
	}
}
