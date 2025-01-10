import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST {
    Node root = null;

    class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = this.right = null;
        }
    }
    
    public BST(int value) {
        root = new Node(value);
    }

    public void add(Integer val) {
        Node currentNode = root;
        while(currentNode != null)
            if(val < currentNode.value) {
                if(currentNode.left == null) {
                    currentNode.left = new Node(val);
                    return;
                }
                currentNode = currentNode.left;
            }
            else if(val > currentNode.value) {
                if(currentNode.right == null) {
                    currentNode.right = new Node(val);
                    return;
                }
                currentNode = currentNode.right;
            }
            else return;
    }
    /*
     * Bst algorithm - queue
     * Start with root node, queue it
     * Until
     */
    public ArrayList<Integer> BST(){
        Node currentNode = null;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> bstResult = new ArrayList<>();
        if(root == null) return null;
        queue.add(root);
        while (queue.size() != 0) {
            currentNode = queue.remove();
            bstResult.add(currentNode.value);
            if(currentNode.left != null) 
                queue.add(currentNode.left);
            if(currentNode.right != null)
                queue.add(currentNode.right);
        }
        return bstResult;
    }

    /*
     * root, left, righ
     */
    public void PreOrder() {
        if(root == null) return;
        PreOrder(root);
    }

    // DST
    public void PreOrder1() {
        if(root == null) return;
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.print(current.value + " ");
            if(current.right != null)
                stack.push(current.right);
            if(current.left != null)
                stack.push((current.left));
        }
    }

    public void PreOrder(Node n) {
        if(n == null) return;
        System.out.print (n.value + " ");
        PreOrder(n.left);
        PreOrder(n.right);
    }

    public void PreOrderNonRecursive() {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            System.out.print(current.value + " ");
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
    }

    public static void main(String[] args) {
        BST bst = new BST(70);
        bst.add(50);
        bst.add(80);
        bst.add(30);
        bst.add(60);
        bst.add(80);
        bst.add(75);
        bst.add(85);

        ArrayList<Integer> bstResult = bst.BST();

        System.out.println(bstResult);

        // bst.PreOrder();

        System.out.println();

        bst.PreOrder1();
    }
}