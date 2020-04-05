package test.algorithm;
import java.util.Scanner;

class FloydWarshallMain
{
	
	static final int INFINITY = 999999;
	static int[][] weight = new int[101][101];
	static int[][] result = new int[101][101];

	public static void floyd(int n) 
	{
		for (int k = 0; k < n; k++) 
		{
			for (int i = 0; i < n; i++) 
			{
				if (k == 0) 
				{
					for (int j = 0; j < n; j++) 
					{
						result[i][j] = weight[i][j];
					}
				}
				for (int j = 0; j < n; j++) 
				{
					if (result[i][k] + result[k][j] < result[i][j])
					{
						result[i][j] = result[i][k] + result[k][j];
					}
				}
			}
		}
	}

	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			
			for (int i = 0; i < n; i++) 
			{
				for (int j = 0; j < n; j++) 
				{
					weight[i][j] = INFINITY;
				}
				weight[i][i] = 0;
			}

			for (int i = 0; i < m; i++) 
			{
				int st = sc.nextInt();
				int en = sc.nextInt();
				int w = sc.nextInt();
				if (weight[st-1][en-1] > w)
				{
					weight[st-1][en-1] = w;
				}
			}
			
			floyd(n);

			System.out.printf("#%d\n", test_case);
			for (int i = 0; i < n; i++) 
			{
				for (int j = 0; j < n; j++) 
				{
					System.out.printf("%d ", result[i][j]);
				}
				System.out.printf("\n");
			}

		}
		sc.close();
	}
}