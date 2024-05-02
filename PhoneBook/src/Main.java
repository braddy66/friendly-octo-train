import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
public class Main {
    static int [][] act;
    static int [] [] dp;
    static int N;
    public static void main(String [] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        N = Integer.parseInt(r.readLine());
        act = new int[3][N];
        dp = new int[3][N];
        for(int i = 0; i < N;i++){
            StringTokenizer st = new StringTokenizer(r.readLine());
            for(int j = 0; j < 3; j++) act[j][i] = Integer.parseInt(st.nextToken());
        }
        r.close();
        for(int x = 0; x < 3; x++) dp[x][0] = act[x][0];
        pw.println(Math.max(Math.max(solve(N-1,0), solve(N-1, 1)), solve(N-1,2)));
        pw.close();
    }
    static int solve(int day, int a){
        // if(dp[(a+1)%3][day] != 0 && dp[(a+2)%3][day]!= 0)
        //     return Math.max(dp[(a+1)%3][day], dp[(a+2)%3][day]);
        if(dp[a][day] != 0) return dp[a][day];
        dp[a][day] = Math.max(solve(day-1, (a+1)%3), solve(day-1, (a+2)%3))+act[a][day];
        return dp[a][day];
    }
}