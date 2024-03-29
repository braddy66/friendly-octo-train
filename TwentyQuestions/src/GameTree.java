import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

/**
 * A model for the game of 20 questions
 *
 * @author Rick Mercer
 */
public class GameTree
{
	Node root;
	Node node;
	File input;
	private class Node{
		String val;
		Node yes;
		Node no;
		Node(String val){
			this.val = val;
		}
	}
	/**
	 * Constructor needed to create the game.
	 *
	 * @param fileName
	 *          this is the name of the file we need to import the game questions
	 *          and answers from.
	 */
	public GameTree(String fileName) {
		try {
			input = new File(fileName);
			Scanner sc = new Scanner(input);
			root = buildTree(sc);
			node = root;
			
		} catch (Exception FileNotFoundException) {}
	}

	Node buildTree(Scanner sc) {
		String val = sc.nextLine().trim();	
		Node node = new Node(val);
		if (val.charAt(val.length() - 1) == '?') { // question
			node.yes = buildTree(sc); // yes node
			node.no = buildTree(sc); // no node
		}
		return node;
	}
	/*
	 * Add a new question and answer to the nodeNode. If the current node has
	 * the answer chicken, theGame.add("Does it swim?", "goose"); should change
	 * that node like this:
	 */
	// -----------Feathers?-----------------Feathers?------
	// -------------/----\------------------/-------\------
	// ------- chicken  horse-----Does it swim?-----horse--
	// -----------------------------/------\---------------
	// --------------------------goose--chicken-----------
	/**
	 * @param newQ
	 *          The question to add where the old answer was.
	 * @param newA
	 *          The new Yes answer for the new question.
	 */
	public void add(String newQ, String newA)
	{
		String temp = node.val;
		node.val = newQ;
		node.yes = new Node(newA);
		node.no = new Node(temp);
	}

	/**
	 * True if getnode() returns an answer rather than a question.
	 *
	 * @return False if the current node is an internal node rather than an answer
	 *         at a leaf.
	 */
	public boolean foundAnswer()
	{
		return node.yes == null; //replace
	}

	/**
	 * Return the val for the current node, which could be a question or an
	 * answer.  node will change based on the users progress through the game.
	 *
	 * @return The node question or answer.
	 */
	public String getCurrent()
	{
		return node.val;
	}

	/**
	 * Ask the game to update the current node by going left for Choice.yes or
	 * right for Choice.no Example code: theGame.playerSelected(Choice.Yes);
	 *
	 * @param yesOrNo
	 */
	public void playerSelected(Choice yesOrNo)
	{
		if(yesOrNo == Choice.Yes) node = node.yes;
		else node = node.no;
	}

	/**
	 * Begin a game at the root of the tree. getnode should return the question
	 * at the root of this GameTree.
	 */
	public void reStart()
	{
		node = root;
	}

	@Override
	public String toString()
	{
		return "";
		// return toString(root, "");
	}
	public String toString(Node node, String literal)
	{
		if (node == null) return "" ; 
		return toString(node.no, literal + "- ") + literal + node.val + "\n" + toString(node.yes, literal + "- ");
	}

	/**
	 * Overwrite the old file for this gameTree with the node state that may
	 * have new questions added since the game started.
	 *
	 */
	public void saveGame()
	{
		try{
			PrintWriter pw = new PrintWriter(input);
			saveGameHelper(root, pw);
			pw.close();
		}catch(Exception e){}
	}
	void saveGameHelper(Node node, PrintWriter pw){
		if(node != null){
			pw.println(node.val);
			saveGameHelper(node.yes, pw);
			saveGameHelper(node.no, pw);
		}
	}
}