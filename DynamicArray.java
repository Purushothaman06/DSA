/*
 * Dynamic Array Implementation 
 *
 * Read, Write & Update - O(1)
 * Insert - O(n)
 * Delete - O(n)
 * Search - O(n)
 *
 */
class DynamicArray<T> implements Iterable<T> {

    private static final int initialCapacity = 11;
    private T arr[];
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    DynamicArray() {
        size = 0;
        arr = (T[]) new Object[initialCapacity];
        capacity = initialCapacity;
    }

    /**
     * @param val
     * 
     */
    public void insertAtBegin(T val) { //error
        if(size == capacity) 
            expandArray();
        for(int i=size-1;i>=0;i--)
            arr[i+1] = arr[i];
        arr[0] = val;
        size++;
    }

    private void expandArray() {
        capacity *= 2;
        arr = java.util.Arrays.copyOf(arr, capacity);
    }

    /**
     * @param pos
     * @param val
     * 
     */
    public void insertAtPos(int pos,T val) {
        if(size == capacity)
            expandArray();
        for(int i=size-1;i>=pos;i--)
            arr[i+1] = arr[i];
        arr[pos] = val;
        size++;
    }

    /**
     * @param val
     * 
     */
    public void insertAtEnd(T val) { 
        if(size == capacity)
            expandArray();
        arr[size++] = val;
    }

    public void deleteAtBegin() {
        for(int i=1;i<size;i++)
            arr[i-1] = arr[i];
        size--;
        if(capacity > initialCapacity && capacity < 3*size)
            shrinkArray();
    }

    private void shrinkArray() {
        capacity /= 2;
        arr = java.util.Arrays.copyOf(arr, capacity);
    }

    /**
     * @param pos
     * 
     */
    public void deleteAtPos(int pos) {
        for(int i=pos+1;i<size;i++)
            arr[i-1] = arr[i];
        size--;
        if(capacity > initialCapacity && capacity < 3*size)
            shrinkArray();
    }

    public void deleteAtEnd() {
        arr[size-1] = null;
        size--;
        if(capacity > initialCapacity && capacity < 3*size)
            shrinkArray();
    }

    public void display() {
        System.out.println("Elements in the List :");
		for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i]+" ");
        System.out.println();
	}

    /**
     * @param val
     * 
     */
    public void search(T val) {
        int temp = 0;
        for(int i=0;i<size;i++){
            if(arr[i] == val)
                temp = i;
        }
        if(arr[temp] == val)
            System.out.println("Element Found at Position : " + temp);
        else
            System.out.println("Element Not Found");
    }

    /**
     * @param pos
     * @param val
     * 
     */
    public void update(int pos,T val) {
        arr[pos] = val;
    }

    /**
     * @param pos
     * @return data from the given index.
     * 
     */
    public T get(int pos) {
        return arr[pos]; 
    }

    /**
     * @return length of the array.
     * 
     */
    public int length() {
        return size;
    }

    /**
     * @param val
     * @return true if element found 
     * @return false if element not found
     * 
     */
    public boolean contains(T val) {
        int temp = 0;
        for(int i=0;i<size;i++){
            if(arr[i] == val)
                temp = i;
        }
        if(arr[temp] == val)
            return true;
        else
            return false;
    }

    public void clear() { 
        size = 0;
    }

    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            int index = 0;

            public boolean hasNext() {
                return index < size;
            }

            public T next() {
                return arr[index++];
            }
        };
    }
}


