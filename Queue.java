public class Queue {
    int length;
    Node first;
    Node last;
    
    class Node {
        int value;
        Node next;
        public Node(int v){
            value = v;
            next = null;
        }
    }
    public Queue(){
        first = last = null;
        length = 0;
    }
    
    public void enqueue(int value){
        Node newNode = new Node(value);
        if(length==0) {
            first = last = newNode;
        }else{
            last.next=newNode;
            last = newNode;
        }
        length++;
    }

    public Node dequeue() {
        if(length==0) return null;
        else if(length==1){
            Node temp=first;
            first = last = null;
            temp.next = null;
            length--;
            return temp;
        }
        else{
            Node temp = first;
            first = first.next;
            temp.next = null;
            length--;
            return temp;
        }
    }

    public void print(){
        Node current = first;
        while(current!=null){
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.print();
        q.dequeue();
        q.print();
        q.dequeue();
        q.print();
    }
}
