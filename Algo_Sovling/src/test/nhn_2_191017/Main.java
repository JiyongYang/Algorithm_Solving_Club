package test.nhn_2_191017;
import java.lang.*;
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 배의 크기
		int sizeOfShip = 0;
		
		// 강을 건너야 하는 그룹의 총 숫자
		int numOfCrossGroup = 0;
		
		numOfCrossGroup = sc.nextInt();
		for (int i = 0; i < numOfCrossGroup; i++) {
			int q = 1 << i;
			System.out.print(q + " ] \t\t");
			String s = Integer.toBinaryString(q);
			for (int j = 0; j < 10-s.length(); j++) {
				System.out.print("0");
			}
			System.out.println(s);
		}
		
		/*// 강을 건너야 하는 그룹 정보를 담는 해쉬맵
		HashMap<String, Integer> CrossGroup = new HashMap<>();
		
		// 배를 몰 수 있는 그룹의 총 숫자
		int numOfCapableGroup = 0;
		// 배를 몰 수 있는 그룹 정보를 담는 해쉬맵
		HashMap<String, Integer> CapableGroup = new HashMap<>();

		// 강둑에 남겨지는 안되는 조합의 개수
		int numOfNoResterSet = 0;
		String[][] NoResterSet = new String[numOfNoResterSet][];
		for (int i = 0; i < numOfNoResterSet; i++) {
			
		}
		
		// 배에 함께 타면 안되는 조합
		int numOfNoShipSet = 0;
		
		
		sizeOfShip = sc.nextInt();
		numOfCrossGroup = sc.nextInt();
		int offset = 0;
		for (int i = 0; i < numOfCrossGroup; i++) {
			CrossGroup.put(sc.next(), offset++);
		}
		numOfCapableGroup = sc.nextInt();
		offset = 0;
		for (int i = 0; i < numOfCapableGroup; i++) {
			CapableGroup.put(sc.next(), offset++);
		}*/
		
	}
}
