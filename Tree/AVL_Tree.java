package Tree;

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

    public String toString() {
        if (this == NIL) return " ";
        return left + " " + key + " " + right;
    }

    public boolean add(int k) {
        int oldsize = size();
        grow(k);
        return size() > oldsize;
    }

    public AVL_Tree grow(int key) {
        if (this == NIL) return new AVL_Tree(key);
        if (key == this.key) return this;
        if (key < this.key) left = left.grow(key);
        else right = right.grow(key);

        //rebalance();
        height = 1 + Math.max(left.height, right.height);
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
        AVL_Tree avl = new AVL_Tree();
        avl.grow(55);
        avl.grow(22);
        avl.grow(77);
/*        avl.grow(44);
        avl.grow(70);
        avl.grow(18);
        avl.grow(88);
        avl.grow(30);
        avl.grow(94);
        avl.grow(80);
        avl.grow(60);
        avl.grow(74);
        avl.grow(66);*/
        avl.toString();
    }
}
