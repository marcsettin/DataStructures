import java.util.Scanner;

public class Collatz {
	private static int N;
	private static int [] table;

	public static int collatzLength(long x) {
		if (x < 1) return 0;
		int ind = (int)x;
		if (x < N && table[ind] != 0) return table[ind];

		int len = ((x % 2 == 0) ? collatzLength(x/2) : collatzLength(3*x + 1)) + 1;
		if (x < N)
			table[ind] = len;
		return len;
	}
	
	public static void main(String [] args) {
		N = 100000000;
		table = new int[N];
		table[1] = 1;

		Scanner kb = new Scanner(System.in);
		System.out.print("Enter the range: ");
		int a = kb.nextInt();
		int b = kb.nextInt();

		int max = collatzLength(a);
		int num = a;
		for (int i = a+1; i <= b; i++) {
			int len = collatzLength(i);
			if (len > max) {
				max = len;
				num = i;
			}
		}
		System.out.println("The number with the maximum Collatz length in the range: " + num);
		System.out.println("Its Collatz length: " + max);
	}
}
