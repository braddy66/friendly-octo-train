import java.util.Scanner;

class Frog{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] stones = new int[n];
        for(int i = 0; i < n;i++)
            stones[i] = sc.nextInt();

        int [] minCost = new int[n-1]; // minimum cost to get to each stone
        minCost[0] = Math.abs(stones[0]-stones[1]);
        minCost[1] = Math.abs(stones[0]-stones[2]);
        

        for(int i = 2; i < n-1;i++){
            minCost[i] = Math.min(minCost[i-1] +  Math.abs(stones[i+1]- stones[i]),minCost[i-2] + Math.abs(stones[i+1]-stones[i-1]));
        }
        System.out.println(minCost[n-2]);
    }
    
}