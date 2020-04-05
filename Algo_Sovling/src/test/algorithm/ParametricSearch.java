package test.algorithm;

import java.util.Scanner;

class ParametricSearch {

	static int K;
	static int N;
	static int low, high, mid, numRibbonTape, max;
	static int sizeRibbonTape[];

	static void search()
	{
		mid = low + (high - low) / 2;
		numRibbonTape = 0;

		for (int i = 0; i < K ; i++) 
		{
			numRibbonTape += (sizeRibbonTape[i] / mid);
		}

		if (numRibbonTape >= N)
		{
			low = mid + 1;
			if (max < mid)
				max = mid;
		}
		else
		{
			high = mid - 1;
		}
	}

	public static void main(String arg[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) 
		{
			low = 1;
			high = 0 ;
			max = -1;

			K = sc.nextInt();
			N = sc.nextInt();

			sizeRibbonTape = new int[K];
			for (int i = 0; i < K; i++)
			{
				sizeRibbonTape[i] = sc.nextInt();
				if ( high < sizeRibbonTape[i] )
				{
					high = sizeRibbonTape[i] ;
				}
			}

			while (low <= high)
			{
				search();
			}
			System.out.println("#" + test_case + " " + max);
		}
		
		sc.close();
	}
}