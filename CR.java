public class CR{
    static class Node {
        int data;
        Node right;
        Node left;
      public  Node (int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
static class Info{
    boolean isBSt;
    int size;
    int min;
    int max;
    public Info(boolean isBSt, int size, int min, int max) {
        this.isBSt = isBSt;
        this.size = size;
        this.min = min;
        this.max = max;
    }  
}
static int maxBST =0;
public static Info largestBST(Node root) {
    if(root == null) {
        return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    Info leftInfo = largestBST(root.left);
    Info rifgtInfo = largestBST(root.right);
    int size = leftInfo.size + rifgtInfo.size +1;
    int min = Math.min(root.data, Math.min(leftInfo.min, rifgtInfo.min));
    int max = Math.max(root.data, Math.max(leftInfo.max, rifgtInfo.max));
    if(root.data <= leftInfo.max || root.data >= rifgtInfo.min) {
        return new Info(false, size, min, max);
    }
    if(leftInfo.isBSt && rifgtInfo.isBSt) {
        maxBST = Math.max(maxBST, size);
        return new Info(true, size, min, max);
    }
    return new Info(false, size, min, max);
}



public static int minDiff(Node root, int k) {
    if((root.left == null && root.right == null) || root.data == k) {
        return Math.abs(root.data -k);
    }
    if(root.data > k) {
       return minDiff(root.left, k);
    }
    else {
        return minDiff(root.right, k);
    }
    
}









     public static void main(String[] args) {
    //     Node root = new Node(50) ;
    //    root.left = new Node(30);
    //    root.left.left = new Node(5);
    //    root.left.right = new Node(20);
    //    root.right = new Node(60);
    //    root.right.left =new Node(45);
    //    root.right.right = new Node(70);
    //    root.right.right.left = new Node(65);
    //    root.right.right.right = new Node(80);
    //    Info info = largestBST(root);
    //    System.out.println("Max BST size is :" + maxBST);
    Node root = new Node(8);
    root.left = new Node(5);
    root.left.left = new Node(3);
    root.left.right = new Node(6);
    root.right = new Node(11);
    root .right.right = new Node(20);
    System.out.println(minDiff(root, 19));


    }
}