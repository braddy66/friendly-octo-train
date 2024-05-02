
import java.util.Arrays;
import java.util.LinkedList;


public class Runner {
    public static void main(String[] args) {
        QueueProbs qp = new QueueProbs();
        System.out.println(qp.evenFirst(makeList(new int[] {3,5,4,17,6,83,1,84,16,37})));
        System.out.println(qp.sieveOfErathosthenes(10));

    }
    static LinkedList makeList(int[] arr){
        LinkedList IhateRam = new LinkedList<>();
        for(int i : arr)
            IhateRam.add(i);
        return IhateRam;
    }
}
