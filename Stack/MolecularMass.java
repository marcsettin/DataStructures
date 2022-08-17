import java.util.Scanner;

public class MolecularMass {
	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter the molecule: ");
		String input = kb.nextLine();
		
		IntStack S = new IntStack();

		for (int i = 0; i < input.length(); ++i) {
			int c = input.charAt(i);
			if (c == 'H')
				S.push(1);
			else if (c == 'C')
				S.push(12);
			else if (c == 'O')
				S.push(16);
			else if (c == '(')
				S.push(-2);
			else if (c >= '0' && c <= '9') {
				int num = (int) c - (int) '0';
				int t = S.pop();
				S.push(t * num);
			}
			else {
				int sum = 0;
				int t = S.pop();
				while (t != -2) {
					sum += t;
					t = S.pop();
				}
				S.push(sum);
			}
		}
		int sum = 0;
		int t = S.pop();
		while (t != -1) {
			sum += t;
			t = S.pop();
		}
		System.out.println("The Molecular Mass of " + input + " is " + sum);

	}
}
