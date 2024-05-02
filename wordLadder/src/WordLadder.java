import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class WordLadder {
    private static HashSet<String> oneOffSet; //words that cannot be repeated
    private static Queue<Stack<String>> ladders; //Queue of word ladders
    private static HashSet<String> dict = new HashSet<>();// dictionary data structure
    private static String end;
    private static String start;
    private static boolean done; // true if end word has been found

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("dictionary.txt"));

        while(sc.hasNext())
            dict.add(sc.next().toLowerCase()); //fill hashSet with lowercase words
        sc.close();
        Long startTIme = System.currentTimeMillis();
        Scanner input = new Scanner(new File("input.txt"));

        while(input.hasNext()){
            Long inputStart = System.currentTimeMillis();
            done = false;
            start = input.next();
            end = input.next();

            //initialize data structures
            ladders = new LinkedList<>();
            oneOffSet = new HashSet<>();
            ladders.offer(new Stack<>());
            ladders.peek().push(start);
            oneOffSet.add(start);
            // if start and end are same return start as stack
            if(start.equals(end))
                System.out.println("Found a ladder >>> " + ladders.poll());

            else{// while end word has not been found make new ladders
                while(!done){
                    Stack<String> current = ladders.poll(); // current ladder

                    if(current == null){// No ladders can lead to end because no one-offs can be made
                        System.out.println("No ladder between " + start +" and " + end);
                        break;
                    }
                    Stack<String> st = (Stack<String>) current.clone();
                    ArrayList<String> oneOffWords = oneOffList(current.peek());// List of one-off words
                    if(done){
                        st.push(end);
                        ladders.offer(st);
                        System.out.println("Found a ladder >>> " + st);
                        done = true;
                    }
                    for (String s :  oneOffWords) {
                        st = (Stack<String>) current.clone();
                        st.push(s);
                        ladders.offer(st);
                    }
                }
            }
            System.out.println(System.currentTimeMillis()-inputStart);
        }
        Long end = System.currentTimeMillis();
        System.out.println("Final time " + (end-startTIme));
        input.close();
    }
    public static ArrayList<String> oneOffList(String word){ //returns list of valid oneOffWords
        ArrayList<String> al = new ArrayList<>();

        for(int x = 0; x < word.length();x++){
            for(char c = 'a'; c<='z';c++){ // loop through alphabet
                    String oneOff = word.substring(0,x) + c +word.substring(x+1); // make new one off with new character
                    if(dict.contains(oneOff)&&!oneOffSet.contains(oneOff))  { //if one off hasn't been made before and is in the dictionary
                        oneOffSet.add(oneOff);
                        al.add(oneOff);
                        if(oneOff.equals(end)){// if found end word return
                            done = true;
                            return al;
                        }
                    }
                }
            }
        return al;
    }
}
