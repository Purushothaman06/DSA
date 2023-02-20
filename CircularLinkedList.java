/*
 * Circular Linked List Implmentation 
 * 
 * Read, Update - O(n)
 * Insert - O(n)
 * Delete - O(n)
 * Search - O(n)
 * 
 */
public class CircularLinkedList<T> {
    Node last;

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

    CircularLinkedList() {
        last = null;
    }

    /**
     * @param val
     * 
     */
    public void addFirst(T val) {
        Node newNode = new Node(val);
        
        if(last == null) {
            newNode.next = newNode;
            last = newNode;
        } else {
            newNode.next = last.next;
            last.next = newNode;
        }
    }

    /**
     * @param val
     * 
     */
    public void addLast(T val) {
        Node newNode = new Node(val);
        
        if(last == null) 
            newNode.next = newNode;
        else {
            newNode.next = last.next;
            last.next = newNode;
        }
        last = newNode;
    }

    public void removeFirst() {
        if(last == null)
            throw new IndexOutOfBoundsException("Deletion attempted on Empty list");
        
        if(last.next == last) 
            last = null;
        else
            last.next = last.next.next;
    }

    public void removeLast() {
        if(last == null)
            throw new IndexOutOfBoundsException("Deletion attempted on Empty list");

        Node temp = last.next;
        if(last.next == last)
            last = null;
        else {
            while(temp.next != last) {
                temp = temp.next;
            }
            temp.next = last.next;
            last = temp.next;
        }
    }

    public void display() {
        if(last == null)
            return ;

        Node temp = last.next;
        do {
            System.out.print(temp.data+" ");
            temp = temp.next;
        } while(temp != last.next);
        System.out.println();
    }

    /**
     * @param val
     * @param data
     * 
     */
    public void addAfter(T val, T data) { // TODO INCOMPLETE
        Node newNode = new Node(data);
        Node temp = last.next;

        while(temp != last){
            temp = temp.next;
            if(temp.data == val){
                newNode.next = temp.next;
                temp.next = newNode;
            }
        }
    }

    /**
     * @param val
     * 
     */
    public void remove(T val) { 
        if(last.next.data == val){
            removeFirst();
            return;
        }

        if(last.next == last)
            last = null;
    
        Node temp = last.next;
        Node prev = null;
        
        while(temp != last){
            prev = temp;
            temp = temp.next;
            if(temp.data == val){
                prev.next = temp.next;
            }
        }
    }

    public int size() {
        int count = 0;
        Node temp = last;

        if(last == null)
            return count;
      
        while(temp.next != last) {
            count++;
            temp.next = temp.next.next;
            if(temp == last) {
                count++;
            }
        }
        return count;
    }

    /**
     * @param val
     * @return true if contains else, return false.
     * 
     */
    public boolean contains(T val) {
        Node temp = last.next;
        while(temp != last) {
            if(temp.data == val)
                return true;
            temp = temp.next;
        }
        return false;
    }
}