

public class Node<T> {
	private T element; 
	private Node<T> next; 
	
	public Node() {
		next = null;
		element = null;
	}
	
	public Node(T element) {
		next = null;
		this.element = element;
	}
	
	public Node<T> getNext() {
		return next; 
	}
	
	public void setNext(Node<T> node) {
		next = node;
	}
	
	public void setElement(T element) {
		this.element = element;
	}
	
	public T getElement() {
		return element;
	}

}
