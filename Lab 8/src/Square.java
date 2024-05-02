public class Square
{
	//These values are used to denote what type of Square this is in the maze
	final static int EMPTY = 0; //an empty space
	final static int WALL  = 1; //a wall
	final static int START = 2; //the start 
	final static int EXIT  = 3; //the exit

	//These values indicate the status of a particular Square while the maze is being solved, for the GUI
	final static char WORKING      = 'o'; //currently on the work list (the stack)
	final static char EXPLORED     = '.'; //done, already explored
	final static char ON_EXIT_PATH = 'x'; //on the exit path, used in a later lab
	final static char UNKNOWN      = '_'; //not known / visited yet (empty cells only)

	private int  row, col; //r, c location in the maze
	private int  type;     //type of this square, e.g. empty, wall, etc.
	private char status;   //the status of a room being explored, shown by the GUI
	public Square previous;
	public Square(int row, int col, int type){
		this.col = col;
		this.row = row;
		this.type = type;
		if(type == 0)
			setUnknown();
	}
	public String toString(){
		switch(type){
			case WALL:
				return "#";

			case START:
				return "S";

			case EXIT:
				return "E";
		}
		return String.valueOf(status);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Square square = (Square) o;
		return row == square.getRow() && col == square.getCol();
	}

	public int getCol() {
		return col;
	}
	public int getRow() {
		return row;
	}
	public int getType() {
		return type;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public void setWorking(){
		status = WORKING;
	}
	public void setExplored(){
		status = EXPLORED;
	}
	public void setOnExitPath(){
		status = ON_EXIT_PATH;
	}
	public void setUnknown(){
		status = UNKNOWN;
	}

}