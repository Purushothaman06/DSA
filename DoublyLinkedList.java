/*
 * Doubly Linked List Implmentation 
 * 
 * Read, Update - O(n)
 * Insert - O(n)
 * Delete - O(n)
 * Search - O(n)
 * 
 */
public class DoublyLinkedList<T> implements Iterable<T> {
    Node head;
    Node tail;

    class Node {
        T data;
        Node next;
        Node prev;

        /**
         * @param val
         * 
         */
        Node(T val) {
            data = val;
            next = null;
            prev = null;
        }
    }

    DoublyLinkedList() {
        head = null;
        tail = null;
    }

    /**
     * @param val
     * 
     */
    public void insertFirst(T val) {
        Node newNode = new Node(val);
        newNode.next = head;

        if(head == null)
            tail = newNode;
        else
            head.prev = newNode;
        head = newNode;
    }

    /**
     * @param val
     * 
     */
    public void insertLast(T val) { // incomplete
        Node newNode = new Node(val);
        Node temp = head;

        if (head == null)
            head = newNode;
        else {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
            tail = newNode;
        }
    }

    /**
     * @param pos
     * @param val
     * 
     */
    public void insert(int pos,T val) {
        if(pos == 0) {
            insertFirst(val);
            return;
        }

        Node newNode = new Node(val);
        Node temp = head;

        for(int i=1;i<pos;i++) {
            temp = temp.next;
            if(temp == null)
                throw new IllegalArgumentException("Invalid position");
        }
        newNode.next = temp.next;
        newNode.prev = temp;

        if(temp == tail)
            tail = newNode;
        else
            temp.next.prev = newNode;
        temp.next = newNode;
    }

    public void deleteFirst() {
        if(head == null)
            throw new IndexOutOfBoundsException("Deletion attempted on Empty List/");

        if(head == tail) {
            head = null;
            tail = null;
        } else {
            head.next.prev = null;
            head = head.next;
        }
    }

    /**
     * @param pos
     * 
     */
    public void delete(int pos) {
        if(head == null)
            throw new IndexOutOfBoundsException("Deletion attempted on Empty List/");

        if(pos == 0) {
            head = head.next;
            if(head == null)
                tail = null;
            else
                head.prev = null;
            return ;
        }

        Node temp = head;
        // Node prev = null;
        for(int i=1;i<=pos;i++) {
            // prev = temp;
            temp = temp.next;
            if(temp == null)
                throw new IndexOutOfBoundsException("Invalid Position");
        }
        
        // Alternate way with two pointer
        // prev.next = temp.next;
        // if(temp.next == null)
        //     tail = prev;
        // else
        //     temp.next.prev = prev;

        temp.prev.next = temp.next;
        if(temp == tail)
            tail = temp.prev;
        else
            temp.next.prev = temp.prev;
    }

    public void deleteLast() { 
        if(head == null)
            throw new IndexOutOfBoundsException("Deletion attempted on Empty List");

        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        if(head == tail) {
            head = null;
            tail = null;
        } else {
            temp.prev.next = null;
            tail = temp.prev;
        }     
    }

    public  void display() {
        Node temp = head;

        while(temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void displayReverse() {
        Node temp = tail;;

        while(temp != null) {
            System.out.print(temp.data+" ");
            temp = temp.prev;
        }
        System.out.println();
    }


    /**
     * @param val
     * 
     */
    public void search(T val) {
        int count = 0;
        if(head.data == val) {
            System.out.println("Element Found At the Position: "+count);
            return;
        }

        Node temp = head;
        while(temp != null) {
            if(temp.data == val) 
                System.out.println("Element Found At the Position: "+count);     
            temp = temp.next;
            count++;
        }
    }

    /**
     * @return true if linked is Empty else, return false.
     * 
     */
    public boolean isEmpty() {
        return (head==null);
    }

    /**
     * @param index
     * @return data from the given index.
     * 
     */
    public T get(int index) {
        Node temp = head;
        if(index == 0) 
            return head.data;

        for(int i=1;i<=index;i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    /**
     * @param index
     * @param val
     * 
     */
    public void update(int index,T val) {
        if(head == null)
            throw new IndexOutOfBoundsException("Updation attempted on Empty List");

        if(index == 0) {
            head.data = val;
            return;
        }

        Node temp = head;
        for(int i=1;i<=index;i++) {
            temp = temp.next;
        }
        temp.data = val;
    }

    /**
     * @param val
     * @return true if element found  
     * @return false if element not found 
     * 
     */
    public boolean contains(T val) {
        Node temp = head;
        boolean status = false;

        while(temp != null) {
            if(temp.data == val)
                status = true;
            temp = temp.next;
        }
        return status;
    }

    /**
     * @return length of the linked list
     * 
     */
    public int length() {
        int count = 0;
        Node temp = head;
        while(temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public void reverse() {
        if(head == null)
           throw new IndexOutOfBoundsException("Reversal Made on Empty List");

        Node prev = null;
        Node cur = head;
        Node next = head.next;
        while(cur != null) {
            next = cur.next;
            cur.next = prev; // reverse link
            prev = cur;
            cur = next;
        }
        head = prev;
    }
     
    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            Node temp = head;

            public boolean hasNext() {
                return temp!=null;
            }

            public T next() {
                T val = temp.data;
                temp = temp.next;
                return val;
            }
        };
    }
}