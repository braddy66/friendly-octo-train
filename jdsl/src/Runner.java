import java.util.Arrays;
import java.util.LinkedList;
public class Runner {
    public static void main(String[] args) {
        QueueProbs qp = new QueueProbs();
        System.out.println(qp.evenFirst(makeList(new int[] {3,5,4,17,6,83,1,84,16,37})));
        System.out.println(qp.numPalindrome(makeList(new int[] {3,8,17,9,17,8,3})));
        System.out.println(qp.numPalindrome(makeList(new int[] {3,10,17,9,17,8,3})));

    }
    static LinkedList makeList(int[] arr){
        LinkedList l = new LinkedList<>();
        for(int i : arr)
            l.add(i);
        return l;
    }
}