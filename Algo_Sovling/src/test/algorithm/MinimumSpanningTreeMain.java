package test.algorithm;
import java.util.Scanner;

class MinimumSpanningTreeMain
{
	static int V;
	static int[][] graph = new int[100][100];


	static int minKey(int[] key, int[] mstSet)
	{
		int min = 2147483647;
		int min_index = -1;

		for (int v = 0; v < V; v++)
		{
			if (mstSet[v] == 0 && key[v] < min) 
			{
				min = key[v];
				min_index = v;
			}
		}

		return min_index;
	}

	static void printMST(int[] parent)
	{
		int weightSum = 0;
		for (int i = 1; i < V; i++)
		{
			weightSum += graph[i][parent[i]];
		}
		System.out.printf("%d\n", weightSum);
	}

	static void primMST()
	{
		 int[] parent = new int[100];
		 int[] key = new int[100];
		 int[] mstSet = new int[100];

		 for (int i = 0; i < V; i++) 
		 {
			key[i] = 2147483647;
			mstSet[i] = 0;
		 }

		 key[0] = 0;
		 parent[0] = -1;

		for (int count = 0; count < V-1; count++)
		{
			int u = minKey(key, mstSet);
			mstSet[u] = 1;
			for (int v = 0; v < V; v++)
			{
				if (graph[u][v] != 0 && mstSet[v] == 0 && graph[u][v] <  key[v])
				{
					parent[v] = u;
					key[v] = graph[u][v];
				}
			}
		}

		 printMST(parent);
	}
	
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++)
		{
			V = sc.nextInt();
			for (int i = 0; i < V; i++) 
			{
				for (int j = 0; j < V; j++) 
				{
					graph[i][j] = sc.nextInt();
				}
			}
			System.out.printf("#%d ", test_case);
			primMST();
		}
		sc.close();
	}
}