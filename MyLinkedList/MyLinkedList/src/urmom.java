import java.util.*;

public class urmom 
{
    public static void main(String[] args) 
    {
        String s = "abc";
        perms(s.toCharArray(), 0);
    }

    private static void perms(char[] arr, int startInd)
    {
        if(startInd == arr.length) 
        {
            System.out.println(new String(arr));
            return;
        }
        
        for(int i = startInd; i < arr.length; i++)
        {
            swap(arr, startInd, i);
            perms(arr, startInd + 1);
            swap(arr, startInd, i);
        }
    }

    private static void swap(char[] arr, int a, int b)
    {
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
