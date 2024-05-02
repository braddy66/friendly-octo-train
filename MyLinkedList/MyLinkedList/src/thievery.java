import java.util.HashMap;

public class thievery {
    public static void main(String [] args){
        System.out.println(fibonaciMemo(4));
        System.out.println(numPaths(new int[10][10]));
    }
    static long fibonaciMemo(int n){
        HashMap<Integer, Long> hm = new HashMap<>();
        hm.put(0, 1L);
        hm.put(1, 1L);
        return fibonaciMemo(n, hm);
    }
    static private long fibonaciMemo(int n, HashMap<Integer, Long> hm) {
        if(hm.containsKey(n))
            return hm.get(n);
        long ans = fibonaciMemo(n-1, hm) + fibonaciMemo(n-2, hm);
        hm.put(n, ans);
        return ans;
    }
    static int numPaths(int [] [] grid){
       return numPaths(grid.length, grid[0].length,new Integer[grid.length][grid[0].length]);
    }
    static int numPaths(int row, int col, Integer [][] ans){
        if(row < 2)
            return row;
        if(col < 2)
            return col;

        if(ans[col-1][row-1]!= null)
            return ans[col-1][row-1];

        ans[col-1][row-1] =  numPaths(row-1, col, ans) + numPaths(row, col-1,ans);
        return ans[col-1][row-1];
    }
}
