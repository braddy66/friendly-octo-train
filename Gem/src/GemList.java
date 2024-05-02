public class GemList 
{
	Node head;
	int size;
	int score;
	private class Node{
		private Gem gem;
		private Node next;
		Node(Gem gem){
			this.gem = gem;
		}
	}
	GemList(){
		head = null; size = score = 0;
	}
	int size(){
		return size;
	}
	void draw(double y){
		if(size > 0){
		Node temp = head;
		double x = 0;
		for(double i = 0; i < size;i++){
			temp.gem.draw(x,y);
			temp = temp.next;
			x+=0.0625;
		}
	}
}
	public String toString(){
		if(size == 0){
			return "<none>";
		}
		Node temp = head.next;
		String st = head.gem.type + "";

		while(temp != null){
			st+= " -> " + temp.gem.type;
			temp = temp.next;
		}
		return st;
	}
	void insertBefore(Gem gem, int index){
		if(size == 0){
			Node temp = new Node(gem);
			temp.next = head;
			head = temp;
			size++;
			return;
		}

		Node temp = head;
		for(int x = 0; x < index-1; x++){
			if(temp.next == null){
				temp.next = new Node(gem);
				size++;
				return;
			}
			temp = temp.next;
		}
		Node n = new Node(gem);
		n.next = temp.next;
		temp.next = n;
		size++;
	}
	int score(){
		// base cases
		if(size == 0)
			return 0;
		if(size == 1)
			return head.gem.point;		
		//reset score
		score = 0;
		Node temp = head;
		int multiplier = 1;
		int partialScore = head.gem.point;// need this if the gem after head has the same color
		while (temp.next != null) {
			if(temp.gem.type.equals(temp.next.gem.type)){//calculate multiplied segment sum
				multiplier++;
				partialScore+=(temp.next.gem.point);
			}
			else{
				if(multiplier > 1){ //add multiplied segment
					score+=(partialScore*multiplier);
					multiplier = 1;
					score+=temp.next.gem.getPoints(); //add current gem with diff color
				}
				else{// add previous points
					score+=temp.gem.getPoints();
					partialScore = temp.next.gem.getPoints();// update for segmenr
					if(temp.next.next == null) // avoids ignoring tail gem
						score+=partialScore;
				}
			}
			temp = temp.next;
		}
		
		if(multiplier > 1)// last 
			score+=(partialScore*multiplier);
		return score;
	}
	
	public static void main(String [] args)
	{
		GemList list = new GemList();
		System.out.println(list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.9);		
		
		list.insertBefore(new Gem(GemType.BLUE, 10), 0);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.8);
		
		list.insertBefore(new Gem(GemType.BLUE, 20), 99);  //not a mistake, should still work
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.7);
		
		list.insertBefore(new Gem(GemType.ORANGE, 30), 1);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.6);
		
		list.insertBefore(new Gem(GemType.ORANGE, 10), 2);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.5);
		
		list.insertBefore(new Gem(GemType.ORANGE, 50), 3);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.4);
		
		list.insertBefore(new Gem(GemType.GREEN, 50), 2);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.3);		
	}	
}
