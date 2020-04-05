package test.dataStructure;
import java.util.Scanner;

class Stack {
	static final int MAX_N = 100;
	static int top;
	static int stack[] = new int[MAX_N];

	static void stackInit()
	{
		top = 0;
	}

	static boolean stackIsEmpty()
	{
		return (top == 0);
	}

	static boolean stackIsFull()
	{
		return (top == MAX_N);
	}

	static boolean stackPush(int value)
	{
		if (stackIsFull())
		{
			System.out.println("stack overflow!");
			return false;
		}
		stack[top] = value;
		top++;

		return true;
	}

	static Integer stackPop()
	{
		if (top == 0) 
		{
			System.out.println("stack is empty!");
			return null;
		}

		top--;		
		Integer value = new Integer(stack[top]);

		return value;
	}

	public static void main(String arg[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();

			stackInit();
			for (int i = 0; i < N; i++) 
			{
				int value = sc.nextInt();
				stackPush(value);
			}

			System.out.print("#" + test_case + " ");

			while (!stackIsEmpty())
			{
				Integer value = stackPop();
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