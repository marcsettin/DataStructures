import java.util.Scanner;

public class NQueens {
	private static int N;
	private static int [][] board;

	private static void place(int row, int col, int val) {
		for (int i = row+1, j = 1; i < N; i++, j++) {
			board[i][col] += val;

			if (col - j >= 0)
				board[i][col-j] += val;
			if (col + j < N)
				board[i][col+j] += val;
		}
	}
	
	private static int check_row(int row) {
		if (row >= N) return 1;
		
		int num = 0;
		for (int i = 0; i < N; i++) {
			if (board[row][i] == 0) {
				place (row, i, 1);
				num += check_row(row + 1);
				place (row, i, -1);
			}
		}
		return num;
	}

	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter the number of queens: ");
		N = kb.nextInt();
		board = new int[N][N];

		int num = check_row(0);
		System.out.println("The number of valid arrangements is " + num);
	}	
}
