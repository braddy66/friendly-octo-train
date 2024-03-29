// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class Main {
	public static void MilkExchange(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(r.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String s = r.readLine();
        int [] bucket = new int[N];
		int [] init = new int[N];
        st = new StringTokenizer(r.readLine());
        for(int i = 0; i < N; i++){ 
			bucket[i] = Integer.parseInt(st.nextToken());
			init[i] = bucket[i];
		}
		for(int x = 0; x < M;x++){
			for(int i = 0; i < N; i++){
				if(bucket[i] == 0) continue;
				bucket[i]--;
				if(s.charAt(i) == 'L') bucket[(i-1+N)%N]++;
				else bucket[(i+1)%N]++;
			}
		}
		// pw.println(Arrays.toString(bucket));
        long total = 0;
		for(int i = 0; i < N;i++) total+=Math.min(bucket[i], init[i]);
		pw.println(total);
		pw.close();
	}
}
