import java.util.*;
public class narrowartgallery{
    static int[][] gallery; //contains all room vals
    static Integer[][][] dp; // where the magic happens
    static ArrayList<Integer> pathRight;
    static ArrayList<Integer> pathLeft;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

            int sum = 0;
            gallery = new int[n][2];
            pathLeft = new ArrayList<>();
            pathRight = new ArrayList<>();
            //fill galary and calculate sum
            for(int x = 0; x < n;x++){
                // sc.nextLine();
                gallery[x][0] = sc.nextInt();
                gallery[x][1] = sc.nextInt();
                sum+=gallery[x][0]+gallery[x][1];
                // System.out.println(Arrays.toString(gallery[x]));
            }
            if(n == 0 && k == 0)
            System.out.println(sum);
            else{
            dp = new Integer[k+1][n][2];
            int l = solveLeft(k, 0, 0);
            int r = solveRight(k, 0, 1);

            System.out.println(sum-Math.min(l, r));
            if(l < r)
                System.out.println(pathLeft);
            else 
                System.out.println(pathRight);
            }
        
    }
    static Integer solveLeft(int k, int r, int c){
        if(k == 0) // no  rooms need to be closed.
            return 0;
        if(r == gallery.length) // if out of bounds
            return 1000000;
            
        if(dp[k][r][c] != null)
            return dp[k][r][c];
        
        int room = gallery[r][c];
        
        dp[k][r][c] = Math.min(solveLeft(k-1,r+1,c) + room, Math.min(solveLeft(k,r+1,0), solveLeft(k,r+1,1)));
        if(r+1 < gallery.length&& dp[k][r][c] < dp[k][r+1][0] &&dp[k][r][c] < dp[k][r+1][1])
            pathLeft.add(gallery[r][c]);
        return dp[k][r][c];
        
        
        
    }
       static Integer solveRight(int k, int r, int c){
        if(k == 0) // no  rooms need to be closed.
            return 0;
        if(r == gallery.length) // if out of bounds
            return 1000000;
            
        if(dp[k][r][c] != null)
            return dp[k][r][c];
        
        int room = gallery[r][c];
        
        dp[k][r][c] = Math.min(solveRight(k-1,r+1,c) + room, Math.min(solveRight(k,r+1,0), solveRight(k,r+1,1)));
        if(r+1 < gallery.length&& dp[k][r][c] < dp[k][r+1][0] &&dp[k][r][c] < dp[k][r+1][1])
            pathRight.add(gallery[r][c]);
        return dp[k][r][c];
        
        
        
    }
}