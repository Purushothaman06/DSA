public class Sorting {

    /**
     * @param arr
     * 
     */
    public static void selectionSort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {   // fix the position
            int minIndex = i;
            for(int j = i; j < arr.length; j++) {   // select the minimum value
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // swap - i, min
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    /**
     * @param arr
     * 
     */
    public static void bubbleSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            boolean swapped = false;
            for(int j = 0; j < arr.length - 1; j++) {
                if(arr[j] > arr[j+1]) {
                    swapped = true;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if(!swapped) {  // if not swapped
                break;
            }
        }
    }

    /**
     * @param arr
     * 
     */
    public static void insertionSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            for(int j = i; j > 0; j--) {
                if(arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
                else {
                    break;
                }
            }
        }
    }

    
    /**
     * @param arr
     * @param low
     * @param high
     * 
     */
    public static void quickSort(int[] arr, int low, int high) {
        if(low >= high) 
            return ;

        int start = low;
        int end = high;
        int mid = (start + end) / 2;
        int pivot = arr[mid];
        while(start <= end) {
            while(arr[start] < pivot)
                start++;
            while(arr[end] > pivot)
                end--;    
            if(start <= end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        quickSort(arr, low, end);
        quickSort(arr, start, high);
    }

    /**
     * @param arr
     * @param start
     * @param end
     * sorted within the array without using extra-space
     * by using two pointer approach
     * 
     */
    public static void mergerSortInPlace(int[] arr, int start, int end) {
        if(end - start == 1)
            return ;
        
        int mid = (start + end) / 2;
        mergerSortInPlace(arr, start, mid);
        mergerSortInPlace(arr, mid, end);

        mergeInPlace(arr, start, mid, end);
    }

    
    /**
     * @param arr
     * @param start
     * @param mid
     * @param end
     * 
     */
    private static void mergeInPlace(int[] arr, int start, int mid, int end) {
        int[] join = new int[end - start];
        int i = start, j = mid, k = 0;

        while(i < mid && j < end) {
            if(arr[i] < arr[j])
                join[k++] = arr[i++];
            else 
                join[k++] = arr[j++];
        }

        while(i < mid) 
            join[k++] = arr[i++];
        while(j < end)
            join[k++] = arr[j++];

        for(k=0;k<join.length;k++)
            arr[start + k] = join[k];
    }


    /**
     * @param arr
     * @return sorted array
     * 
     */
    public static int[] mergeSort(int[] arr) {
        if(arr.length == 1) 
            return arr;

        int mid = arr.length / 2; 
        int[] left = mergeSort(java.util.Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(java.util.Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    /**
     * @param left
     * @param right
     * @return merged sorted array
     * 
     */
    private static int[] merge(int[] left, int[] right) {
        int[] join = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;    // using two pointer approach

        while(i < left.length && j < right.length) {
            if(left[i] < right[j])   
                join[k++] = left[i++];
            else 
                join[k++] = right[j++];
        }

        while(i < left.length) 
            join[k++] = left[i++];
        while(j < right.length)
            join[k++] = right[j++];

        return join;
    }
}