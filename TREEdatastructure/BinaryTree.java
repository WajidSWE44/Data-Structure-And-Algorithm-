package TREEdatastructure;
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
    public String toString(){
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

    public static void main(String[] args) {
        BinaryTree F = new BinaryTree("F");
        BinaryTree J = new BinaryTree("J");
        BinaryTree K = new BinaryTree("K");
        BinaryTree L = new BinaryTree("L");
        BinaryTree G = new BinaryTree("G",J,null);
        BinaryTree H = new BinaryTree("H",null,K);
        BinaryTree I = new BinaryTree("I",null,L);
        BinaryTree D = new BinaryTree("D",F,G);
        BinaryTree E = new BinaryTree("E",H,I);
        BinaryTree C = new BinaryTree("C",D,E);
        BinaryTree B = new BinaryTree("B",null,null);
        BinaryTree A = new BinaryTree("A",B,C);

        System.out.println("In Order : "+A.In_orderTraverse());
        System.out.println("Pre Order : "+A.toString());
        System.out.println("Post Order : "+ A.Post_orderTraverse());

        System.out.println("IsFull " +A.isFull());
    }
}


/*
        BinaryTree D = Bnew BinaryTree("D");
        BinaryTree E = new BinaryTree("E");
        BinaryTree F = new BinaryTree("F");
        BinaryTree B = new BinaryTree("B",D,null);
        BinaryTree C = new BinaryTree("C",E,F);
        BinaryTree A = new BinaryTree("A",B,C);

        System.out.println("Pre_order_Traverse\n"+A);// A B D   C E  F
        System.out.println("In_Order_Traverse\n"+A.In_orderTraverse());//   D B A  E C F
        System.out.println("Post_Order_Traverse\n"+A.Post_orderTraverse());//   D B   E  F C A*/

        // System.out.println(D.isleaf());
        // System.out.println("Size "+A.size());
        //System.out.println("Height "+A.height());
        // System.out.println(A.isleaf());
        // System.out.println(A.numberOfLeaves());



/*


import javax.swing.plaf.nimbus.NimbusStyle;

//Practice binary tree
public class BinaryTree{
    Object root;
    BinaryTree left;
    BinaryTree right;
    public BinaryTree(Object root){
        this.root = root;
    }
    public BinaryTree(Object root,BinaryTree left,BinaryTree right){
        this.root = root;
        this.left = left;
        this.right = right;
    }
    public Object getRoot(){
        return root;
    }
    public BinaryTree getLeft(){
        return left;
    }
    public BinaryTree getRight(){
        return right;
    }
    public void setRoot(Object root){
        this.root =root;
    }
    public void setLeft(BinaryTree left){
        this.left =left;
    }
    public void setRight(BinaryTree right){
        this.right= right;
    }

    // In-Order Traversal
    public String In_Order() {
        StringBuffer buf = new StringBuffer();
        if (left != null)
            buf.append(left.In_Order() + " ");
        buf.append(root + " ");
        if (right != null)
            buf.append(right.In_Order() + " ");
        return buf.toString();
    }

    // Pre-Order Traversal
    public String Pre_Order() {
        StringBuffer buf = new StringBuffer();
        buf.append(root + " ");
        if (left != null)
            buf.append(left.Pre_Order() + " ");
        if (right != null)
            buf.append(right.Pre_Order() + " ");
        return buf.toString();
    }

    // Post-Order Traversal
    public String Post_Order() {
        StringBuffer buf = new StringBuffer();
        if (left != null)
            buf.append(left.Post_Order() + " ");
        if (right != null)
            buf.append(right.Post_Order() + " ");
        buf.append(root + " ");
        return buf.toString();
    }

    // Override toString() method to print the root value directly
    @Override
    public String toString() {
        return root.toString();
    }
   */
/* //In_OrderTraverse
    public String In_Order() {
    StringBuffer buf = new StringBuffer(" ");
    if (left != null)
        buf.append(left+" ");
        buf.append(root+" ");
    if (right != null)
        buf.append(right+" ");
    return buf +" ";
    }
    //Pre_Order Traverse
    public String Pre_Order() {
        StringBuffer buf = new StringBuffer(" ");
        buf.append(root+" ");
        if (left != null)
            buf.append(left+" ");
        if (right != null)
            buf.append(right+" ");
        return buf+" ";
    }

    //Post_Order Traverse
    public String Post_Order() {
        StringBuffer buf = new StringBuffer(" ");
        if (left != null)
            buf.append(left+" ");
        if (right != null)
            buf.append(right+" ");
        buf.append(root+" ");
        return buf+" ";
    }
*//*


    public static void main(String[] args) {
        BinaryTree rootX = new BinaryTree("x");
        BinaryTree root2 = new BinaryTree(2);
        BinaryTree rootY = new BinaryTree("y");
        BinaryTree root7 = new BinaryTree(7);
        BinaryTree rootZ = new BinaryTree("z");

        // Creating internal nodes (parent nodes)
        BinaryTree rootD = new BinaryTree("/", rootX, null);
        BinaryTree rootD1 = new BinaryTree(rootD, root2, rootY);
        BinaryTree rootS = new BinaryTree("-", root7, rootZ);
        BinaryTree rootM = new BinaryTree("*", rootD1, rootS);

        System.out.println("In_order Traverse :\n"+rootM.In_Order());
        System.out.println("Pre_order Traverse :\n"+rootM.Pre_Order());
        System.out.println("Post_order Traverse :\n"+rootM.Post_Order());

    }
}
*/












