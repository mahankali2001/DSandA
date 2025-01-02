import java.util.ArrayList;
import java.util.List;

public class Heap {
    List<Integer> heap;
    public Heap() {
        heap = new ArrayList<>();
    }   

    public void insert(int value){
        heap.add(value);
        int current = heap.size() -1;
        while(current > 0 || heap.get(current) > heap.get(parentIndex(current))) { //pi >= 0 && heap.get(pi) < heap.get(heap.size() - 1)
            swap(current, parentIndex(current));
            current = parentIndex(current);
        }
    }

    public int leftChildIndex(int i) {
        return 2 * i + 1;
    }

    public int rightChildIndex(int i) {
        return 2 * i + 2;
    }

    public int parentIndex(int i) {
        return (i - 1) / 2;
    }

    public void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void printAll() {
        for(int i = 0; i < heap.size(); i++) {
            System.out.print(heap.get(i) + " ");
        }
        System.out.println();
    }

    public Integer remove(){
        if(heap.size() == 0) return null;
        if(heap.size() == 1) return heap.remove(0);
        int max = heap.get(0);
        heap.set(0, heap.remove(heap.size() - 1));
        heapify(0);
        return max;
    }

    public void heapify(int i) {
        int leftI = leftChildIndex(i);
        int rightI = rightChildIndex(i);
        int largest = i;
        if(leftI < heap.size() && heap.get(leftI) > heap.get(i)) {
            largest = leftI;
        }
        if(rightI < heap.size() && heap.get(rightI) > heap.get(largest)) {
            largest = rightI;
        }
        if(largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap();
        h.insert(1);
        h.insert(2);
        h.insert(3);
        h.insert(4);
        h.insert(5);
        h.insert(6);
        h.insert(7);
        // h.insert(8);
        // h.insert(9);
        // h.insert(10);
        // h.insert(11);
        // h.insert(12);
        // h.insert(13);
        // h.insert(14);
        // h.insert(15);
        h.printAll();

        System.out.println("Removed: " + h.remove());
        h.printAll();
    }
}
