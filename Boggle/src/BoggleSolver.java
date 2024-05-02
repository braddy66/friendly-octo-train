import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
public class BoggleSolver
{
	HashSet<String> dict;
	// Initializes the data structure using the given array of strings as the dictionary.
	// (You can assume each word in the dictionary contains only the uppercase letters A - Z.)
	public BoggleSolver(String dictionaryName) throws FileNotFoundException
	{
		File dictionary = new File(dictionaryName);
		Scanner sc = new Scanner(dictionary);
		dict = new HashSet<>();
		while(sc.hasNext()) dict.add(sc.next());
	}

	// Returns the set of all valid words in the given Boggle board, as an Iterable object
	public Iterable<String> getAllValidWords(BoggleBoard board)
	{
		boolean [][] visited = new boolean[board.rows()] [board.cols()];
		HashSet<String> hs = new HashSet<>();
		for(int r = 0; r < board.rows();r++)
			for(int c = 0; c < board.cols();c++)
				findWords(board,r,c,"",hs, visited);
		return  hs;
	}
	public void findWords(BoggleBoard board,int r, int c, String soFar, HashSet<String> hs, boolean[][] visited){
		if(r < board.rows() && r > -1 && c < board.cols() && c > -1  && !visited[r][c]) { //index in bounds and not visited
			char current = board.getLetter(r, c); 
			soFar += current;
			if(current == 'Q') soFar+="U";
			if(dict.contains(soFar) && soFar.length() > 2) hs.add(soFar); // found a word greater than length 2

			visited[r][c] = true; // set block visited
			for(int row = r-1; row < r+2; row++)
				for(int col = c-1; col < c+2; col++)
						findWords(board, row, col, soFar, hs, visited);// include letter
					
			visited[r][c] = false; // reset current block so block can be used in another word
		}
	}
	// Returns the score of the given word if it is in the dictionary, zero otherwise.
	// (You can assume the word contains only the uppercase letters A - Z.)
	public int scoreOf(String word) {
		int score = 0;

		switch (word.length()) {
			case 3, 4 -> score += 1;
			case 5, 6 -> score += word.length() - 3;
			case 7 -> score += 5;
		}
		if (word.length() > 7) 
				score += 11;
		return score;
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("WORKING");

		final String PATH   = "./data/";
		BoggleBoard  board  = new BoggleBoard(PATH + "board-q.txt");
		BoggleSolver solver = new BoggleSolver(PATH + "dictionary-algs4.txt");

		int totalPoints = 0;
		for (String s : solver.getAllValidWords(board)) {
			// if(s.charAt(0) == 'P')
			System.out.println(s + ", points = " + solver.scoreOf(s));
			totalPoints += solver.scoreOf(s);
		}
		

		System.out.println("Score = " + totalPoints); //should print 84

		//new BoggleGame(4, 4);
	}

}
