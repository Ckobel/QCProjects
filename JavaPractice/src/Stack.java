
public class Stack<T> {

	private int size;
	private T[] stackArray;
	private int top;

	@SuppressWarnings("unchecked")
	public Stack(int sz) {
		size = sz;
		// hack to create array of generics
		stackArray = (T[]) new Object[size];
		top = -1;
	}

	public T top() {
		if (top == -1) {
			return null;
		}
		return stackArray[top];
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public T pop() {
		if (top == -1) {
			return null;
		}
		return stackArray[top--];
	}
	
	public void push(T t){
		stackArray[++top] = t;
	}
	
	public int size(){
		return (top + 1);
	}
}
