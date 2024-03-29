// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class plantHeight {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int n = Integer.parseInt(r.readLine());
		while(n-- > 0){
			int plants = Integer.parseInt(r.readLine());
			if(plants == 1) pw.println(0);
			else {
				long [] height = new long [plants]; //unordered heights
				long [] growth = new long [plants]; //unrodered growth
				StringTokenizer st = new StringTokenizer(r.readLine());
				for(int x = 0; x < plants; x++) height[x] = Long.parseLong(st.nextToken());
				st = new StringTokenizer(r.readLine());
				for(int x = 0; x < plants; x++) growth[x]  = Long.parseLong(st.nextToken());
				long [] ordHeight = new long[plants];
				long [] ordGrowth = new long[plants];
				st = new StringTokenizer(r.readLine());
				for(int x = 0; x < plants; x++){
					int i = plants-1-Integer.parseInt(st.nextToken());
					ordHeight[i] = height[x]; 
					ordGrowth[i] = growth[x];
				}
				pw.println(Arrays.toString(ordGrowth));
				long minDays = 0;
				long maxDays = Long.MAX_VALUE; //restriction if needed
				long days = 0;
				for(int x = 0; x < plants-1;x++){
					if(ordHeight[x] == ordHeight[x+1]){
						if(ordGrowth[x] < ordGrowth[x+1]) days = 1;
						else{
							minDays = -1;
							break;
						}
					}
					else{ 
						days = (long)Math.ceil(Math.abs((ordHeight[x]+ordHeight[x+1]+1)/(ordGrowth[x]+ordGrowth[x+1])));
						if(ordHeight[x] < ordHeight[x+1]){
							if(ordGrowth[x] <= ordHeight[x+1]) days = 0;
							maxDays = Math.min(maxDays, days); // restrict to not mess up order
						}
						else{  // earlier plant is bigger
							if(ordGrowth[x] >= ordGrowth[x+1]){// invalid (always bigger cause parralel)
									minDays = -1;
									break;
							}
								else  minDays = Math.max(minDays, days);
							}
						}
					
					if(minDays >= maxDays){
							System.out.println(maxDays);
							minDays = -1;
							break;
					}	
				
				}
				pw.println(minDays);
			} 
		}
/*
 * Make sure to include the line below, as it
 * flushes and closes the output stream.
 */
pw.close();
}
}
