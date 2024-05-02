import java.io.*;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;
@SuppressWarnings({"rawtypes","unchecked"})
public class HuffmanTree {
    Node root;
    HashMap<Character, String> paths = new HashMap<>();
    HuffmanTree(int [] counts) throws FileNotFoundException{
        root = null;
        PriorityQueue<Node> forest = new PriorityQueue<>();
        for(int i = 0; i < counts.length;i++)
            if(counts[i] > 0) forest.add(new Node<>((char) i, counts[i]));
        forest.add(new Node((char)256, 1)); 
        buildTree(forest);
        root = forest.poll();
        TreePrinter tp = new TreePrinter();
        tp.printTree(root);
    }
    void buildTree(PriorityQueue<Node> forest){
        if(forest.size() > 1){
            Node tree = new Node (null, 0);
            tree.left = forest.poll();
            tree.right = forest.poll();
            tree.weight = tree.left.weight+tree.right.weight;
            forest.add(tree);
            buildTree(forest);
        }
    }
    HuffmanTree(String codeFile) throws FileNotFoundException{
        Scanner sc = new Scanner(new File(codeFile));
        root = new Node (null, 0);
        while(sc.hasNextLine()){
            Node temp = root;
            int val = sc.nextInt();
            sc.nextLine();
            String code = sc.nextLine();
            for(int i = 0; i < code.length();i++){
                if(code.charAt(i) == '0'){ 
                    if(temp.left == null) temp.left = new Node();
                    temp = temp.left;
                }
                else{
                    if(temp.right == null) temp.right = new Node();
                    temp = temp.right;
                }
            }
            temp.val = (char) val;
        }
        sc.close();
    }
    void write(String fileName) throws FileNotFoundException{
        paths = new HashMap<>();
        PrintWriter pw = new PrintWriter(new File(fileName));
        writeHelper(pw, root, "");
        pw.close();        
    }
    void writeHelper(PrintWriter pw, Node n, String s){
        if(n.val != null){
            pw.println((int)(char)n.val+"\n" + s);
            paths.put((char) n.val, s);
        }
        else{
            writeHelper(pw, n.left, s+"0");
            writeHelper(pw, n.right, s+"1");
        }
    }
    void encode(BitOutputStream out, String fileName) throws FileNotFoundException{
      Scanner sc = new Scanner(new File(fileName));
      while(sc.hasNextLine()){
        String s = sc.nextLine();
        if(sc.hasNextLine()) s+="\n";
        for(int i = 0; i < s.length();i++){
            String huff = paths.get(s.charAt(i));
            for(int j = 0; j < huff.length();j++) out.writeBit(huff.charAt(j)-48);
        }
      }
      sc.close();
      String huff = paths.get((char) 256);
      for(int j = 0; j < huff.length();j++) out.writeBit(huff.charAt(j)-48);
      out.close();
    }
    void decode(BitInputStream in, String outFile) throws FileNotFoundException{
        PrintWriter pw = new PrintWriter(new File(outFile));
        Node temp = root;
        while(true){
            temp = (in.readBit() == 0) ? temp.left : temp.right;  
            if(temp.val!= null){
                if((char) temp.val == (char) 256) break;
                pw.print(temp.val);
                temp = root;
            }
        }
        pw.close();
    }
}