import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

class SnowFlakePanel extends JPanel
{
	public SnowFlakePanel()
	{
		super.setPreferredSize(new Dimension(400, 400));
		super.setBackground(Color.WHITE);
	}
	public void paintComponent(Graphics g)
	{
		int width  = getWidth();
		int height = getHeight();

		super.paintComponent(g);

		/*
		 * DRAWING CODE BELOW
		 */
		 
		for(int x = 0; x < 15;x++){
			g.setColor(new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256)));
			drawStar(g,(int) (Math.random()*getHeight()+getHeight()/4), (int) (Math.random()*getWidth()+getWidth()/4), (int)(Math.random() * 80 + 10));		
		}
		// g.setColor(Color.BLUE);		

		// drawStar(g, 200, 200, 150);
	}
	public void drawStar(Graphics g, int x, int y, int size){
		int width =(int) (size*Math.cos(Math.PI/3));
		int height = (int)(size*Math.sin(Math.PI/3));
		if(size < 20){
			g.drawLine(x-size, y, x+size, y); //horizontal line
			g.drawLine(x-width, y-height, x+width, y+height); // diagonal line with negative slope
			g.drawLine(x-width, y+height, x+width, y-height); // digaonal line with postive slope		
			return; // base case
		}
		g.drawLine(x-size, y, x+size, y); //horizontal line drawn
		drawStar(g,x-size, y, (int)(size/4)); //star on left 
		drawStar(g,x+size, y,(int) (size/4)); // star on right 

		g.drawLine(x-width, y-height, x+width, y+height); // diagonal line with negative slope
		drawStar(g,x-width, y-height, (int)(size/4));// star on top left 
		drawStar(g,x+width, y+height,(int) (size/4)); // star on bottom right 

		g.drawLine(x-width, y+height, x+width, y-height); //diagonal line 2
		drawStar(g,x-width, y+height,(int) (size/4)); // star on top right
		drawStar(g,x+width, y-height,(int) (size/4)); // star on bottom left 
	}
}

public class Snowflake
{
	public static void main ( String[] args )
	{
		/*
		 * A frame is a container for a panel
		 * The panel is where the drawing will take place
		 */
		JFrame frame = new JFrame("Snowflake");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new SnowFlakePanel());
		frame.pack();
		frame.setVisible(true);
		
	}
}
