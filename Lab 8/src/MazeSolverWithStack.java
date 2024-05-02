public class MazeSolverWithStack extends MazeSolver {
    MyStack stack;
    MazeSolverWithStack(Maze maze){
        super(maze);
    }
    @Override
    void makeEmpty(){
        stack = new MyStack();
//        add(maze.getStart());
    }
    @Override
    void add(Square s){
        stack.push(s);
        
    }
    Square next(){
        return stack.pop();
    }
    @Override 
    boolean isEmpty(){
        return stack.isEmpty();
    }
    @Override
    void clear() {
        stack.clear();
    }
    
    

}
