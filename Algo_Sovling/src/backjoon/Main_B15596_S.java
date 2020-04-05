package backjoon;

public class Main_B15596_S {
	public static long sum(int[] a) {
		long sum = 0L;
		for (int i = 0; i < a.length; i++) {
			sum+=a[i];
		}
		return sum;
	}
}
