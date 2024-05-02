import java.util.PriorityQueue;

public class Dijkstra {
    Graph g;

    Dijkstra(Graph g) {
        this.g = g;
    }

    double distance(int source, int destination) {
        return dijkstra(source, destination);
    }

    private double dijkstra(int from, int to) {
        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        Vertex end = g.arr[to];
        Vertex source = g.arr[from];
        source.distance = 0;
        pq.add(source);
        double ans = Double.POSITIVE_INFINITY;
        source.visited = true;
        while (!pq.isEmpty()) {
            Vertex current = pq.poll();
            System.out.println("process " + current.toString());
            for (Vertex v : current.edges) {
                if (!v.visited)
                    pq.add(v);
                v.distance = Math.min(v.distance, current.distance + current.distance(v));
                v.visited = true;
                System.out.println("lower " + v.toString());
            }
        }
        return end.distance;
    }
}
