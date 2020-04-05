package test.algorithm;

import java.util.Scanner;

class BipartiteMatchMain
{
	static final int MAX = 1000;
	
	static int countA;
	static int countB;
	static int[] matchA = new int[MAX];
	static int[] matchB = new int[MAX];
	static int[][] adj = new int[MAX][MAX];
	static boolean[] visited = new boolean[MAX];
	
	static boolean dfs(int a)
	{
		int b;

		if (visited[a])
		{
			return false;
		}

		visited[a] = true;

		for (b = 0; b < countB; ++b)
		{
			if (adj[a][b] != 0 && (matchB[b] == -1 || dfs(matchB[b])))
			{
				matchA[a] = b;
				matchB[b] = a;
				return true;
			}
		}

		return false;
	}

	static int bipartiteMatch()
	{
		int size = 0;
		for (int start = 0; start < countA; ++start)
		{
			for (int i = 0; i < countA; i++)
			{
				visited[i] = false;
			}
			if (dfs(start))
			{
				size++;
			}
		}
		return size;
	}

	static void initialize() 
	{
		for (int i = 0; i < countA; i++)
		{
			matchA[i] = -1;
			for (int j = 0; j < countB; j++)
			{
				adj[i][j] = 0;
			}
		}

		for (int i = 0; i < countB; i++)
		{
			matchB[i] = -1;
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++)
		{
			countA = sc.nextInt();
			countB = sc.nextInt();
			initialize();
			int adjCount = sc.nextInt();
			
			for (int i = 0; i < adjCount; i++)
			{
				int a = sc.nextInt();
				int b = sc.nextInt();
				adj[a-1][b-1] = 1;
			}
			System.out.printf("#%d %d\n", test_case, bipartiteMatch());
		}
		sc.close();
	}
}