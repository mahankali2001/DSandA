public class LinkedList {
    Node head;
    Node tail;
    int size;
    LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public void add(int value) {
        Node newNode = new Node(value);
        if(head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void print() {
        Node current = head;
        Node temp = head;
        while(current != null) {
            System.out.print(current.value + " ");
            current = current.next;
            if(current == temp) {
                System.out.println("Loop detected");
                break;
            }
        }
        System.out.println();
    }

    public int search(int value) {
        Node current = head;
        int index = 0;
        while(current != null) {
            if(current.value == value)
                return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public void insert(int index, int value) {
        if(index < 0 || index > size) {
            System.out.println("Invalid index");
            return;
        }
        Node newNode = new Node(value);
        if(index == 0) {
            newNode.next = head;
            head = newNode;
            if(tail == null)
                tail = newNode;
        } else {
            Node current = head;
            for(int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            if(newNode.next == null)
                tail = newNode;
        }
        size++;
    }

    public void remove(int index) {
        if(index < 0 || index >= size) {
            System.out.println("Invalid index");
            return;
        }
        if(index == 0) {
            head = head.next;
            if(head == null)
                tail = null;
        } else {
            Node current = head;
            for(int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            if(current.next == null)
                tail = current;
        }
        size--;
    }

    public void reverse() {
        System.out.println("reversing the list");
        Node prev = null;
        Node current = head;
        Node next = null;
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public void sort() {
        Node current = head;
        Node index = null;
        int temp;
        while(current != null) {
            index = current.next;
            while(index != null) {
                if(current.value > index.value) {
                    temp = current.value;
                    current.value = index.value;
                    index.value = temp;
                }
                index = index.next;
            }
            current = current.next;
        }
    }

    public void set(int index, int value) {
        if(index < 0 || index >= size) {
            System.out.println("Invalid index");
            return;
        }
        Node current = head;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }
        current.value = value;
    }

    public int get(int index) {
        if(index < 0 || index >= size) {
            System.out.println("Invalid index");
            return -1;
        }
        Node current = head;
        for(int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        if(tail == null)
            tail = newNode;
        size++;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public Node linkedListGetMiddleNode(){
        Node slow, fast, temp;
        if(head == null || head.next == null) return null;
        slow = fast = temp = head;
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if(fast.next != null) {
                fast = fast.next;
                if(temp == fast)
                    break;
            }
        }
        return slow;
    }

    public boolean linkedListHasLoop(){
        Node slow, fast;
        if(head == null || head.next == null) return false;
        slow = fast = head;
        while(fast.next != null) {
            fast = fast.next;
            if(fast.next != null) {
                fast = fast.next;
                if(slow == fast)
                    return true; 
            }
        }
        return false;
    }

    public void formLoop() {        
        tail.next = head;
        System.out.println("form loop");
    }

    public void removeLoop() {
        System.out.println("remove loop");
        if(head == null || head.next == null) return;
        else {
            Node temp = head;
            Node fast = head;
            while(fast.next != null) {
                fast = fast.next;
                if(temp == fast.next) {
                    fast.next = null;
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.print();
        System.out.println("Index of 3: " + list.search(3));
        System.out.println("Index of 6: " + list.search(6));

        list.insert(2, 6);
        list.print();
        
        list.remove(2);
        list.print();

        list.sort();
        list.print();

        list.set(2, 7);
        list.print();

        System.out.println("Element at index 2: " + list.get(2));

        System.out.println("Size of list: " + list.size());

        System.out.println("Is list empty: " + list.isEmpty());

        list.prepend(0);

        list.print();

        Node n = list.linkedListGetMiddleNode();
        System.out.println("LinkedList middle node: " + (n == null ? "null" : n.value));

        System.out.println("Is linkedList hasLoop: " + list.linkedListHasLoop());

        list.print();


        list.formLoop();

        list.print();

        System.out.println("Is linkedList hasLoop: " + list.linkedListHasLoop());

        list.print();

        list.removeLoop();

        System.out.println("Is linkedList hasLoop: " + list.linkedListHasLoop());

        list.print();

        list.reverse();
        list.print();

        list.clear();
    }
}
