import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);

		int N = Integer.parseInt(r.readLine());
		// st = new StringTokenizer(r.readLine());
		StringTokenizer st = new StringTokenizer(r.readLine());

	
		// System.out.println(st.toString());
		int [] cows = new int[N];

		for(int x = 0; x < N;x++)
			cows[x] = Integer.parseInt(st.nextToken());
			// System.out.println(st.nextToken());
		
		Arrays.sort(cows);
		System.out.println(Arrays.toString(cows));
		int ans = 0;
		int maxTuition = 0;
		for(int i = N-1; i> -1;i--){
			int current = (N-i) * cows[i];
			 System.out.println(current);
			if(current >= maxTuition){
				maxTuition = current;
				ans = cows[i];
			}

		}
		// int b = Integer.parseInt(st.nextToken());
		// int c = Integer.parseInt(st.nextToken());
		// pw.println(maxTuition);
		// pw.println(ans);
		/*
		 * Make sure to include the line below, as it
		 * flushes and closes the output stream.
		 */
		pw.close();
	}
}
