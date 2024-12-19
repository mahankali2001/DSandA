public class Stack {
   int top = -1, capacity = 0;
   String stack[];
   public Stack(int size){
        stack = new String[size];
        capacity = size;
   }

    public void push(String val) {
        
        if(stack != null && isFull()) {
            top++;
            stack[top]=val;
        }
        else
            System.out.println("stack overflow!");
    }

    public void pop() {
        if(stack != null && top >= 0){
            stack[top] = null;
            top--;
        }
    }

    public boolean isFull(){
        return capacity-1 > top;
    }

    public void print() {
        for (String s : stack) {
            if(s != null)
                System.out.print(s + "->");
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");
        stack.push("6");
        stack.print();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.print();
    }
}