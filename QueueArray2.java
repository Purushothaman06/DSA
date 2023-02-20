/*
 * Queue Implementation using Arrays
 * by using single pointer approach
 *
 * Enqueue - O(1)
 * Dequeue - O(n)
 * IsEmpty - O(1)
 * Peek - O(1)
 *
 */
public class QueueArray2<T> {

    static final int MAX_SIZE = 30;
    T arr[];
    int rear;
    
    @SuppressWarnings("unchecked")
    QueueArray2() {
        arr = (T[]) new Object[MAX_SIZE];
        rear = -1;
    }
     
    /**
     * @param item
     * 
     */
    public void enqueue(T item) {   
        if(rear == MAX_SIZE-1) 
            throw new IndexOutOfBoundsException("Queue is Full");
        arr[++rear] = item;
    }
     
    /**
     * @return removed element from the queue
     * 
     */
    public T dequeue() {   
        if(rear == -1) 
            throw new IndexOutOfBoundsException("Queue is Empty");
        T temp = arr[0];
        for(int i=1;i<=rear;i++)
            arr[i-1] = arr[i];
        rear--;
        return temp;
    }

    public void display() {
        for(int i = 0; i <= rear; i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
 }

