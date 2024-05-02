// Source: https://usaco.guide/general/io

import java.io.*;
// import java.util.StringTokenizer;
import java.util.*;

public class CandyFest{
	public static void main(String[] args) throws IOException {
		
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader r = new BufferedReader(new FileReader("inputs/2.in"));

		PrintWriter pw = new PrintWriter(System.out);

		StringTokenizer st = new StringTokenizer(r.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long [] cows = new long[N];
		st = new StringTokenizer(r.readLine());
		for(int i = 0; i < N;i++) 
			cows[i] = Long.parseLong(st.nextToken());
		st = new StringTokenizer(r.readLine());
		Queue<Candy> candies = new LinkedList<>(); // cows always start with the first candy
		for(int i = 0; i < M;i++) 
			candies.offer(new Candy(Integer.parseInt(st.nextToken())));
		
	while(!candies.isEmpty()){
    Candy current = candies.peek();
	boolean empty = false;
    for(int i = 0; i < N; i++)
        if(cows[i] >=current.start){
            if(cows[i] >= current.height){// candy is finished
                cows[i]+=(current.height-current.start)+1;
                candies.poll();
                if(candies.isEmpty()){ 
					empty = true;
					break; // no candies left
				}
                current = candies.peek();// hang new candy
				i = -1;
				// pw.println(cows[i]);
            }
            else{
                long temp = cows[i]+1;
                cows[i]+=(cows[i]-current.start)+1; 
                current.start = (int)temp;
                if(current.start == current.height){// candy finished
                    candies.poll();
					i = -1;// start from the first cow.
					current = candies.peek();
                }
				// pw.println(current);
				// pw.println(i);
				
            }
        }
		if(!empty)
			candies.poll();
}

		for(int i = 0; i < N;i++) pw.println(cows[i]);
		System.gc();
		/*
		 * Make sure to include the line below, as it
		 * flushes and closes the output stream.
		 */
		pw.close();
	}
	static class Candy{
		int start;
		int height;
		Candy (int  height){
			this.height =  height;
			start = 1;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return start+" "+height;
		}
	}
}