import java.util.List;
public abstract class MazeSolver {
    private boolean Solved;
    private boolean Solvable;
    Maze maze;
    MazeSolver(Maze maze){
        makeEmpty();
        this.maze = maze;
        add(maze.getStart());
        Solvable = true;
        Solved = false;
    }
    abstract void makeEmpty();
    abstract void add(Square s);
    abstract boolean isEmpty();
    abstract Square next();
    boolean isSolved(){
        return Solved || !Solvable;
    }
    void step(){
        if(isEmpty()){
            Solvable = false;
        }
        else{
            Square sq = next();
            List<Square> neighbours = (List<Square>) maze.getNeighbours(sq);
            for(Square nb : neighbours)
                if(nb.getStatus() == Square.UNKNOWN && nb.getType()!=Square.WALL){
                    add(nb);
                    nb.setWorking();
                    nb.previous = sq;
                    if(nb.equals(maze.getExit())){
                        Solved = true;
                        return;
                    }

                }
                sq.setExplored();
            
        }
    }
    
    String getPath(){
         if(!Solvable)
            return "Maze is unsolvable";
        
        if(Solved && Solvable) {
            MyStack stack= new MyStack();
            Square temp = maze.getExit();
            if(!isEmpty())
            clear();
            while(temp!=null){
                stack.push(temp);
                temp = temp.previous;
            }

            String s = "";
            while(!stack.isEmpty()){ 
                temp = stack.pop();
                s+= "[" + temp.getCol() +", " + temp.getRow() + "] ";
                temp.setOnExitPath();
            }
            return s;
        }
        else
            return "Maze not solved";
    }
    void solve(){
        while(isSolved())
            step();
    }
    abstract void clear();
}
