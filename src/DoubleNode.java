

public class DoubleNode<T> {
	private T element; 
	private DoubleNode<T> next; 
	private DoubleNode<T> prev;
	
	public DoubleNode() {
		next = prev = null;
		element = null;
	}
	
	public DoubleNode(T element) {
		next = prev = null;
		this.element = element;
	}
	
	public DoubleNode<T> getNext() {
		return next; 
	}
	
	public DoubleNode<T> getPrev() {
		return prev;
	}
	
	public void setNext(DoubleNode<T> node) {
		next = node;
	}
	
	public void setPrev(DoubleNode<T> node) {
		prev = node;
	}
	
	public void setElement(T element) {
		this.element = element;
	}
	
	public T getElement() {
		return element;
	}

}
