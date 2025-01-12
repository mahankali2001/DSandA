import java.util.Arrays;

public class Sort {

    public void swap(int[] arr, int from, int to) {
        int temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }

    public int[] bubbleSort(int[] arr) {
        int length = arr.length;
        for(int i=0;i<length;i++) {
            for(int j=0;j<length-1-i;j++) {
                if(arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
        return arr;
    }

    public int[] selectionSort(int[] arr) {
        int length = arr.length;
        int minIndex = 0;
        for(int i=0;i<length;i++) {
            minIndex = i;
            for(int j=i+1;j<length;j++) {
                if(arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            if(i != minIndex) {swap(arr, i, minIndex);}
        }
        return arr;
    }

    public int[] merge(int left[], int right[]) {
        int[] mArr = new int[left.length + right.length];
        int i=0,j=0,mi =0;
        while(i<left.length) {
            if(j == right.length) break;
            while(j<right.length) {
                if(i == left.length) break;
                if(left[i] > right[j]) {
                    mArr[mi] = right[j];
                    j++; mi++;
                }
                else if(left[i] < right[j]) {
                    mArr[mi] = left[i];
                    i++; mi++;
                }
            }
        }

        if(i == left.length) {
            while(j < right.length) {
                mArr[mi] = right[j];
                j++; mi++;
            }
        }
        if(j == right.length) {
            while(i < left.length) {
                mArr[mi] = left[i];
                i++; mi++;
            }
        }

        return mArr;
    }
    
    public int[] mergeSort(int[] arr) {
        if(arr.length == 1) return arr;
        int mid = arr.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);
    }

    public int Pivot(int[] arr, int pivotInex, int right) {
        int swapIndex = pivotInex;
        for(int i =pivotInex+1; i <= right;i++) {
            if(arr[i] < arr[pivotInex]) {
                swapIndex++;
                swap(arr, swapIndex, i);
            }
        }
        swap(arr, pivotInex, swapIndex);
        return swapIndex;
    }

    public void quickSort(int[] arr, int left, int right) {
        if(left < right) {
            int p = Pivot(arr, left, right);
            quickSort(arr, left, p-1);
            quickSort(arr, p+1, right);
        }
    }

    public static void main(String[] args) {
        Sort s = new Sort();
        System.out.println(Arrays.toString(s.bubbleSort(new int[]{5,3,4,1,2,0})));
        System.out.println(Arrays.toString(s.selectionSort(new int[]{5,3,4,1,2,0})));
        System.out.println(Arrays.toString(s.mergeSort(new int[]{5,3,4,1,2,0})));
        int[] a = new int[]{5,3,4,1,2,0};
        s.quickSort(a, 0,5);
        System.out.println(Arrays.toString(a));
    }
}
