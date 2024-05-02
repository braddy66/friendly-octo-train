import java.io.FileNotFoundException;
import java.util.Arrays;
public class Runner {
    public static void main(String[] args) throws FileNotFoundException {
        WelcomeBack w = new WelcomeBack();
        System.out.println(w.getMiddle("idk"));
        System.out.println(Arrays.toString(w.sumNumbers(5)));
        System.out.println(w.sumDigitsRecur(234));
        System.out.println(w.keepSumminDigits(29));
        System.out.println(w.getIntersection(new int[] {1,2,3,4}, new int[] {9,0,4,3,4,1}));
        System.out.println(w.mapLengths(new String[] {"a", "b", "hello", "hi", "yo", "I"}));
        System.out.println(w.buySell(new  int[] {3, 4, 3, 2, 1, 5} ));
        System.out.println(w.sumWithoutCarry(861, 450));
        w.zeck("zeck.txt");
    }
}
