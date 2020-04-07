package eg.edu.alexu.csd.datastructure.queue.csxx_csyy_cszz;


public class ArrayQueue implements IQueue, IArrayBased {
	int front;
	int rear;
	int size;
	int arrSize;
	Object arr[];
	public ArrayQueue (int n) {
		arr = new Object [n];
		front = -1;
		rear = -1;
		arrSize = n;
	}
	
	public void enqueue(Object item) {
		if (((rear+1)% arrSize) == front) {
			throw new RuntimeException("It's Full, Sir :(");	
		}
		else if (front == -1 && rear ==  -1) {
			arr[0] = item;
			front++;
			rear++;
			size++;
		}
		else {
			rear = (rear+1) % arrSize;
			arr[rear] = item;
			size++;
		}
	}
	
	public Object dequeue() {
		if (front == -1 && rear ==  -1) {
			throw new RuntimeException("It's Empty, Sir :(");
		}
		else if (front == rear && front != -1 && rear != -1) {
			Object temp = arr[front];
			front = -1;
			rear = -1;
			size--;
			return temp;
		}
		else {
			Object temp = arr[front];
			front = (front+1) % arrSize;
			size--;
			return temp;
		}
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void printQueue() {
		for (int i=0; i<size; i++) {
			System.out.println(arr[(front+i) % arrSize] + " ");
		}
	}

}	
