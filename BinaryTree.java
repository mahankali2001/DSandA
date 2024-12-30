import java.util.ArrayList;
import java.util.List;

public class BinaryTree {
    node root;

    BinaryTree(){root = null;}

    class node {
        int num = 0;
        node left, right;
    
        public node(int val) {num = val; left = right = null;}
    
    }

    // left, root, right
    public void inorder(node n){
        if(n != null) {
            inorder(n.left);
            System.out.print(n.num + "->");
            inorder(n.right);
        }
    }

    // root, left, right
    public void preorder(node n){
        if(n != null) {
            System.out.print(n.num + "->");
            preorder(n.left);
            preorder(n.right);
        }
    }
    
    // left, right, root
    public void postorder(node n){
        if(n != null) {
            postorder(n.left);
            postorder(n.right);
            System.out.print(n.num + "->");
        }
    }

    //root, left, right
    public void levelorder(node n){
        List<node> nodes = new ArrayList<>();
        if(n==null) return;
        nodes.add(n);
        while (nodes.size() !=0) {
            node n1 = nodes.remove(0);
            if(n1 != null) {
                System.out.print(n1.num + "->");
                nodes.add(n1.left);
                nodes.add(n1.right);
            }
        }
    }

    public void insert(int val) {
        root = insertRec(root, val);
    }

    public node insertRec(node root, int val) {
        if(root == null) {
            root = new node(val);
            return root;
        }
        if(val < root.num) {
            root.left = insertRec(root.left, val);
        } else if(val > root.num) {
            root.right = insertRec(root.right, val);
        }
        return root;
    }

    public static void main(String[] args) {
        BinaryTree b = new BinaryTree();
        b.root = b.new node(1);
        b.root.left = b.new node(2);
        b.root.right = b.new node(3);
        b.root.left.right = b.new node(4);
        b.root.right.left = b.new node(5);
        // 1 -> 2L, 3R, 2L -> 4R, 3R -> 5L
        b.inorder(b.root); // 2, 4, 1, 5, 3
        System.out.println(); 
        b.preorder(b.root); // 1, 2, 4, 3, 5
        System.out.println(); 
        b.postorder(b.root); // 4, 2, 5, 3, 1
        System.out.println(); 
        b.levelorder(b.root); // 1, 2, 3, 4, 5

    }
}
