import java.util.Scanner;

public class NAG{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in());
        int n = sc.nextInt();
        int k = sc.nextInt();
        int [][] gallary = new int[n][2];
        for(int x = 0; x < n;x++){
            gallary[x][0] = sc.nextInt();
            gallary[x][1] = sc.nextInt();
        }
        for(int[] arr : gallary){
            SolveMin(arr[0],k,gallary);
        }
    }
    solveMin(int c, int k, int[][] gallary){
        for(int x = 0; x < )
    }

}