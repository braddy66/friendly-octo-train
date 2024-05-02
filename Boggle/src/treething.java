

public class treething{
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(4);
        root.left.left = new Node(3);
        preOrder(root); 
    }
    public static void preOrder(Node root){
    if(root == null) return;
    System.out.println(root.val);
    preOrder(root.left);
    preOrder(root.right);
    }
}
class Node{
    Node left;
    Node right;
    int val;
    public Node(int val){
        this.val = val;
    }
}