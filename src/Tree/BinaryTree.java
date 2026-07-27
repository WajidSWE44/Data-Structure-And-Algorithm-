package Tree;

public class BinaryTree {
    Object root;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree(Object root){
        this.root = root;

    }
    public BinaryTree(Object root, BinaryTree left,BinaryTree right){
        this.root = root;
        this.left = left;
        this.right = right;
    }
    public Object getroot(){
        return root;
    }
    public BinaryTree getLeft(){
        return left;
    }
    public BinaryTree getright(){
        return right;
    }
    public void setroot(Object root){
        this.root = root;
    }
    public void setLeft(BinaryTree left){
        this.left = left;
    }
    public void setRight(BinaryTree right){
        this.right = right;
    }
    
    //Pre-Order-Traverse
    public String Pre_orderTraverse(){
        StringBuffer buf = new StringBuffer(" ");
        buf.append(root);
        if(left!=null)
            buf.append(left);

        if(right!=null)
            buf.append(right);
        return buf +" ";
    }
    //In-OrderTraverse
    public String In_orderTraverse() {
        StringBuffer buf = new StringBuffer(" ");

        if (left != null)
            buf.append(left.In_orderTraverse());
        buf.append(root);
        if (right != null)
            buf.append(right.In_orderTraverse());
        return buf + " ";
    }
    //Post-OrderTraverse
    public String Post_orderTraverse() {
        StringBuffer buf = new StringBuffer(" ");

        if (left != null)
            buf.append(left.Post_orderTraverse());
        if (right != null)
            buf.append(right.Post_orderTraverse());
        buf.append(root);
        return buf + " ";
    }

    //Check the leaf
    public boolean isleaf(){
        if(this.left==null && this.right==null)
            return true;
        else
            return false;
    }

    //Size of tree
    public int size(){
        if(left==null && right==null){
            return 1;
        }
        if(left==null){
            return 1+ right.size();
        }
        if(right==null){
            return 1+ left.size();
        }
        return 1+ left.size()+ right.size();
    }

    public int height() {
        if (left == null && right == null) {
            return 1; // Leaf node has height 1
        }
        if (left == null) {
            return 1 + right.height(); // Only right subtree exists
        }
        if (right == null) {
            return 1 + left.height(); // Only left subtree exists
        }
        return 1 + Math.max(left.height(), right.height()); // Both subtrees exist, take the max height
    }


    public boolean isFull() {
        if (this == null || root == null) {
            return true;
        }
        if (left == null && right == null) {
            return true; // Leaf node
        }
        if (left != null && right != null) {
            return left.isFull() && right.isFull(); // Both children exist
        }
        return false; // One child is missing
    }

    public boolean contains(char search){
        String str = Post_orderTraverse();
        for(int i = 0; i<str.length();i++){
            if(str.charAt(i) == search){
                return true;
            }
        }return false;

    }

    public int numberOfLeaves() {
        if (isleaf()) {
            return 1;
        }

        int count = 0;
        if (left != null) {
            count += left.numberOfLeaves();
        }
        if (right != null) {
            count += right.numberOfLeaves();
        }
        return count;
    }

    public static void main(String[] args) {
        BinaryTree D = new BinaryTree("D");
        BinaryTree E = new BinaryTree("E");
        BinaryTree F = new BinaryTree("F");
        BinaryTree B = new BinaryTree("B",D,null);
        BinaryTree C = new BinaryTree("C",E,F);
        BinaryTree A = new BinaryTree("A",B,C);

        System.out.println("Pre_order_Traverse\n"+A.Pre_orderTraverse());// A B D   C E  F
        System.out.println("In_Order_Traverse\n"+A.In_orderTraverse());//   D B A  E C F
        System.out.println("Post_Order_Traverse\n"+A.Post_orderTraverse());//   D B   E  F C A

        System.out.println(D.isleaf());

        System.out.println("Size "+A.size());
        System.out.println("Height "+A.height());

        //search in tree D
        System.out.println("CHECK D IS PRESENT IN TREE :"+A.contains('D'));
        System.out.println("CHECK Z IS PRESENT IN TREE :"+A.contains('Z'));
        System.out.println(A.isleaf());
        System.out.println(A.numberOfLeaves());


    }
}
