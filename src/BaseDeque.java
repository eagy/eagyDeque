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
	private DoubleNode<Item> head, tail;
	private int count; 
	
	public BaseDeque() {
		head = tail = null;
		
		count = 0;
	}

	@Override
	public void enqueueFront(Item element) {
		// TODO Auto-generated method stub
		DoubleNode<Item> temp = new DoubleNode<>(element);
		
		if (isEmpty())
			head = tail = temp;
		else if (head == tail) {
			head.setNext(tail);
			tail = temp;
			tail.setPrev(head);
		}
		else {
			tail.setNext(temp);
			temp.setPrev(tail);
			tail = temp;
			
		}
		
		count++;
	}

	@Override
	public void enqueueBack(Item element) {
		// TODO Auto-generated method stub
		DoubleNode<Item> temp = new DoubleNode<>(element);
		
		if (isEmpty())
			head = tail = temp;
		else if (head == tail) {
			head.setPrev(temp);
			head = temp;
			head.setNext(tail);
		}
		else {
			temp.setNext(head);
			head.setPrev(temp);
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
			DoubleNode<Item> temp = tail;
			head = tail = null;
			
			count--; 
			
			return temp.getElement();
		} 
		else {
			DoubleNode<Item> result = tail;
			
			tail = tail.getPrev();
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
			DoubleNode<Item> temp = head;
			head = tail = null;
			
			count--;
			
			return temp.getElement();
		}
		else {
			DoubleNode<Item> temp = head;
			
			head = head.getNext();
			head.setPrev(null);
			
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
			DoubleNode<Item> temp = head; 
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
        	System.out.println("Test Case 1:\tdequeue front empty queue");
        	System.out.println("Expected:\tNoSuchElementException");
        	System.out.print("Actual Result:\t");
        	myQueue.dequeueFront();
        }
        catch(NoSuchElementException e) {
        	System.out.println(e);
        }
        
        try {
        	System.out.println("Test Case 2:\tdequeue back empty queue");
        	System.out.println("Expected:\tNoSuchElementException");
        	System.out.print("Actual Result:\t");
        	myQueue.dequeueBack();
        }
        catch(NoSuchElementException e) {
        	System.out.println(e);
        }
        
        try {
        	System.out.println("Test Case 3:\tget first element empty queue");
        	System.out.println("Expected:\tNoSuchElementException");
        	System.out.print("Actual Result:\t");
        	myQueue.first();
        }
        catch(NoSuchElementException e) {
        	System.out.println(e);
        }
        
        try {
        	System.out.println("Test Case 4:\tget last element empty queue");
        	System.out.println("Expected:\tNoSuchElementException");
        	System.out.print("Actual Result:\t");
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