import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Runner {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("Text Files/Hamlet.txt");
        Scanner sc = new Scanner(f);
        
        while(sc.hasNext()){
            String s = sc.nextLine();
        int [] counts = new int[256];
        for(int i = 0; i < s.length();i++) counts[s.charAt(i)]++;
        HuffmanTree ht = new HuffmanTree(counts);
        ht.write("urmom.code");
        ht.encode(new BitOutputStream("Text Files/Short.txt"), "Text Files/Hamlet.txt");
        System.out.println((int) ((char) 256));
        }
        // ht.write();
    }
}