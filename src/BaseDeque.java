/**
 * This program provides an implementation of the Deque interface
 * and demonstrates it.
 * 
 * @author (your name), Acuna
 * @version (version)
 */
import java.util.NoSuchElementException;
    
//TODO: implement.
public class BaseDeque<Item> implements Deque<Item> {
	private Node<Item> head, tail;
	private int count; 
	
	public BaseDeque() {
		head = tail = null;
		
		count = 0;
	}

	@Override
	public void enqueueFront(Item element) {
		// TODO Auto-generated method stub
		Node<Item> temp = new Node<>(element);
		
		if (isEmpty())
			head = tail = temp;
		else if (head == tail) {
			head.setNext(tail);
			tail = temp;
		}
		else {
			tail.setNext(temp);
			tail = temp;
		}
		
		count++;
	}

	@Override
	public void enqueueBack(Item element) {
		// TODO Auto-generated method stub
		Node<Item> temp = new Node<>(element);
		
		if (isEmpty())
			head = tail = temp;
		else if (head == tail) {
			head = temp;
			head.setNext(tail);
		}
		else {
			temp.setNext(head);
			head = temp;
		}
		
		count++;
	}

	@Override
	public Item dequeueFront() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if(isEmpty())
			throw new NoSuchElementException("The queue is empty.");
		else if (head == tail) {
			Node<Item> temp = tail;
			head = tail = null;
			
			count--; 
			
			return temp.getElement();
		} 
		else {
			Node<Item> temp = head;
			Node<Item> result = tail;
			
			while(temp.getNext() != tail) {
				temp = temp.getNext();
			}
			
			tail = temp;
			tail.setNext(null);
			
			
			count--;
			
			return result.getElement();
		}
	}

	@Override
	public Item dequeueBack() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if(isEmpty())
			throw new NoSuchElementException("The queue is empty.");
		else if(head == tail) {
			Node<Item> temp = head;
			head = tail = null;
			
			count--;
			
			return temp.getElement();
		}
		else {
			Node<Item> temp = head;
			
			head = head.getNext();
			
			count--;
			
			return temp.getElement();
		}
	}

	@Override
	public Item first() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if (isEmpty()) 
			throw new NoSuchElementException("The queue is empty."); 
		else
			return tail.getElement();
	}

	@Override
	public Item last() throws NoSuchElementException {
		// TODO Auto-generated method stub
		if(isEmpty())
			throw new NoSuchElementException("The queue is empty.");
		else
			return head.getElement();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return count == 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		if(isEmpty())
			return null;
		else {
			String result = "";
			Node<Item> temp = head; 
			while (temp != null) {
				result += temp.getElement() + " ";
				temp = temp.getNext();
			}
			
			return result;
		}
	}
	
    /**
     * Program entry point for deque. 
     * @param args command line arguments
     */    
    public static void main(String[] args) {
        BaseDeque<Integer> deque = new BaseDeque<>();

        //standard queue behavior
        deque.enqueueBack(3);
        deque.enqueueBack(7);
        deque.enqueueBack(4);
        deque.dequeueFront();        
        deque.enqueueBack(9);
        deque.enqueueBack(8);
        deque.dequeueFront();
        System.out.println("size: " + deque.size());
        System.out.println("contents:\n" + deque.toString());   

        //deque features
        System.out.println(deque.dequeueFront());        
        deque.enqueueFront(1);
        deque.enqueueFront(11);                         
        deque.enqueueFront(3);                 
        deque.enqueueFront(5);         
        System.out.println(deque.dequeueBack());
        System.out.println(deque.dequeueBack());        
        System.out.println(deque.last());                
        deque.dequeueFront();
        deque.dequeueFront();        
        System.out.println(deque.first());        
        System.out.println("size: " + deque.size());
        System.out.println("contents:\n" + deque.toString());  
        
        // My Tests
        BaseDeque<Integer> myQueue = new BaseDeque<>();
        
        // Exception Handling
        try {
        	myQueue.dequeueFront();
        }
        catch(NoSuchElementException e) {
        	System.out.println(e);
        }
        
        try {
        	myQueue.dequeueBack();
        }
        catch(NoSuchElementException e) {
        	System.out.println(e);
        }
        
        try {
        	myQueue.first();
        }
        catch(NoSuchElementException e) {
        	System.out.println(e);
        }
        
        try {
        	myQueue.last();
        }
        catch(NoSuchElementException e) {
        	System.out.println(e);
        }
        
        // Test DequeueBack (Size = 1)
        myQueue.enqueueFront(1);
        System.out.println(myQueue.dequeueBack());
        
        // Test DequeueFront (Size = 1)
        myQueue.enqueueFront(2);
        System.out.println(myQueue.dequeueFront());
        
     // Test DequeueBack (Size = 1)
        myQueue.enqueueBack(3);
        System.out.println(myQueue.dequeueBack());
        
        // Test DequeueFront (Size = 1)
        myQueue.enqueueBack(4);
        System.out.println(myQueue.dequeueFront());
    }
} 