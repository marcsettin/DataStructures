import java.lang.Integer;

public class Prog {

	public static void main(String [] args) {
		
		if (args.length != 2) {
			System.out.println("Please execute: java Prog <n> <p>");
			System.out.println("n is the input size, and p is the program number.");
			System.exit(0);
		}

		int n = Integer.parseInt(args[0]);
		int p = Integer.parseInt(args[1]);

		switch(p) {
			case 1: prog1(n);
							break;
			case 2: prog2(n);
							break;
			case 3: prog3(n);
							break;
			case 4: prog4(n);
							break;
			default: System.out.println("Invalid program number. Only 1-4.");
		}
	}

	private static void prog1(int n) {
		for (int i = 0; i < n * n; i += n)
			System.out.println(i);
	}

	private static void prog2(int n) {
		for (int i = 0; i < n; ++i)
			System.out.println(i);
	}

	private static void prog3(int n) {
		HashFunctions H = new HashFunctions(n);

		int i0 = H.hash3(0);
		int p = 128189;
		
		int index [] = new int[p];
		int top = 0;
		index[top++] = 0;
		for (int i = 1; i < p && i < n * n; ++i) {
			int ind = H.hash3(i);
			if (ind == i0) {
				index[top++] = i;
			}
		}
		
		int k = 0;
		int mul = p;
		int num = 0;
		while (k * mul + index[0] < n * n && num < n) {
			for (int i = 0; i < top && k * mul + index[i] < n * n && num < n; ++i, ++num) {
				System.out.println(k * mul + index[i]);
			}
			++k;
		}
	}

	private static void prog4(int n) {
		Node [] array = new Node[n];
		int [] counts = new int[n];
		HashFunctions H = new HashFunctions(n);

		boolean status = false;
		int n_index = 0;
		for (int i = 0; i < n * n && !status; ++i) {
			int ind = 	H.hash4(i);
			counts[ind]++;
			array[ind] = new Node(i, array[ind]);
			if (counts[ind] == n) {
				status = true;
				n_index = ind;
			}
		}
		if (!status) 
			System.out.println("Cannot find n keys that all hash. Something wrong.");
		else {
			for (Node cur = array[n_index]; cur != null; cur = cur.next)
				System.out.println(cur.key);
		}
	}
}
