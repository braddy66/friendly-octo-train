import java.util.Scanner;

public class Graph {
    int V;
    int E;
    Vertex[] arr;

    Graph(Scanner sc) {
        V = sc.nextInt();
        E = sc.nextInt();
        arr = new Vertex[V];
        for (int i = 0; i < V; i++) {
            sc.nextLine();
            arr[i] = new Vertex(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        while (E-- > 0) {
            sc.nextLine();
            arr[sc.nextInt()].edges.add(arr[sc.nextInt()]);
        }
    }

    public double Distance(int from, int to) {
        return arr[from].distance(arr[to]);
    }
}
