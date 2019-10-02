/**
	This class implements a circular array.
	It expands if the queue becomes full.
**/
public class Queue {
	private QNode [] queue;	// Array that stores the queue elements.
	private int front;				// Index pointing to the front of the queue.
	private int end;					// Index pointing to the element that is one less than the end of the queue.
	private int numElements;	// The number of elements currently stored in the queue.
	private int size;					// The capacity of the allocated array. If the number of elements reaches this capacity, we need to expand.

	/**
		Constructor: Allocates a queue with inital size of 1000.
	**/
	public Queue() {
		numElements = 0;
		size = 1000;
		front = size - 1;
		end = size - 1;
		queue = new QNode[size];
	}
	
	/**
		This function enqueues a new element p into the queue. 
		This also expands the array if it is full.
	**/
	public void enqueue(QNode p) {
		if (numElements == size) {
			// Expand the array, by first creating another one with twice the size and copying the contents of the old array.

			QNode [] queueOld = queue;
			size *= 2;
			queue = new QNode[size];
			copyArray(queueOld);
			front = (numElements - 1 + size) % size;
			end = (size - 1 + size) % size;
		}
		queue[end] = new QNode(p);
		end = (end - 1 + size) % size;	
		++numElements;
	}

	/**
		This funciton removes and returns the end front element in the queue.
	**/
	public QNode dequeue() {
		if (numElements == 0) {
			return null;
		}
		QNode ret = queue[front];
		front = (front - 1 + size) % size;
		--numElements;
		return ret;
	}

	/**
		This funciton returns true if the queue is empty, otherwise returns false.
	**/
	public boolean isEmpty() {
		if (numElements == 0) 
			return true;
		return false;
	}

	/**
		This function prints the contents of the queue.
	**/
	public void print() {
		for (int i = 0; i < numElements; ++i) {
			int ind = (front - i + size) % size;
			if (queue[ind]!= null)
				System.out.println(queue[ind]);
		}
	}

	/**
		This function copies the contents of the array passed in, into the queue.
		This is usually called when expanding the array size.
	**/
	private void copyArray(QNode [] array) {
		// Do we need to do a deep copy?
		int oldsize = array.length;
		for (int i = 0; i < numElements; ++i) {
			int newfrontind = (oldsize - i - 1);
			int oldfrontind = (front - i + oldsize) % oldsize;
			queue[newfrontind] = new QNode (array[oldfrontind]);
		}
	}
}
