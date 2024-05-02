// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long [] growth;
	static long [] height;
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int n = Integer.parseInt(r.readLine());
		while(n-- > 0){
			int plants = Integer.parseInt(r.readLine());
			 height = new long [plants];
			 growth = new long [plants];
			// long [] ordered = new long [plants];
			StringTokenizer st = new StringTokenizer(r.readLine());
			for(int x = 0; x < plants; x++) height[x] = Long.parseLong(st.nextToken());
			pw.println(Arrays.toString(height));
			st = new StringTokenizer(r.readLine());
			for(int x = 0; x < plants; x++) growth[x]  = Long.parseLong(st.nextToken());
			st = new StringTokenizer(r.readLine());
			for(int x = 0; x < plants; x++) swap(x,Integer.parseInt(st.nextToken())); 
			// int maxDays = 0;
			long minDays = 0;
			// int ans = -
			for(int x = 1; x < plants;x++){
				if(growth[x-1] > growth[x] && height[x] < height[x-1]){ 
					minDays = -1;
					break;
				}	
				else minDays = Math.max(minDays,(height[x]-height[x-1]+1)/growth[x]-growth[x-1]);	
			}
			pw.write(""+minDays);
		} 
		/*
		 * Make sure to include the line below, as it
		 * flushes and closes the output stream.
		 */
		pw.close();
	}
static void swap(int oldInt, int newInt){
    long temp = height[oldInt];
    height[oldInt] = height[newInt];
    height[newInt] = height[oldInt];
    temp = growth[oldInt];
    growth[oldInt] = growth[newInt];
    growth[newInt] = temp;
}
}
