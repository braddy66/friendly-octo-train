public class Node<T> implements Comparable<Node<T>> {
    Node<T> left, right;
    T val; // character 
    int weight;
    Node (T val, int weight){
        this.val = val;
        this.weight = weight;
    }
    Node(){
        this(null, 0);
    }
    public int compareTo(Node<T> other){
        return  weight-other.weight;
    }
    @Override
    public String toString() {
        return (val != null) ? val+"" : weight+"";
    }  
}