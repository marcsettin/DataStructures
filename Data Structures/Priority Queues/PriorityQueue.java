
public class PriorityQueue {
	private Interval [] heap; // An array that encodes a max-heap data structure.
	private int size;	// The size of allocated buffer for the heap.
	private int numElements;	// The number of elements currently stored. 

	/**
		Constructor: s is the initial size of the heap.
	*/
	public PriorityQueue(int s) {
		size = s;
		heap = new Interval[size + 1];	// 1 extra element allows us to use 1-based indexing. The max heap stores intervals keyed on their lengths.
		numElements = 1;
	}

	/**
		Inserts a new Interval k into the heap. Automatically expands the heap if the buffer allocated is full.
	*/
	public void insert(Interval k) {
		if (numElements == size) {
			Interval [] newheap = new Interval[2 * size + 2];
			for (int i = 1; i <= size; ++i)
				newheap[i] = heap[i];
			heap = newheap;
			size *= 2;
		}
		heap[numElements] = k;
		siftup(numElements);
		numElements++;
	}

	/**
		Returns the maximum Interval from the heap (usually the one with the largest length. See the compareTo function of Interval for more details on the comparison.
	*/
	public Interval remove_max() {
		if (numElements == 1) return null;
		Interval ret = heap[1];
		swap(1, --numElements);
		siftdown(1);
		return ret;
	}

	/**
		Performs a siftup on the element at position i in the heap.
	*/
	private void siftup(int i) {
		int p = parent(i);
		while (i > 1 && heap[i].compareTo(heap[p]) > 0) {
			swap(i, p);
			i = p;
			p = parent(i);
		}
	}

	/**
		Performs a siftdown on the element at position i in the heap.
	*/
	private void siftdown(int i) {
		int l = left(i);
		int r = right(i);
		int minindex = (l < numElements && r < numElements && heap[r].compareTo(heap[l]) > 0) ? r : ((l < numElements) ? l : numElements);

		while (minindex < numElements && heap[i].compareTo(heap[minindex]) < 0) {
			swap(i, minindex);
			i = minindex;

			l = left(i);
			r = right(i);
			minindex = (l < numElements && r < numElements && heap[r].compareTo(heap[l]) > 0) ? r : ((l < numElements) ? l : numElements);
		}
	}

	/**
		Swaps the elements in positions i and j within the heap.
		Assumes that both i and j are valid indices in the heap, that is, they are between 1 and numElements.
	*/
	private void swap(int i, int j) {
		Interval temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}

	/**
		Returns the index of the parent element of i within the heap. Returns 0 if i is the root.
		Assumes that i is a valid index in the heap, that is, between 1 and numElements. 
 	*/
	private int parent(int i) {
		return i / 2;
	}

	/**
		Returns the index of the left child element of i within the heap.
		Assumes that i is a valid index in the heap, that is, between 1 and numElements. 
		Does not check if the left child is out of bounds of the active heap elements.
	*/
	private int left(int i) {
		return 2 * i;
	}

	/**
		Returns the index of the right child element of i within the heap.
		Assumes that i is a valid index in the heap, that is, between 1 and numElements.
		Does not check if the right child is out of bounds of the active heap elements.
	*/
	private int right(int i) {
		return 2 * i + 1;
	}

	/**
		This function prints the contents of the array that encodes a heap.
	*/
	public void print() {
		System.out.println("Printing heap:");
		for (int i = 1; i < numElements; ++i)
			System.out.println(heap[i]);
	}
}
