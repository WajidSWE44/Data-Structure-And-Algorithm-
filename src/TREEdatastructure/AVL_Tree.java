package TREEdatastructure;

public class AVL_Tree {
    private int key, height;
    private AVL_Tree left, right;

    public static final AVL_Tree NIL = new AVL_Tree();

    private AVL_Tree() {
        left = right = this;
        height = -1;
    }

    private AVL_Tree(int key, AVL_Tree left, AVL_Tree right) {
        this.key = key;
        this.left = left;
        this.right = right;
        height = 1 + Math.max(left.height, right.height);
    }

    public AVL_Tree(int key) {
        this.key = key;
        left = right = NIL;
    }

    public int size() {
        if (this == NIL) return 0;
        return 1 + left.size() + right.size();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public String toString() {
        if (this == NIL) return " ";
        return key + " " + left + " " + right ;//Pre_Order
        // return left + " " + key + " " + right ;//In_Order
        //return left + " " + right + " " + key ;//Post_Order
    }

    public boolean add(int k) {
        int oldsize = size();
        grow(k);
        return size() > oldsize;
    }

    public AVL_Tree grow(int key) {
        if (this == NIL) return new AVL_Tree(key);  // Create a new node if this is NIL
        if (key == this.key) return this;  // If the key is already present, return the current node
        if (key < this.key)
            left = left.grow(key);// Insert in the left subtree
        else
            right = right.grow(key);// Insert in the right subtree

        // Recalculate the height of the current node after the insertion
        height = 1 + Math.max(left.height, right.height);
        rebalance();// Perform the rebalancing (if needed)
        return this;
    }


    private void rebalance() {
        if (right.height > left.height + 1) {
            if (right.left.height > right.right.height) {
                right.rotateRight();
                rotateLeft();
            }
        } else if (left.height > right.height + 1) {
            if (left.right.height > left.left.height)
                left.rotateLeft();
            rotateRight();
        }
    }

    private void rotateLeft() {
        left = new AVL_Tree(key, left, right.left);
        key = right.key;
        right = right.right;
    }

    private void rotateRight() {
        right = new AVL_Tree(key, left.right, right);
        key = left.key;
        left = left.left;
    }

    public static void main(String[] args) {
        AVL_Tree avl = new AVL_Tree(40);
        avl.add(55);
        avl.add(22);
        avl.add(77);
        avl.add(44);
        avl.add(70);
        avl.add(18);
        avl.add(88);
        avl.add(30);
        avl.add(94);
        avl.add(80);
        avl.add(60);
        avl.add(74);
        avl.add(66);

        System.out.println(avl);

        System.out.println(avl.size());


    }
}
