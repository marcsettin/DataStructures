import java.util.Scanner;

public class Jugs {
	private static int A;
	private static int B;
	private static int C;
	private static int N;

	private static boolean [][] visited;
	private static int [][] prevA;
	private static int [][] prevB;
	private static int finalA;
	private static int finalB;
	private static String [][] operation;

	private static boolean visit(int a, int b, int preva, int prevb, String op) {
		if (a < 0 || a > A || b < 0 || b > B) return false;
		if (visited[a][b]) return false;
		
		visited[a][b] = true;
		prevA[a][b] = preva;
		prevB[a][b] = prevb;
		operation[a][b] = op;

		if (a + b == C) {
			finalA = a;
			finalB = b;
			return true;
		}	
		boolean ret = visit(A, b, a, b, "Fill Jug 1");
		ret |= visit(a, B, a, b, "Fill Jug 2");
		ret |= visit(0, b, a, b, "Empty Jug 1");
		ret |= visit(a, 0, a, b, "Empty Jug 2");
		int x = (a < B-b) ? a : B-b;
		ret |= visit(a-x, b+x, a, b, "Pour Jug 1 -> Jug 2");
		x = (b < A-a) ? b : A-a;
		ret |= visit(a+x, b-x, a, b, "Pour Jug 2 -> Jug 1");
		return ret;
	}

	private static void printSol(int a, int b) {
		if (a == 0 && b == 0) return;
		printSol(prevA[a][b], prevB[a][b]);
		System.out.println(operation[a][b] + " [a = " + a + ", b = " + b + "]");
	}
	
	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter A: ");
		A = kb.nextInt();
		System.out.print("Enter B: ");
		B = kb.nextInt();
		System.out.print("Enter C: ");
		C = kb.nextInt();

		N = 1002;
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				visited[i][j] = false;
		prevA = new int[N][N];
		prevB = new int[N][N];
		operation = new String[N][N];

		boolean possible = visit(0, 0, -1, -1, "");
		if (possible) {
			System.out.println("Yay! Found a solution.");
			printSol(finalA, finalB);
		}
		else
			System.out.println("Impossible!");

	}
}
