public class MyBST {
    private Node root;
    private int size;
    private class Node{
        Integer val;
        Node left;
        Node right;
        Node(Integer val){
            this.val = val;
            left = null;
            right = null;
        }
    }
    MyBST(){
        root = null;
    }
    int size(){
        return sizeHelper(root);
    }
    int sizeBetter(){
        return size;
    }

    int sizeHelper(Node current){
        if(current == null) return 0;
        return sizeHelper(current.left)+sizeHelper(current.right)+1;
    }
    void insert(Integer n){
        root = insertHelper(n, root);
        size++;       
    }
    Node insertHelper(Integer n, Node current){
        if(current == null) return new Node(n) ;
        if(n < current.val) current.left = insertHelper(n, current.left); // branch left 
        else if(n > current.val) current.right = insertHelper(n, current.right); // branch right 
        return current;
    }
    void print(){
        printHelper(root, "");
    }
    void printHelper(Node current, String tabs){
        if(current == null) return;
        printHelper(current.right, tabs+"\t");
        System.out.print(tabs);
        System.out.println(current.val);
        printHelper(current.left, tabs+"\t");
    }
    boolean contains(Integer n){
        return containsHelper(root,n);
    }
    boolean containsHelper(Node current,Integer n){
        if(current == null)  return false;
        return (current.val == n) ? true : (current.val > n) ? containsHelper(current.left, n): containsHelper(current.right, n); 
    }
    void inOrder(){
        inOrderHelper(root);
        System.out.println();
    }
    void inOrderHelper(Node current){
        if(current == null) return;
        inOrderHelper(current.left);
        System.out.print(current.val +" ");
        inOrderHelper(current.right);
    }
    Integer getMin(){
        if(root == null) return -1;
        return getMinHelper(root);
    }
    Integer getMinHelper(Node current){
        return (current.left == null ) ? current.val : getMinHelper(current.left);
    }
    Integer getMax(){ 
        if(root == null) return -1;
        return getMaxHelper(root);
    }
    Integer getMaxHelper(Node current){
        return (current.right == null) ? current.val : getMaxHelper(current.right);
    }
    void delete(Integer n){
         if(Math.random()*2 == 0) root = deleteHelper(root, n);
         else deleteHelperVoid(null, root, n);
    }
    Node deleteHelper(Node current, int target){
        if(current == null) return null;
        if(current.val < target) current.right = deleteHelper(current.right, target);
        else if(current.val > target) current.left = deleteHelper(current.left, target);
        else{ //bypass and delete
            size--;
            Node successor = null;
            if(current.right == null) successor = current.left; 
            else if(current.left == null) successor = current.right;
            else{// replace with successor
                Node successorParent = current.right;
                if(successorParent.left == null) successor = successorParent;
                else {
                    while(successorParent.left.left != null) successorParent = successorParent.left;
                    successor = successorParent.left; 
                    successorParent.left = successor.right; //delete successor from the bottom
                    //attatch succesor right
                    successor.right = current.right;
                }
                successor.left = current.left;
            }            
            return successor;
        }
        return current;
    }
    void deleteHelperVoid(Node parent, Node current, int target){
        if(current == null) return;
        if(current.val < target) deleteHelperVoid(current, current.right, target);
        else if(current.val > target) deleteHelperVoid(current, current.left, target);
        else{
            size--;
            Node successor = null;
            if(current.right == null) successor = current.left; 
            else if(current.left == null) successor = current.right;
            else{// replace with successor
                Node successorParent = current.right;
                if(successorParent.left == null) successor = successorParent;
                else {
                    while(successorParent.left.left != null) successorParent = successorParent.left;
                    successor = successorParent.left; 
                    successorParent.left = successorParent.left.right; //delete successor from the bottom
                    successor.right = current.right; // assign succesor right branch
                }
                if(successor!= null) successor.left = current.left; // assign succesor left branch
            }
            //attacth succesor to tree
            if(parent == null) root = successor;
            else if(parent.left == current) parent.left = successor;
            else parent.right = successor;    
        }
    }
}