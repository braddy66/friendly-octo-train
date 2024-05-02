import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TriangleTask {
    public static void main(String [] args) throws IOException {
        Scanner console = new Scanner(System.in);
        // char letter = console.next().charAt(0);
        // int num = Integer.parseInt(console.next());
        // System.out.println(letter + " " + num);

        int t = console.nextInt();
        for(int i = 0; i < t; i++)
        {
            long x = console.nextLong() * console.nextLong();
            long add = console.nextLong();
            long max = console.nextLong();
            long ret = 0;

            while(x < max)
            {
                x += add;
                if(x <= max) ret++;
            }
            System.out.println(ret);
        }
    }
}
