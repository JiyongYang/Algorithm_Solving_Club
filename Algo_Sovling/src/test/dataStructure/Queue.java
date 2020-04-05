package test.dataStructure;
import java.util.Scanner;

class Queue {

	static final int MAX_N = 100;

	static int front;
	static int rear;
	static int queue[] = new int[MAX_N];

	static void queueInit()
	{
		front = 0;
		rear = 0;
	}

	static boolean queueIsEmpty()
	{
		return (front == rear);
	}

	static boolean queueIsFull()
	{
		if ((front + 1) % MAX_N == rear)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	static boolean queueEnqueue(int value)
	{
		if (queueIsFull())
		{
			System.out.print("queue is full!");
			return false;
		}
		queue[front] = value;
		front++;
		if (front >= MAX_N)
		{
			front = MAX_N;
		}

		return true;
	}

	static Integer queueDequeue()
	{
		if (queueIsEmpty()) 
		{
			System.out.print("queue is empty!");
			return null;
		}
		
		Integer value = new Integer(queue[rear]);

		rear++;
		if (rear >= MAX_N)
		{
			rear = MAX_N;
		}
		return value;
	}

	public static void main(String arg[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();

			queueInit();
			for (int i = 0; i < N; i++)
			{
				int value = sc.nextInt();
				queueEnqueue(value);
			}

			System.out.print("#" + test_case + " ");
			
			while (!queueIsEmpty())
			{
				Integer value = queueDequeue();
				if (value != null)
				{
					System.out.print(value.intValue() + " ");
				}
			}
			System.out.println();
		}
		sc.close();
	}
}