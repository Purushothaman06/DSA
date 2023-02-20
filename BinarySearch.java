public class BinarySearch {

    /**
     * @param arr
     * @param target
     * @return index of target
     * @return -1 if target not found
     * Order agnostic
     * works only for sorted arrays
     * 
     */
    public static int search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        boolean asc = false;

        if(arr[start]<arr[end])
            asc = true;

        while(start <= end) {
            int mid = (start + end)/2;
            
            if(asc) {   // if array is Ascending Order
                if(target > arr[mid])   
                    start = mid + 1;
                else if(target < arr[mid])
                    end = mid - 1;
                else 
                    return mid;
            }
            else {  // otherwise, it is Descending Order
                if(target > arr[mid])   
                    end = mid - 1;
                else if(target < arr[mid])
                    start = mid + 1;
                else 
                    return mid;
            }   
        }
        return -1;
    }
}