public class FireModel

{
    public static int SIZE = 47;
    private FireCell[][] myGrid;
    private FireView myView;
    private boolean trouble = false;
    public FireModel(FireView view)
    {
        myGrid = new FireCell[SIZE][SIZE];
        for (int r=0; r<SIZE; r++)
        {
            for (int c=0; c<SIZE; c++)
            {
                myGrid[r][c] = new FireCell();
            }
        }
        myView = view;
        myView.updateView(myGrid);
    }

   void  recursiveFire(int r, int c){
        if(r == -1) trouble = true; //Fire has reached onnet
        if(c == SIZE || c == -1 || r == -1 ||r == SIZE || myGrid[r][c].getStatus() == FireCell.DIRT || myGrid[r][c].getStatus() == FireCell.BURNING) // base cases
           return;
        if(myGrid[r][c].getStatus() == FireCell.GREEN) // If cell is green then burn it
            myGrid[r][c].setStatus(FireCell.BURNING);
            
        recursiveFire(r-1,c); // up
        recursiveFire(r,c+1); // left
        recursiveFire(r,c-1); // right
        recursiveFire(r+1,c); // down

   }
   public void solve() {
    boolean tempTrouble = false;
    for (int c = 0; c < SIZE; c++) {
        recursiveFire(SIZE - 1, c);
        if (trouble) {
            System.out.println("ONNET IS IN TROUBLE!");
            tempTrouble = true;
            trouble = false;
        }

    }
    if (!tempTrouble)
        System.out.println("ONNET IS SAFE!");
   }

}
