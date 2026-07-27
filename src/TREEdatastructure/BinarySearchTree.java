package TREEdatastructure;

class BinarySearchTree {
    // Node class to represent a node in the BST
    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Root node of the BST
    Node root;

    // Constructor to initialize an empty BST
    BinarySearchTree() {
        root = null;
    }

    // Public method to insert a new value
    void insert(int value) {
        root = insertRec(root, value);
    }

    // Recursive method to insert a new value into the BST
    Node insertRec(Node node, int value) {
        if (node == null) {
            node = new Node(value);
            return node;
        }
        if (value < node.data) {
            node.left = insertRec(node.left, value);
        } else if (value > node.data) {
            node.right = insertRec(node.right, value);
        }
        return node;
    }

    // Public method to search for a value
    boolean search(int value) {
        return searchRec(root, value) != null;
    }

    // Recursive method to search for a value in the BST
    Node searchRec(Node node, int value) {
        if (node == null || node.data == value)
            return node;

        if (value < node.data)
            return searchRec(node.left, value);

        return searchRec(node.right, value);
    }

    // Public method to delete a value
    void delete(int value) {
        root = deleteRec(root, value);
    }

    // Recursive method to delete a value from the BST
    Node deleteRec(Node node, int value) {
        if (node == null)
            return node;

        if (value < node.data)
            node.left = deleteRec(node.left, value);
        else if (value > node.data)
            node.right = deleteRec(node.right, value);
        else {
            // Node with one or no child
            if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;

            // Node with two children, get the inorder successor (smallest in the right subtree)
            node.data = minValue(node.right);

            // Delete the inorder successor
            node.right = deleteRec(node.right, node.data);
        }
        return node;
    }

    // Utility method to find the minimum value node in the subtree
    int minValue(Node node) {
        int minValue = node.data;
        while (node.left != null) {
            minValue = node.left.data;
            node = node.left;
        }
        return minValue;
    }

    // Method to print inorder traversal of the tree
    void inorder() {
        inorderRec(root);
    }

    // Recursive method for inorder traversal
    void inorderRec(Node node) {
        if (node != null) {
            inorderRec(node.left);
            System.out.print(node.data + " ");
            inorderRec(node.right);
        }
    }

    // Method to print Preorder traversal of the tree
    void Preorder() {
        PreorderRec(root);
    }
    void PreorderRec(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            PreorderRec(node.left);
            PreorderRec(node.right);
        }
    }

    // Method to print Postorder traversal of the tree
    void Postorder() {
        PostorderRec(root);
    }
    void PostorderRec(Node node) {
        if (node != null) {
            PostorderRec(node.left);
            PostorderRec(node.right);
            System.out.print(node.data + " ");
        }
    }
    int height() {
     int height =   height(root);
     return height;
    }
    public int height(Node node) {
        if (node != null) {
            int  leftheight = height(node.left);
            int rightheight = height(node.right);
            return Math.max(leftheight, rightheight) + 1;
        }
        return 0;
    }



    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Inserting values
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        // Inorder traversal of the BST
        System.out.println("Inorder traversal:");
        bst.inorder();  // Output: 20 30 40 50 60 70 80
        System.out.println();

        System.out.println("Preorder Traversal:");
        bst.Preorder();
        System.out.println();

        System.out.println("Postorder Traversal:");
        bst.Postorder();
        System.out.println();

        System.out.println("Tree Height:"+bst.height());

        // Searching for a value
        //System.out.println("\nSearch 40: " + bst.search(40));  // Output: true

        // Deleting a value
        //bst.delete(40);
        //System.out.println("Inorder traversal after deleting 40:");
        //bst.inorder();  // Output: 20 30 50 60 70 80
    }
}
