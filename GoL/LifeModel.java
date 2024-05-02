import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.Timer;

public class LifeModel implements ActionListener
{

	/*
	 *  This is the Model component.
	 */

	private static int SIZE = 60;
	private LifeCell[][] grid;
	
	LifeView myView;
	Timer timer;

	/** Construct a new model using a particular file */
	public LifeModel(LifeView view, String fileName) throws IOException
	{       
		int r, c;
		grid = new LifeCell[SIZE][SIZE];
		for ( r = 0; r < SIZE; r++ )
			for ( c = 0; c < SIZE; c++ )
				grid[r][c] = new LifeCell();

		if ( fileName == null ) //use random population
		{                                           
			for ( r = 0; r < SIZE; r++ )
			{
				for ( c = 0; c < SIZE; c++ )
				{
					if ( Math.random() > 0.85) //15% chance of a cell starting alive
						grid[r][c].setAliveNow(true);
				}
			}
		}
		else
		{                 
			Scanner input = new Scanner(new File(fileName));
			int numInitialCells = input.nextInt();
			for (int count=0; count<numInitialCells; count++)
			{
				r = input.nextInt();
				c = input.nextInt();
				grid[r][c].setAliveNow(true);
			}
			input.close();
		}

		myView = view;
		myView.updateView(grid);

	}

	/** Constructor a randomized model */
	public LifeModel(LifeView view) throws IOException
	{
		this(view, null);
	}

	/** pause the simulation (the pause button in the GUI */
	public void pause()
	{
		timer.stop();
	}
	
	/** resume the simulation (the pause button in the GUI */
	public void resume()
	{
		timer.restart();
	}
	
	/** run the simulation (the pause button in the GUI */
	public void run()
	{
		timer = new Timer(50, this);
		timer.setCoalesce(true);
		timer.start();
	}
	public void Reset(){

	}

	/** called each time timer fires */
	public void actionPerformed(ActionEvent e)
	{
		oneGeneration();
		myView.updateView(grid);
	}

	/** main logic method for updating the state of the grid / simulation */
	private void oneGeneration() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				switch (numNeighbors(i, j)) {
					case 0:
					case 1:
							grid[i][j].setAliveNext(false);
							break;
					case 2:
							if(grid[i][j].isAliveNow())
								grid[i][j].setAliveNext(true);
							break;
					case 3:
							grid[i][j].setAliveNext(true);
							break;
					case 4:
					case 5:
					case 6:
					case 7:
					case 8:
							grid[i][j].setAliveNext(false);
							break;
				}
			}
		}
		for(int i = 0; i < SIZE; i++){
			for(int j = 0; j < SIZE; j++){
				grid[i][j].setAliveNow(grid[i][j].isAliveNext());
			}
		}
	}
	private int numNeighbors(int i, int j){
		int num = 0;
		for(int x = i-1; x < i+2; x++) {
			for (int y = j - 1; y < j + 2; y++) {
				if(x >= 0 && x < SIZE && y>= 0 && y< SIZE && !(x== i && y==j))
					if(grid[x][y].isAliveNow())
					num++;
			}
		}
		return num;
	}
		/* 
		 * student code here 
		 */
	}


