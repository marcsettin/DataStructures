
public class Node {

	private int team;
	private int size;
	private Node left;
	private Node right;

	public Node(int _team) {
		team = _team;
		size = 1;
		left = null;
		right = null;
	}
	public Node(int _team, Node _left, Node _right) {
		team = _team;
		left = _left;
		right = _right;
		size = (left == null ? 0 : left.getSize()) + (right == null ? 0 : right.getSize()) + 1;
	}

	public int getTeam() {
		return team;
	}
	public int getSize() {
		return size;
	}
	public Node getLeft() {
		return left;
	}
	public Node getRight() {
		return right;
	}

	public void setTeam(int _team) {
		team = _team;
	}
	public void setSize(int _size) {
		size = _size;
	}
	public void setLeft(Node _left) {
		left = _left;
	}
	public void setRight(Node _right) {
		right = _right;
	}

	public void incSize() {
		size++;
	}
	public void updateSize() {
		size = ((left == null) ? 0 : left.size) + ((right == null) ? 0 : right.size) + 1;
	}
}
