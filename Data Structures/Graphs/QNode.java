/**
	This class encapsulates a single node in the binary heap.
	The key is the dist field, and the word field is an associated 'value'.
**/
public class QNode {
	private int dist; 		// This is what the priority queue will be keyed on.
	private String word;	// Stores the word along with its distance from the start state (or word) during breadth-first-search.

	/**
		Constructor: Initializes a QNode.
	**/
	public QNode(int _dist, String _word) {
		dist = _dist;
		word = _word;
	}

	/**
		Copy Constructor: This performs a deep copy.
	**/
	public QNode(QNode p) {
		dist = p.dist;
		word = p.word;
	}

	// Several get and set methods follow.
	
	public int getDist() {
		return dist;
	}

	public void setDist(int _dist) {
		dist = _dist;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String _word) {
		word = _word;
	}

	public int compareTo(QNode p) {
		return dist - p.dist;
	}
}
