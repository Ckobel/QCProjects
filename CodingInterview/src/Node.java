
public class Node {
	private int data;
	private Node next;
	
	public Node(int data, Node next){
		if(next == null){
			new Node(data);
		}
		this.data = data;
		this.next = next;
	}
	
	public Node(int data){
		this.data = data;
	}
	
}
