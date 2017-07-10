

public class Node<T> {
	private T element; 
	private Node<T> next; 
	private Node<T> prev;
	
	public Node() {
		next = prev = null;
		element = null;
	}
	
	public Node(T element) {
		next = prev = null;
		this.element = element;
	}
	
	public Node<T> getNext() {
		return next; 
	}
	
	public Node<T> getPrev() {
		return prev;
	}
	
	public void setNext(Node<T> node) {
		next = node;
	}
	
	public void setPrev(Node<T> node) {
		prev = node;
	}
	
	public void setElement(T element) {
		this.element = element;
	}
	
	public T getElement() {
		return element;
	}

}
