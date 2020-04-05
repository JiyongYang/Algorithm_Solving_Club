package swea;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_S2383_S {
	static class Stair{
		int id;
		int y;
		int x;
		int time;
		int[] queue;
		public Stair(int y, int x, int time) {
			this.y = y;
			this.x = x;
			this.time = time;
			this.id = stairId++;
			this.queue = new int[3];
		}
	}
	static class Person{
		int y;
		int x;
		int id;
		public Person(int y, int x) {
			this.y = y;
			this.x = x;
			this.id = personId++;
		}
	}
	static class Dist implements Comparable<Dist>{
		int sid;
		int pid;
		int dist;
		public Dist(int sid, int pid, int dist) {
			this.sid = sid;
			this.pid = pid;
			this.dist = dist;
		}
		@Override
		public int compareTo(Dist o) {
			return dist-o.dist;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st = null;
	static int N = 0;
	static int stairId = 0, personId = 0;
	static ArrayList<Person> plst = null;
	static ArrayList<Stair> slst = null;
	static int minVal = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			stairId = 0;
			personId = 0;
			minVal = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			plst = new ArrayList<>();
			slst = new ArrayList<>();
			for (int y = 0; y < N; y++) {
				st = new StringTokenizer(br.readLine());
				for (int x = 0; x < N; x++) {
					int val = Integer.parseInt(st.nextToken());
					if(val == 1) plst.add(new Person(y, x));
					if(val > 1) {
						slst.add(new Stair(y, x, val));
					}
				}
			}
			
			ArrayList<Integer> arr = new ArrayList<>();
			perm(arr);
			
			bw.write("#"+t+" "+minVal+"\n");
		}
		
		br.close();
		bw.close();
	}
	
	public static int distance(Stair s, Person p) {
		return Math.abs(s.y - p.y) + Math.abs(s.x - p.x)+1;
	}
	
	public static void run(ArrayList<Integer> arr) {
		PriorityQueue<Dist>[] distList = new PriorityQueue[2];
		for (int i = 0; i<2; i++) {
			distList[i] = new PriorityQueue<>();
		}
		for (int i = 0; i < arr.size(); i++) {
			Stair s = slst.get(arr.get(i));
			Person p = plst.get(i);
			distList[s.id].add(new Dist(s.id, p.id, distance(s, p)));
		}
		
		boolean[] check = new boolean[plst.size()+1];
		
		// 현재 계단의 '대기시간(초기 3명은 0) + 계단 소모 시간 (고정) + 이동 거리(고정)'값을 기준으로 선택
		while(true) {
			Dist p0 = null;
			Dist p1 = null;
			
			if(!distList[0].isEmpty()) {
				p0 = distList[0].poll();
			}
			if(!distList[1].isEmpty()) {
				p1 = distList[1].poll();
			}
			
			// 0번째 계단과 1번째 계단에서 가장 대기열이 짧게 남은 사람
			int minS0 = Integer.MAX_VALUE;
			int minS0Pos = 0;
			int minS1 = Integer.MAX_VALUE;
			int minS1Pos = 0;
			for (int i = 0; i < 3; i++) {
				if(minS0 > slst.get(0).queue[i]) {
					minS0 = slst.get(0).queue[i];
					minS0Pos = i;
				}
				if(minS1 > slst.get(1).queue[i]) {
					minS1 = slst.get(1).queue[i];
					minS1Pos = i;
				}
			}
			
			int s0Time = 0;
			int s1Time = 0;
			if(p0!=null) {
				if(minS0 == 0) s0Time = p0.dist + minS0 + slst.get(0).time;
				else {
					if(minS0 >= p0.dist) s0Time = minS0 + slst.get(0).time;
					else s0Time = p0.dist + slst.get(0).time;
				}
				slst.get(0).queue[minS0Pos] = s0Time;
			}
			if(p1!=null) {
				if(minS1 == 0) s1Time = p1.dist + minS1 + slst.get(1).time;
				else {
					if(minS1 >= p1.dist) s1Time = minS1 + slst.get(1).time;
					else s1Time = p1.dist + slst.get(1).time;
				}
				slst.get(1).queue[minS1Pos] = s1Time;
			}
			if(distList[0].isEmpty() && distList[1].isEmpty()) {
				// 모든 값을 다 할당한 경우
				break;
			}
		}
		
		int maxVal = 0;
		for (int i = 0; i < 2; i++) {
			for (int k = 0; k < 3; k++) {
				if(maxVal < slst.get(i).queue[k]) maxVal = slst.get(i).queue[k];
			}
		}
		if(maxVal < minVal) minVal = maxVal;
		slst.get(0).queue = new int[3];
		slst.get(1).queue = new int[3];
	}
	
	public static void perm(ArrayList<Integer> arr) {
		if(arr.size()==plst.size()) {
			run(arr);
			return;
		}
		for (int i = 0; i < 2; i++) {
			arr.add(i);
			perm(arr);
			arr.remove(arr.size()-1);
		}
	}
}
