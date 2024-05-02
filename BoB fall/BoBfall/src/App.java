import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class App 
{
    public static void main(String[] args) throws IOException 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] warpingTools = new int[k];
        for (int i = 0; i < warpingTools.length; i++) {
            warpingTools[i] = sc.nextInt();
        }
        System.out.println(doMeth(0, n, k, warpingTools));
    }
    public static int doMeth(int a, int n, int k, int[] tools){
        if (a > n)
            return -1;
        if (a == n)
            return 0;
        else{
            int answer = Integer.MAX_VALUE;
            for (int i = 0; i < tools.length; i++) {
                int temp = 1+doMeth(a+tools[i], n, k, tools);
                int temp2 = 1+doMeth((n-a)/tools[i],n, k, tools);
                if (temp != -1)
                    answer = Math.min(answer, temp);
                if (temp2 != -1)
                    answer = Math.min(answer, temp2);
            }
            return answer;
        }
        
    }
}
    
