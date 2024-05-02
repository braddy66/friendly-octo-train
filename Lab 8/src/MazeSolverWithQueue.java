import java.util.Arrays;

public class MazeSolverWithQueue extends MazeSolver{
    MyQueue<Square> queue;

    MazeSolverWithQueue(Maze maze) {
        super(maze);
    }
    @Override
    void makeEmpty() {
        queue = new MyQueue<>();
    }

    @Override
    void add(Square s) {
        queue.offer(s);
    }

    @Override
    boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    Square next() {
        return queue.poll();
    }
    public String toString() {
       return queue.toString();
    }

@Override
void clear() {
    queue.clear();
}

}

