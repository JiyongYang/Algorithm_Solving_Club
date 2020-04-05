package swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_S3074_S {
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			String in = br.readLine();
			long N = Long.parseLong(in.split(" ")[0]);
			long M = Long.parseLong(in.split(" ")[1]);
			
			long[] time = new long[(int)N];
			
			for (int i = 0; i < N; i++) {
				time[i] = Long.parseLong(br.readLine());
			}
			
			System.out.println("#"+t+" "+getMinTime(time, N, M));
			
		}
	}
	
	public static long getMinTime(long[] times, long lane, long people) {
		long left = 1, right = 100000000000000L;
		long mid;
		
		while(left <= right) {
			mid = (left+right) / 2L;
			long temp = 0;
			
			for (int i = 0; i < lane; i++) {
				temp += mid/times[i];
			}
			
			if(temp >= people) {
				right = mid - 1;
			}
			else {
				left = mid + 1;
			}
		}
		
		return left;
	}
}



/*public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			String in = br.readLine();
			int N = Integer.parseInt(in.split(" ")[0]);
			int M = Integer.parseInt(in.split(" ")[1]);
			
			int[] time = new int[N];
			
			for (int i = 0; i < N; i++) {
				time[i] = Integer.parseInt(br.readLine());
			}
			
//			long start = System.currentTimeMillis();

			Arrays.sort(time);
			long lcm = lcmMulti(time);
			int peopleSum = 0;
			for (int i = 0; i < time.length; i++) {
				peopleSum += lcm/time[i];
			}
//			long end = System.currentTimeMillis();
//			System.out.println( "--1] 실행 시간 : " + ( end - start )/1000.0 + "초");
			
			long resultChunk = M/peopleSum;
			long resultTime = lcm*resultChunk;
			int restPeople = M%peopleSum;
			
//			System.out.println(String.format("PS: %d, LCM: %d, ResultChunk: %d, ResultTime: %d, RestPeoople: %d", peopleSum, lcm, resultChunk, 
//					resultTime, restPeople));
//			start = System.currentTimeMillis();
			System.out.println("#"+t+" "+(resultTime+cal2(time, N, restPeople)));
//			end = System.currentTimeMillis();
//			System.out.println( "--2] 실행 시간 : " + ( end - start )/1000.0 + "초");

			
		}
	}
	
	private static long gcd(long a, long b) {
		long temp = 0;
		if(b > a) {
			temp = a;
			a = b;
			b = temp;
		}
		while(b > 0) {
			temp = b;
			b = a%b;
			a = temp;
		}
		return a;
	}
	
	private static long lcm(long a, long b) {
		long _gcd = gcd(a, b);
		return  (a * b) / _gcd;
	}
	
	private static long lcmMulti(int[] arr) {
		long curLCM = 1;
		for (int i : arr) {
			curLCM = lcm(i, curLCM);
		}
		return curLCM;
	}
	
	private static void swap(int[] arr, int i, int loc) {
		int temp = arr[i];
		arr[i] = arr[loc];
		arr[loc] = temp;
	}

	public static int cal2(int[] time, int simsa, int people) {
		int[] holding = new int[time.length];
		int pos = 0;
		for (int i = 0; i < people; i++) {
			// 입력
			holding[pos] += time[pos];
//			System.out.println(Arrays.toString(holding));
			// 정렬
			for (int j = 0; j < holding.length-1; j++) {
				if(holding[j]+time[j] < holding[j+1]+time[j+1]) {
					break;
				}
				
				if(holding[j]+time[j] > holding[j+1]+time[j+1]) {
					swap(holding, j, j+1);
					swap(time, j, j+1);
				}
			}
//			System.out.println(Arrays.toString(holding));
		}
		
		int maxTime = -1;
		for (int i = 0; i < holding.length; i++) {
			if(maxTime < holding[i]) {
				maxTime = holding[i];
			}
		}
		return maxTime;
	}
}*/