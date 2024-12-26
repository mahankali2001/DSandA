public class Stack {
    public Node top;
    public int height;

    public class Node {
        int value;
        Node next;
        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public Stack() {
        top = null;
        height = 0;
    }

    public void push(int val) {
        if(height == 0) {
            top = new Node(val);
        } else {
            Node newNode = new Node(val);
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    public Node pop(){
        Node temp;
        if (height == 0) return null;
        else if(height == 1) {
            temp = top;
            top = null;
        }
        else {
            temp = top;
            top = top.next;
            temp.next = null;
        }
        height--;
        return temp;
    }

    public void printAll() {
        Node current = top;
        while(current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.printAll();
        s.pop();
        s.printAll();
        s.pop();
        s.printAll();
    }
}