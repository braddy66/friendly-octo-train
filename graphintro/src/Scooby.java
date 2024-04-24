import java.util.HashSet;
import java.util.Scanner;
import java.util.HashMap;
import java.io.File;
import java.util.ArrayList;
public class Scooby {
    private static HashSet<Node> visited;
    private static class Node{
        ArrayList<Node> al;
        char c;
        Node(char c ){
            this.c = c;
            al = new ArrayList<>();
        }
        public String toString(){
            return c+"";
        }
    }
    public static void main(String[] args) throws Exception {
        File f = new File("scooby.dat");
        HashMap<Character, Node> hm = new HashMap<>();
        Scanner sc = new Scanner(f);
        int N = sc.nextInt();
        sc.nextLine();
        while(N-- > 0){
            String s = sc.nextLine();
            int i = 0;
            while(i < s.length()){
                char x = s.charAt(i);
                i++;
                char y = s.charAt(i);
                if(!hm.containsKey(x)) hm.put(x, new Node(x));
                if(!hm.containsKey(y)) hm.put(y, new Node(y));
                hm.get(x).al.add(hm.get(y));
                i+=2;
            }
            s = sc.nextLine();
            Node start = hm.get(s.charAt(0));
            Node end = hm.get(s.charAt(1));
            visited = new HashSet<>(); 
            if(path(start, end)) System.out.println("yes");
            else System.out.println("no");
        }
    }
    static boolean path(Node x, Node y){
        if(x.equals(y)) return true;
        ArrayList<Node> al = x.al;
        visited.add(x);
        for(int i = al.size()-1; i > -1;i--){
            if(!visited.contains(al.get(i))){
                if(path(al.get(i), y)) return true;
            } 
            visited.add(al.get(i));
        }
        return false;
    }
}
