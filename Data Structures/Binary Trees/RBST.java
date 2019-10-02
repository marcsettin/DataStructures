import java.util.Random;

public class RBST {
	
	private Node head;
	private Random rand;
		
	public RBST() {
		head = null;
		rand = new Random();
	}
	public RBST(Node _head) {
		head = _head;
		rand = new Random();
	}

	public void print() {
		print(head);
		System.out.println();
	}
	private void print(Node T) {
		if (T == null) return;
		print(T.getLeft());
		System.out.print(T.getTeam() + " ");
		print(T.getRight());
	}

	public void insertNormal(int team, int rank) {
		head = insertNormal(head, team, rank);
	}
	private Node insertNormal(Node T, int team, int rank) {
		if (T == null)
			return new Node(team);

		assert (rank >= 1 && rank <= T.getSize() + 1) : "rank should be between 1 and size of the tree <" + (T.getSize()+1) + ">";

		int rankOfRoot = (T.getLeft() != null) ? T.getLeft().getSize() + 1 : 1;
		if (rank <= rankOfRoot)
			T.setLeft(insertNormal(T.getLeft(), team, rank));
		else
			T.setRight(insertNormal(T.getRight(), team, rank - rankOfRoot));
		T.incSize();
		return T;
	}
	
	public RBST[] split(int rank) {
		Node [] ret = split(head, rank);
		RBST [] RET = {null, null};
		RET[0] = new RBST(ret[0]);
		RET[1] = new RBST(ret[1]);
		return RET;
	}
	private Node[] split(Node T, int rank) {
		Node [] ret = {null, null};
		
		if (T == null) {
			return ret;
		}
		
		int rankOfRoot = (T.getLeft() == null) ? 1 : T.getLeft().getSize() + 1;
		if (rank == rankOfRoot) {
			ret[1] = T.getRight();
			ret[0] = T;
			ret[0].setRight(null);
			
			if (ret[0] != null) ret[0].updateSize();
			if (ret[1] != null) ret[1].updateSize();
			return ret;
		}
		else if (rank < rankOfRoot) {
			ret = split(T.getLeft(), rank);
			
			Node temp = ret[1];
			ret[1] = T;
			ret[1].setLeft(temp);
			ret[1].updateSize();
		}
		else {
			ret = split(T.getRight(), rank - rankOfRoot);
			
			Node temp = ret[0];
			ret[0] = T;
			ret[0].setRight(temp);
			ret[0].updateSize();
		}
		return ret;
	}
	
	public void insert(int team, int rank) {
		head = insert(head, team, rank);
	}
	private Node insert(Node T, int team, int rank) {
		if (T == null)
			return new Node(team);
		
		assert (rank >= 1 && rank <= T.getSize() + 1) : "rank should be between 1 and size of the tree <" + (T.getSize()+1) + ">";

		double prob = rand.nextDouble();
		int rankOfRoot = (T.getLeft() == null) ? 1 : T.getLeft().getSize() + 1;
		
		if (prob <= 1.0 / (T.getSize()+1)) {
			Node [] S = split(T, rank-1);	
			T = new Node(team, S[0], S[1]);	
			return T;
		}
		else if (rank <= rankOfRoot)
			T.setLeft(insert(T.getLeft(), team, rank));
		else
			T.setRight(insert(T.getRight(), team, rank - rankOfRoot));
		T.incSize();
		return T;
	}

	public Node select(int rank) {
		return select(head, rank);
	}
	private Node select(Node T, int rank) {
		if (T == null) return null;
		
		assert (rank >= 1 && rank <= T.getSize()) : "rank should be between 1 and size of the tree <" + T.getSize() + "> ";
		
		int rankOfRoot = (T.getLeft() == null) ? 1 : T.getLeft().getSize() + 1;
		if (rank == rankOfRoot) {
			return T;
		}
		if (rank < rankOfRoot) {
			return select(T.getLeft(), rank);
		}
		return select(T.getRight(), rank - rankOfRoot);
	}

	public int getSize() {
		if (head == null) return 0;
		return head.getSize();
	}
}
