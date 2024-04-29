import java.util.LinkedList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {
    int x;
    int y;
    int ID;
    List<Vertex> edges;
    boolean visited;
    double distance;

    Vertex(int ID, int x, int y) {
        this.x = x;
        this.y = y;
        this.ID = ID;
        edges = new LinkedList<>();
        distance = Double.POSITIVE_INFINITY;
    }

    double distance(Vertex other) {
        return Math.sqrt(Math.pow(other.x - this.x, 2) + Math.pow(other.y - this.y, 2));
    }

    public String toString() {
        return "ID: " + ID + " (dist: " + distance + ")";
    }

    @Override
    public int compareTo(Vertex o) {
        return (int) Double.compare(this.distance, o.distance);
    }
}