public class LinearSearch {
    /**
     * @param arr
     * @param target
     * @return the index of target 
     * @return -1 if target not found
     * 
     */
    public static int find(int[] arr, int target) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @param arr
     * @param target
     * @return true if the element found 
     * @return false if element not found
     * 
     */
    public static boolean contains(int[] arr, int target) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == target) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param str
     * @param target
     * @return the index of target 
     * @return -1 if target not found
     *  
     */
    public static int find(String str, char target) {
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == target){
                return i;
            }
        }
        return -1;
    }

    /**
     * @param str
     * @param target
     * @return true if the element found 
     * @return false if element not found
     * 
     */
    public static boolean contains(String str, char target) {
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == target){
                return true;
            }
        }
        return false;
    }

    /**
     * @param arr_2d
     * @param target
     * @return the index of target 
     * @return -1 if target not found
     * 
     */
    public static int[] find(int[][] arr_2d, int target) {
        for(int i = 0; i < arr_2d.length; i++) {
            for(int j = 0; j < arr_2d[i].length; j++) {
                if(arr_2d[i][j] == target) {
                    return new int[] {i,j};
                }
            }
        }
        return new int[] {-1,-1};
    }

    /**
     * @param arr_2d
     * @param target
     * @return true if the element found 
     * @return false if element not found
     * 
     */
    public static boolean contains(int[][] arr_2d, int target){
        for(int i = 0; i < arr_2d.length; i++) {
            for(int j = 0; j < arr_2d[i].length; j++) {
                if(arr_2d[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @param arr
     * @return maximum element
     * 
     */
    public static int max(int[] arr) {
        int max = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * @param arr
     * @return minimum element 
     * 
     */
    public static int min(int[] arr) {
        int min = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

    /**
     * @param str
     * @param target
     * @return number of character which is matched to target element 
     * 
     */
    public static int count(String str, char target) {
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == target) {
                count++;
            }
        }
        return count;
    }

    // count the four digit element in the array 
    // {123,7845,124,78452,1429}
    /**
     * @param arr
     * @param target
     * @return the count of four digit number
     * 
     */
    public static int count(int[] arr, int target) {
        int count = 0;
        for(int i = 0; i < arr.length; i++) {

        }
        return count;
    }
}
