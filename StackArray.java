/*
 * Stack Implmentation using Array
 *
 * Push - O(1)
 * Pop - O(1)
 * Peek - O(1)
 * IsEmpty - O(1)
 *
 */
public class StackArray<T> {
    
    int top;
    T[] arr;
    static final int MAX_SIZE = 30;

    @SuppressWarnings("unchecked")
    StackArray() {
        top = -1;
        arr = (T[]) new Object[MAX_SIZE];
    }

    /**
     * @param val
     * 
     */
    public void push(T val) {
        if(top == MAX_SIZE-1)
            throw new IndexOutOfBoundsException("Stack OverFlow");
        
        arr[++top] = val;
    }

    /**
     * @return removed the top element from the stack
     * 
     */
    public T pop() {
        if(top == -1)
            throw new IndexOutOfBoundsException("Stack UnderFlow");
        
        return arr[top--];
    }

    /**
     * @return the top element from the stack
     * 
     */
    public T peek() {
        return arr[top];
    }

    /**
     * @return true if stack is empty 
     * @return false if stack is not empty
     * 
     */
    public boolean isEmpty() {
        return top==-1;
    }
 }