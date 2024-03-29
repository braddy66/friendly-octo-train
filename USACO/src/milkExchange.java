// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class milkExchange {
	public static void main(String[] args) throws IOException {
	BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String s = r.readLine();
        int [] bucket = new int[N];
        st = new StringTokenizer(r.readLine());
		long total = 0;
        for(int i = 0; i < N; i++){ 
			bucket[i] = Integer.parseInt(st.nextToken());
			total+=bucket[i];
		}
		for(int i = 0; i < N;i++){
			if(s.charAt(i) == 'R' && s.charAt((i+1)%N) == 'L'){
				long waisted = 0;
				int temp = (i-1+N)%N;
				while(s.charAt(temp) == 'R'){
					waisted+=bucket[temp];
					temp = (temp-1+N)%N;
				}
				temp = (i+2)%N;
				total-=Math.min(waisted, M);
				waisted = 0;
				while(s.charAt(temp) == 'L'){
					waisted+=bucket[temp];
					temp = (temp+1)%N;
				}
				total-=Math.min(waisted, M);
				if(temp < i) break;
			} 
		}
		pw.println(total);
		pw.close();
	}
}
