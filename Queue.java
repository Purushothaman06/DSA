/*
 * Queue Implementation using LinkedList
 *
 * Enqueue - O(1)
 * Dequeue - O(1)
 * IsEmpty - O(1)
 * Peek - O(1)
 *
 */
public class Queue<T> {
    Node front, rear;

    class Node {
        T data;
        Node next;

        /**
         * @param val
         * 
         */
        Node(T val) {
            data = val;
            next = null;
        }
    }

    Queue() {
        front = null;
        rear = null;
    }
    
    /**
     * @param val
     * 
     */
    public void enqueue(T val) {
        Node newNode = new Node(val);
        if(front == null) 
            front = newNode;
        else 
            rear.next = newNode;   
        rear = newNode;
    }

    /**
     * @return the removed element from the queue
     * 
     */
    public T dequeue() {
        if(front == null)
            throw new IndexOutOfBoundsException("Queue is Empty");
        T temp = front.data;
        front = front.next; 
        if(front == null)
            rear = null;
        return temp;
    }

    /**
     * @return true if queue is empty
     * @return false if queue is not empty
     * 
     */
    public boolean isEmpty() {
        return front == null;
    }

    /**
     * @return data from the front of the queue
     * 
     */
    public T peek() {
        if(front == null)
            throw new IndexOutOfBoundsException("Queue is Empty");
        return front.data;
    }

    /**
     * @return size of the queue
     * 
     */
    public int size() {
        int size = 0;
        Node temp = front;
        while(temp != null)
            size++;
        return size;
    }
}
