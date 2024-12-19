
/**
 * A simple stack implementation that can store up to a specified number of elements.
 * The stack is implemented as an array of strings.
 * The stack has a fixed capacity, and it is not resizable.
 * The stack supports the following operations:
 * 1. push: Adds an element to the top of the stack.
 * 2. pop: Removes the element from the top of the stack.
 * 3. isFull: Checks if the stack is full.
 * 4. print: Prints the contents of the stack.
 */
public class Stack {
   int top = -1, capacity = 0;
   String stack[];

   /**
    * Constructor to create a stack with the specified capacity.
    *
    * @param size The capacity of the stack.
    */
   public Stack(int size){
        stack = new String[size];
        capacity = size;
   }

   /**
    * Adds an element to the top of the stack.
    * @param val
    */
    public void push(String val) {
        
        if(stack != null && isFull()) {
            top++;
            stack[top]=val;
        }
        else
            System.out.println("stack overflow!");
    }

    /**
     * Removes the element from the top of the stack.
     */
    public void pop() {
        if(stack != null && top >= 0){
            stack[top] = null;
            top--;
        }
    }

    /**
     * Checks if the stack is full.
     * @return
     */
    public boolean isFull(){
        return capacity-1 > top;
    }

    /**
     *  Prints the contents of the stack.
     */
    public void print() {
        for (String s : stack) {
            if(s != null)
                System.out.print(s + "->");
        }
    }

    /**
     * The main method to test the Stack class.
     * It performs the following operations:
     * 1. Creates a stack with a capacity of 5.
     * 2. Pushes six elements onto the stack (the sixth push should trigger a stack overflow message).
     * 3. Prints the stack contents.
     * 4. Pops all elements from the stack (the sixth pop should not affect the stack as it is already empty).
     * 5. Prints the stack contents again.
     *
     * @param args Command line arguments (not used).
     */
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