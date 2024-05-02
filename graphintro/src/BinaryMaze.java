import java.util.HashSet;
import java.util.Scanner;
import java.util.Queue;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
public class BinaryMaze {
    private static class Node{
        ArrayList<Node> al;
        int path;
        int val;
        Node(int val){
            this.val = val;
            al = new ArrayList<>();
            this.path = 0;
        }
    }
    public static void main(String [] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("maze.dat"));
        int R = sc.nextInt();
        int C = sc.nextInt();
        int T = sc.nextInt();
        Node [][] maze = new Node[R][C];
        for(int r = 0; r < R;r++){
            sc.nextLine();
            for(int c = 0; c < C;c++){
                maze[r][c] = new Node(sc.nextInt()); // create nodes
            }
        }
        // connect node
        for(int r = 0; r < R;r++){
            for(int c = 0; c < C;c++){
                if(-1 < r-1 && maze[r-1][c].val == 1) maze[r][c].al.add(maze[r-1][c]);
                if(-1 < c-1 && maze[r][c-1].val == 1) maze[r][c].al.add(maze[r][c-1]);
                if(r+1 < R && maze[r+1][c].val == 1) maze[r][c].al.add(maze[r+1][c]);
                if(c+1 < C && maze[r][c+1].val == 1) maze[r][c].al.add(maze[r][c+1]);
            }
        }
        while(T --> 0){
            sc.nextLine();
            Node start = maze[sc.nextInt()] [sc.nextInt()];
            Node end = maze[sc.nextInt()] [sc.nextInt()];
            int ans = path(start, end);
            System.out.println(ans);
        }
    }
    static int path (Node start, Node end){
        Queue<Node> path = new LinkedList<>();
        HashSet<Node> visited = new HashSet<>();
        path.add(start);
        start.path = 0;
        int ans = Integer.MAX_VALUE;
        while(!path.isEmpty()){
            int c = path.peek().path+1;
            for(Node n : path.poll().al){
                if(n.equals(end)) ans = Math.min(c, ans);
                if(!visited.contains(n)){
                    path.add(n);
                    n.path = c;
                    visited.add(n);
                }
            }
        }
        return (ans!= Integer.MAX_VALUE) ? ans : -1;
    }
}