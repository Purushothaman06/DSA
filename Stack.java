/*
 * Stack Implmentation using LinkedList
 *
 * Push - O(1)
 * Pop - O(1)
 * Peek - O(1)
 * IsEmpty - O(1)
 *
 */
public class Stack<T> {
    Node top;

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

    Stack() {
        top = null;
    }

    /**
     * @param val
     * 
     */
    public void push(T val) {
        Node newNode = new Node(val);

        if(top == null) 
            top = newNode;
        else 
            newNode.next = top;
            top = newNode;
    }

    /**
     * @return the poped element from the stack
     * 
     */
    public T pop() {
        if(top == null)
            throw new IndexOutOfBoundsException("Stack UnderFlow");

        T temp = top.data;
        top = top.next;
       
        return temp;
    }

    /**
     * @return data from top of the stack
     * 
     */
    public T peek() {
        return top.data;
    }

    /**
     * @return true if stack is empty
     * @return false if stack is not empty
     * 
     */
    public boolean isEmpty() {
        return top==null;
    }
}