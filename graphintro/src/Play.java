import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
public class Play {
    private static class Node{
        ArrayList<Node> al;
        int val;
        Node(int val){
            this.val = val;
            al = new ArrayList<Node>();
        }
    }
    public static void main(String [] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("play.dat"));
        int T = sc.nextInt();
        while(T --> 0){
            sc.nextLine();
            int n = sc.nextInt();
            int m = sc.nextInt();
            int l = sc.nextInt();
            Node [] arr = new Node[n+1];
            while(m --> 0){
                sc.nextLine();
                int x = sc.nextInt();
                int y = sc.nextInt();
                if(arr[x] == null) arr[x] = new Node(x);
                if(arr[y] == null) arr[y] = new Node(y);
                arr[x].al.add(arr[y]);
            }
            HashSet<Node> fallen = new HashSet<>();
            int ans = 0;
            while(l --> 0){
                sc.nextLine();
                ans+=sim(arr[sc.nextInt()], fallen);
            }
            System.out.println(ans);
        }
    }
    public static int sim(Node start, HashSet<Node> fallen){
        int count = 0;
        Stack<Node> st = new Stack<>();
        st.add(start);
        while(!st.isEmpty()){
            count++;
            fallen.add(st.peek());
            for(Node n : st.pop().al){
                if(!fallen.contains(n)) st.add(n);
            }
        }
        return count;
    }
}