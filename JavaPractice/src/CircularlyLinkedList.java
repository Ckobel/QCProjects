public class CircularlyLinkedList<T> {
	private Node<T> start;

	public CircularlyLinkedList() {
		start = null;
	}

	public boolean isEmpty() {
		return start == null;
	}

	public void add(T data) {
		Node<T> n = new Node<T>(data);
		if (isEmpty()) {
			start = n;
			start.next = start;
		} else {
			start.next = new Node<T>(data, start.next);
		}
	}

		
	public int size() {
		if(isEmpty()){return 0;}
		// fancy size method using 2 nodes iterating at different "speeds" to
		// determine length of list.
		// eliminates need for keeping track of "start" and "end" of list
		// could probably be done similarly using a sentinel
		Node<T> byone = start;
		Node<T> bytwo = start;

		int sz = 0;
		do {
			byone = byone.next;
			bytwo = bytwo.next.next;
			sz++;
		} while (byone != bytwo);
		return sz;
	}

	public class Node<T> {
		private Node<T> next;
		private T data;

		public Node(T data) {
			next = null;
			this.data = data;
		}

		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}

		public T getData() {
			return data;
		}

		public void setNext(Node<T> next) {
			this.next = next;
		}

		public Node<T> getNext() {
			return next;
		}

	}
}
