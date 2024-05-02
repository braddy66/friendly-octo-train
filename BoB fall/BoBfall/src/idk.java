import java.util.Scanner;

class idk{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean x = sc.nextBoolean();
        boolean y = sc.nextBoolean();
        boolean z = sc.nextBoolean();
        
        for(int x = 0; x < 8; x++){
            if((x && !y) && (y || z) || (!x || y)){
            System.out.println("doing something");
            }
        }
    }
}