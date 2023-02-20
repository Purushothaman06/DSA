/*
 * Queue Implementation using Arrays
 * by using two pointers approach
 * 
 * Enqueue - O(1)
 * Dequeue - O(1)
 * IsEmpty - O(1)
 * Peek - O(1)
 *
 */
public class QueueArray<T> {
     
    static final int MAX_SIZE = 30;
    T arr[];
    int front, rear;
     
    @SuppressWarnings("unchecked")
    QueueArray() {
        arr = (T[]) new Object[MAX_SIZE];
        front = -1;
        rear = -1;
    }
     
    /**
     * @param item
     * 
     */
    public void enqueue(T item) {   
        if(rear == MAX_SIZE-1)
            throw new IndexOutOfBoundsException("Queue is Full");
        if(front == -1)
            front++;
        arr[++rear] = item;
    }
     
    /**
     * @return removed element from the queue
     * 
     */
    public T dequeue() {    
        if(front == -1 || front > rear)
            throw new IndexOutOfBoundsException("Queue is Empty");
        return arr[front++];
    }
        
    public void display() {
        for(int i = 0; i <= rear; i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}
