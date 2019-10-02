public class IntStack {
	private int n;
	private int [] arr;
	private int top;

	public IntStack() {
		n = 1000000;
		arr = new int[n];
		top = 0;
	}

	public void push(int x) {
		arr[top++] = x;
	}

	public int pop() {
		if (top == 0)
			return -1;
		return arr[--top];
	}
}
