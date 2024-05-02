// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class cowntract {
	public static void main(String[] args) throws IOException {
		// BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader r = new BufferedReader(new FileReader("data/7.in"));
		PrintWriter pw = new PrintWriter(System.out);
		int N = Integer.parseInt(r.readLine());
		String cows = r.readLine();
		// base cases
		if (cows.indexOf("0") == -1) pw.println(1);
		else if (cows.indexOf("1") == -1)pw.println(0);
		else {
			int nights = Integer.MAX_VALUE;
			int length = 0;
			ArrayList<Integer> segments = new ArrayList<>();
			int numInfected = 0;
			for (int i = 0; i < N; i++) {
				if (cows.charAt(i) == '1') length++; //if infected increment seg. length
				else if (length > 0) {
					segments.add(length);
					int current = 0;
					if (i - length == 0) current = length - 1; // edge seg
					else current = (length - 1) / 2;
					nights = Math.min(current, nights);
					length = 0;
				}
			}
			if (length > 0) { // last index inc.
				segments.add(length);
				nights = Math.min(length - 1, nights);		
			}
			for (int seg : segments) numInfected += Math.ceil((double) seg / (2 * nights + 1));
			pw.println(numInfected);
		}

		/*
		 * Make sure to include the line below, as it
		 * flushes and closes the output stream.
		 */
		pw.close();
	}
}
