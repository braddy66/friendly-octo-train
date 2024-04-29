import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Tester {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("grid10x10.txt"));
        Dijkstra d = new Dijkstra(new Graph(sc));
        long start = System.currentTimeMillis();
        System.out.println(d.distance(sc.nextInt(), sc.nextInt()));
        System.out.println(System.currentTimeMillis() - start);
    }
}
