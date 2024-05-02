import java.util.*;
public class Snowflake {
    public static void main(String[] args) throws Exception {
        for(int x = 1; x <= 60;x++)
            System.out.println(printThis(x));
    }
   public static String printThis(int n){
        if(n ==1)
            return "*";
        if(n == 2)
            return "**";
        return "<"+printThis(n-2)+">";
    }
   public static double sumReciprocals(int n){
        if(n == 1)
            return 1.0;
        return (double) 1/n + sumReciprocals(n-1);
    }
    public static int productOfEvens(int n){
        if(n == 1)
            return 2;
        return productOfEvens(n-1)*n*2;
    }
    public static String conversion(int num, int base){
        if(num < base)
            return String.valueOf(num);
        return conversion(num/base, base)+num%base;
    }
    public static int matchingDigits(int a , int b){
        if(a < 10){
            if(a%10 == b%10)
                return 1;
            return 0;
    }
        if(b < 10){
            if(a%10 == b%10)
                return 1;
            return 0;
    }
        if(a%10 == b%10)
            return matchingDigits(a/10, b/10) +1;

        return matchingDigits(a/10, b/10);
    }
    public static Stack<Integer> doubleUp(Stack<Integer> nums){
        if(nums.size() == 0)
            return nums;
        ;
        int x = nums.pop();
        doubleUp(nums);
        nums.push(x);
        nums.push(x);
        return nums;
    }
}