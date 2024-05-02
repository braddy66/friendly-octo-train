import java.awt.Font;

enum GemType {
    GREEN, BLUE, ORANGE; //define the different types of Gems, comma delimited
}

public class Gem 
{
	int point;
	GemType type;
	
	Gem(){
		point = ((int)(Math.random()*11)) * 5;

		switch((int)(Math.random()*3+1)){
			case 1:
				type = GemType.GREEN;
				break;

			case 2:
				type = GemType.ORANGE;
				break;

			case 3:
				type = GemType.BLUE;
				break;
		}
	}
	
	Gem(GemType g, int point){

		type = g;
		this.point = point;
	}
	
	public GemType getType() {
		return type;
	}
	
	public int getPoints() {
		return point;
	}
void draw(double x, double y){
	switch(type){
		case GREEN -> StdDraw.picture(x, y, "gem_green.png");
		case BLUE -> StdDraw.picture(x, y, "gem_blue.png");
		case ORANGE -> StdDraw.picture(x, y, "gem_orange.png");
	}
	StdDraw.setPenColor(StdDraw.WHITE);
	StdDraw.text(x,y, String.valueOf(point));
}
		
	/** Tester main method */
	public static void main(String [] args)
	{
		final int maxGems = 16;
		
		// Create a gem of each type
		Gem green  = new Gem(GemType.GREEN, 10);
		Gem blue   = new Gem(GemType.BLUE, 20);
		Gem orange = new Gem(GemType.ORANGE, 30);
		System.out.println(green  + ", " + green.getType()  + ", " + green.getPoints());		
		System.out.println(blue   + ", " + blue.getType()   + ", " + blue.getPoints());
		System.out.println(orange + ", " + orange.getType() + ", " + orange.getPoints());
		green.draw(0.3, 0.7);
		blue.draw(0.5, 0.7);
		orange.draw(0.7, 0.7);
		
		// A row of random gems
		for (int i = 0; i < maxGems; i++)
		{
			Gem g = new Gem();
			g.draw(1.0 / maxGems * (i + 0.5), 0.5);
		}
	}
	
}
