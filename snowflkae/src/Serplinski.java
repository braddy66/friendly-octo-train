import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

class SerplinskiPanel extends JPanel
{
	public SerplinskiPanel()
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
		 
		g.setColor(Color.BLUE);		
		drawTriangles(g, 400, 400, 400);
	}
	void drawTriangles(Graphics g,int x, int y, int size){
		if(size < 10){
			g.drawLine(x,y,x-size,y);
			g.drawLine(x,y,x,y-size);
			g.drawLine(x,y-size,x-size, y); // last triangle			
			return;
		}
		g.drawLine(x,y,x-size,y);
		g.drawLine(x,y,x,y-size);
		g.drawLine(x,y-size,x-size, y);	// draw current triangle

		drawTriangles(g, x-size/2, y+size/2,size/2);  // draw triangle below		
		drawTriangles(g, x+size/2, y-size/2, size/2); // draw triangle right
		drawTriangles(g, x-size/2, y-size/2, size/2); // draw triangle left
	}

}
public class Serplinski {
   public static void main ( String[] args )
	{
		/*
		 * A frame is a container for a panel
		 * The panel is where the drawing will take place
		 */
		JFrame frame = new JFrame("Serplinski");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new SerplinskiPanel());
		frame.pack();
		frame.setVisible(true);
	}
	
}
