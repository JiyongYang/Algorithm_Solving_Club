package test.algorithm;

import java.util.Scanner;

class Queue 
{
	int[] queue;
	int front;
	int rear;
	public Queue(int capacity)
	{
		queue = new int[capacity];
		front = rear = 0;
	}
	
	boolean has_item()
	{
		return rear > front;
	}
	
	int dequeue()
	{
		front++;
		return queue[front-1];
	}
	
	void enqueue(int item)
	{
		queue[rear++] = item;
	}
}

class Stack 
{
	int[] stack_set;
	int last;
	public Stack(int capacity)
	{
		stack_set = new int[capacity];
		last = 0;
	}
	
	boolean has_item()
	{
		return last > 0;
	}
	
	int peek()
	{
		return stack_set[last-1];
	}
	
	int pop()
	{
		return stack_set[--last];
	}
	
	void mark_duplicate(int item)
	{
		for (int i = 0; i < last; i++)
		{
			if (stack_set[i] == item)
			{
				stack_set[i] = TopologicalSort.DUPLICATE;
			}
		}
	}
	
	void push(int item)
	{
		mark_duplicate(item);
		stack_set[last++] = item;
	}
}

class Node
{
	int item;
	Node prev;
	
	public Node(int item)
	{
		this.item = item;
	}
	
	void reset()
	{
		prev = null;
	}
	
	void push(Node other)
	{
		if (prev == null)
		{
			prev = other;
			return;
		}
		Node head = this;
		while (head.prev != null)
		{
			head = head.prev;
		}
		head.prev = other;
	}
}


class TopologicalSort
{
	static final int MAX_N = 25;
	static final int MAX_M = 25;
	
	static final int CONNECTED = 1;
	static final int NOT_CONNECTED = 0;
	static final int NOT_UPDATED_YET = 0;
	static final int NOT_VISITED = -1;
	static final int DUPLICATE = -2;
	
	static int[][] map = new int[MAX_N][MAX_N];
	static int[] count = new int[MAX_N];
	static Node[] nodes = new Node[MAX_N];
	static Stack stack;
	static Queue queue;
	
	static void reset()
	{
		for (int i = 0; i < MAX_N; i++) 
		{
			for (int j = 0; j < MAX_N; j++) 
			{
				map[i][j] = 0;
			}
		}
		
		for (int i = 0; i < MAX_N; i++)
		{
			count[i] = 0;
		}
		
		stack = new Stack(MAX_N);
		queue = new Queue(MAX_N);
		
		for (int i = 0; i < MAX_N; i++)
		{
			nodes[i].reset();
		}
	}
	
	static boolean connected(final int src, final int dest)
	{
		return map[src][dest] == CONNECTED;
	}
	

	static void traverse(final int idx)
	{
		stack.push(nodes[idx].item);
		Node cur = nodes[idx].prev;
		while (cur != null) 
		{
			traverse(cur.item);
			cur = cur.prev;
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 0; i < MAX_N; i++)
		{
			nodes[i] = new Node(i);
		}
		
		for (int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int dest = sc.nextInt();
			reset();
			for (int i = 0; i < m; i++)
			{
				int from = sc.nextInt();
				int to = sc.nextInt();
				map[from-1][to-1] = CONNECTED;
				count[to-1]++;
			}
			for (int i = 0; i < n; i++)
			{
				if (count[i] == 0)
				{
					queue.enqueue(i);
				}
			}
			while (queue.has_item())
			{
				int src = queue.dequeue();
				for (int i = 0; i < n; i++){
					if (connected(src, i))
					{
						Node node = new Node(src);
						nodes[i].push(node);
						count[i]--;
						if (count[i] == 0)
						{
							queue.enqueue(i);
						}
					}
				}
			}
			System.out.printf("#%d ", test_case);
			if (nodes[dest-1].prev == null)
			{
				System.out.printf("Not reached");
			} else
			{
				traverse(dest - 1);
				while (stack.has_item())
				{
					int item = stack.pop();
					if (item == DUPLICATE)
					{
						continue;
					}
					System.out.printf("%d ", item + 1);
				}				
			}
			System.out.printf("\n");
		}
		sc.close();
	}
}