import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class WordLadder {
	private static String start;
	private static String end;
	private static StringMap T;			// This map stores the dictionary of words.
	private static StringMap R;			// This map keeps track of all the words that are visited during breadth-first-search.
																	// The key field is the word that is visited, and its value field can hold the predecessor pointer.
	private static Queue Q;	// A queue to perform the breadth-first-search.

	private static boolean processNeighbors(QNode x) {

		int dist = x.getDist();
		String word = x.getWord();

		for (int i = 0; i < word.length(); ++i) {
			StringBuffer temp = new StringBuffer(word);
			for (char z = 'a'; z <= 'z'; ++z) {
				temp.setCharAt(i, z);
				String temp2 = temp.toString();
				if (temp2.equals(end)) {
					R.insert(end, word);
					return true;
				}
				if (R.find(temp2) == null && T.find(temp2) != null) {
					Q.enqueue(new QNode(dist + 1, temp2));
					R.insert(temp2, word);
				}
			}
		}
		return false;
	}

	private static void printPath(String word) {
		if (word.equals("")) return;
		StringNode x = R.find(word);
		printPath(x.getValue());
		System.out.println(word);
	}

	public static void main(String [] args) throws IOException {
		T = new StringMap();
		File file = new File("dictionary4");
		Scanner f = new Scanner(file);
		while (f.hasNext()) {
			String word = f.nextLine();
			T.insert(word, "");
		}
		f.close();

		Scanner kb = new Scanner(System.in);
		System.out.print("Enter the start word: ");
		start = kb.nextLine();
		System.out.print("Enter the end word: ");
		end = kb.nextLine();

		Q = new Queue();
		Q.enqueue(new QNode(0, start));
		R = new StringMap();
		R.insert(start, "");

		boolean found = false;
		if (start.equals(end))
			found = true;

		while (!Q.isEmpty() && !found) {
			QNode x = Q.dequeue();
			if (processNeighbors(x)) 
				found = true;
		}

		if (found) {
			System.out.println("Yay! A word ladder is possible.");
			printPath(end);
		}
		else {
			System.out.println("Duh! Impossible.");
		}
	}
}
