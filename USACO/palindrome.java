import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class palindrom {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        // Read input from System.in
        int T = Integer.parseInt(r.readLine());
        while(T--> 0){
            String stones = r.readLine();
            if(stones.charAt(stones.length()-1) == '0' ) pw.println("E");
            else pw.println("B");
        }
        pw.close();
        
    }
    // public static boolean isPalindrome(String str) {
    //     if(str.length() == 1) return true;
    //     int left = 0, right = str.length() - 1;
        
    //     while(left < right)
    //     {
    //         if(str.charAt(left) != str.charAt(right))
    //         {
    //             return false;
    //         }
    //         left++;
    //         right--;
    //     }
    //     return true;
    // } 
}