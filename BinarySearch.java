/**
 * The bSearch class provides a method to perform binary search on an array of integers.
 */
public class BinarySearch {

    /**
     * Default constructor for the bSearch class.
     */
    BinarySearch() {}

    /**
     * Performs a binary search on the given sorted array to find the specified value.
     *
     * @param data the sorted array of integers to search
     * @param val the value to search for
     * @return the index of the value if found, otherwise -1
     */
    public int search(int[] data, int val) {
        // method implementation goes here
        int left = 0;
        int right = data.length - 1;
        int mid;
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(data[mid] == val)
                return mid;
            if(data[mid] < val)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int [] data = {1,3,5,7,8, 9};
        System.out.println(bs.search(data, 3) + "");
        System.out.println(bs.search(data, 8) + "");
    }
}
