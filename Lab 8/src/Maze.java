
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

public class Maze {
    private Square[][] array;
    private Square start;
    private Square exit;
    private String fileName;
    public Maze(){
    }
    boolean loadMaze(String fileName) {
        try {
            File f = new File(fileName);
            Scanner sc = new Scanner(f);
            array = new Square[sc.nextInt()][sc.nextInt()];
            sc.nextLine();
            for(int i = 0; i < array.length;i++){
                for(int j = 0; j < array[0].length;j++){
                    array[i][j] = new Square(i , j , sc.nextInt());
                    if(array[i][j].toString() == "S")
                        start = array[i][j];
                    if(array[i][j].toString() == "E")
                        exit = array[i][j];
                }
                sc.nextLine();
            }
            return true;
        } catch (Exception FileNotFoundException) {
            return false;
        }
    }
    List<Square> getNeighbours(Square s){
        List<Square> l = new ArrayList<>();
        int row = s.getRow();
        int col = s.getCol();
            
            if(col+1 < array[0].length )
                l.add(array[row][col+1]);
            if(row+1 < array.length)
                l.add(array[row+1][col]);
            if(row-1 > -1)
                l.add(array[row-1][col]);
            if(col-1 > -1 && array[row][col-1].getType() != 1)
                l.add(array[row][col-1]);
        return l;
    }
    public Square getStart() {
        return start;
    }
    public Square getExit() {
        return exit;
    }
    void reset(){
        for(int x = 0; x < array.length;x++){
            for(int y = 0; y < array[0].length;y++)
                array[x][y].setStatus('_');
        }
    }
    public String toString(){
        String maze = "";
        for(Square[] squares : array){
            String l = Arrays.toString(squares).replace(',' , ' ').replace(']', ' ').replace('[', ' ')+'\n';
            l = l.replace(']', ' ');
            maze+=l;
        }
        return maze;
    }

}
