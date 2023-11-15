import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class theBetterOne {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter length: ");
        int[] arr = new int[s.nextInt()];
        s.nextLine();
        System.out.println();
        System.out.print("Enter array: ");

        for(int x = 0; x < arr.length;x++)
            arr[x] = s.nextInt();

        // System.out.println("Longest Increasing Subsequence Length " + Lis(arr));
        System.out.println(Arrays.toString(LisArray(arr)));
    }
    // public static int Lis(int [] arr){
    //     int[] LIS = new int[arr.length];
    //     LIS[0] = 1;
    //     for(int i= 1; i < arr.length;i++){
    //         LIS[i] = LIS[i-1];
            
    //         for(int j = i-1; j > -1;j--)
    //             if(arr[j] < arr[i])
    //             LIS[i] = Math.max(LIS[i], LIS[j] +1);
    //             }
    //         // if(LIS[i] == 1)
    //         //     LIS[i] = LIS[i-1];
    //         // System.out.println(Arrays.toString(LIS));
        
    //     return LIS[arr.length-1];
    // }
    public static Integer[] LisArray(int[] arr){
        int[] LIS = new int[arr.length];
        LIS[0] = 1;
        Integer last = Integer.MIN_VALUE; 
        HashSet<Integer> al= new HashSet<>();
        for(int i= 1; i < arr.length;i++){
            LIS[i] = LIS[i-1];
            
            for(int j = i-1; j > -1;j--){
                    LIS[i] = Math.max(LIS[i], LIS[j] +1);
                    al.add(arr[j]);
                    last = arr[i];
                    break;
                }
            // System.out.println(Arrays.toString(LIS));
        }
        al.add(last);
        
        return al.toArray(new Integer[0]);
    }
}