public class BinarySearchTree {
    Node root = null;

    public class Node {
        int value;
        Node left;
        Node right;
        public Node(int val) {
            value = val;
            left = right = null;
        }
    }
    
    public BinarySearchTree(int value) {
        root = new Node(value);
    }

    public void insert(int value) {
        root = insertRec(root, value);
    }   

    public Node insertRec(Node root, int value) {
        if(root == null) {
            root = new Node(value);
            return root;
        }
        if(value < root.value) {
            root.left = insertRec(root.left, value);
        } else if(value > root.value) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }   

    public Node insertNode(int value) {
        if(root == null) {
            root = new Node(value);
            return root;
        }
        Node currentNode = root;
        while(currentNode != null) {
            if(value < currentNode.value) {
                if(currentNode.left == null) {
                    currentNode.left = new Node(value);
                    return root;
                }
                currentNode = currentNode.left;
            } else if(value > currentNode.value) {
                if(currentNode.right == null) {
                    currentNode.right = new Node(value);
                    return root;
                }
                currentNode = currentNode.right;
            } else {
                return root;
            }
        }
        return root;
    }

    public boolean contains(int value) {
        return contains(root, value);
    }

    public boolean contains(Node root, int value) {
        if(root == null || root.value == value) {
            return true;
        }
        if(value < root.value) {
            return contains(root.left, value);
        }
        return contains(root.right, value);
    }

    public void delete(int value) {
        root = deleteRec(root, value);
    } 

    public Node deleteRec(Node root, int value) {
        if(root == null) {
            return root;
        }
        if(value < root.value) {
            root.left = deleteRec(root.left, value);
        } else if(value > root.value) {
            root.right = deleteRec(root.right, value);
        } else {
            if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            }
            root.value = minValue(root.right);
            root.right = deleteRec(root.right, root.value);
        }
        return root;
    }

    public int minValue(Node root) {
        int min = root.value;
        while(root.left != null) {
            min = root.left.value;
            root = root.left;
        }
        return min;
    }

    public void printInOrder() {
        printInOrderRec(root);
    }

    public void printInOrderRec(Node root) {
        if(root != null) {
            printInOrderRec(root.left);
            System.out.print(root.value + " ");
            printInOrderRec(root.right);
        }
    }

    public void printPreOrder() {
        printPreOrderRec(root);
    }
        
    public void printPreOrderRec(Node root) {
        if(root != null) {
            System.out.print(root.value + " ");
            printPreOrderRec(root.left);
            printPreOrderRec(root.right);
        }
    }

    public void printPostOrder() {
        printPostOrderRec(root);
    }

    public void printPostOrderRec(Node root) {
        if(root != null) {
            printPostOrderRec(root.left);
            printPostOrderRec(root.right);
            System.out.print(root.value + " ");
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);
        System.out.println("Is 60 exist in bst: " + (bst.contains(60)? "Yes": "No"));

        System.out.print("Inorder traversal of the given tree is: ");
        bst.printInOrder();
        System.out.println();

        System.out.print("Preorder traversal of the given tree is: ");
        bst.printPreOrder();
        System.out.println();

        System.out.print("Postorder traversal of the given tree is: ");
        bst.printPostOrder();
        System.out.println();

        bst.delete(20);

        System.out.print("Inorder traversal of the given tree is: ");
        bst.printInOrder();
        System.out.println();

    }
}
