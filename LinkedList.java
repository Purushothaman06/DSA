/*
 * Linked List Implmentation 
 * 
 * Read, Update - O(n)
 * Insert - O(n)
 * Delete - O(n)
 * Search - O(n)
 * 
 */
class LinkedList<T> implements Iterable<T> {
    Node head;

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

    LinkedList() {
        head = null;
    }

    /**
     * @param val
     * 
     */
    public void addFirst(T val) {
        Node newNode = new Node(val);
        newNode.next = null;

        if (head == null)
            head = newNode;
        else {
            newNode.next = head;
            head = newNode;
        }
    }

    /**
     * @param val
     * 
     */
    public void addLast(T val) { 
        Node newNode = new Node(val);
        Node temp = head;

        if (head == null)
            head = newNode;
        else {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    /**
     * @param pos
     * @param val
     * 
     */
    public void add(int pos,T val) {
        if(pos == 0) {
            addFirst(val);
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
        temp.next = newNode;
        
    }

    public void removeFirst() {
        if(head == null)
            throw new java.util.NoSuchElementException("Deletion attempted on Empty List/");

        head = head.next;
    }

    /**
     * @param pos
     * 
     */
    public void remove(int pos) {
        if(head == null)
            throw new java.util.NoSuchElementException("Deletion attempted on Empty List/");

        if(pos == 0) {
            head = head.next;
            return ;
        }
            
        Node temp = head;
        Node prev = null;
        for(int i=1;i<=pos;i++) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = temp.next;
    }

    public void removeLast() { 
        if(head == null) 
            throw new java.util.NoSuchElementException("Deletion attempted on Empty List");
    
        Node temp = head;
        Node prev = null;

        while(temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
    }

    public void display() {
		Node temp = head;
		while(temp != null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
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
     * @return true if list is empty
     * @return false if list is not empty
     * 
     */
    public boolean isEmpty() {
        return head==null;
    }

    /**
     * @param index
     * @return data from the given index
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
			count++;
            temp = temp.next;
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