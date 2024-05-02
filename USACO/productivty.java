import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class productivty {
    
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        // Read input from System.in
        StringTokenizer st = new StringTokenizer(r.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        ArrayList<Integer> time = new ArrayList<>();
      
        st = new StringTokenizer(r.readLine());
        for(int i = 0; i < N; i++) time.add(Integer.parseInt(st.nextToken()));
        
        st = new StringTokenizer(r.readLine());
        for(int i = 0; i < time.size(); i++){ 
            time.set(i, time.get(i)-Integer.parseInt(st.nextToken()));
        }
        Collections.sort(time, Collections.reverseOrder());
        // pw.println(time);
        while(Q-- > 0){
            st = new StringTokenizer(r.readLine());
            int v = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            if(time.get(v-1) > s) pw.println("YES");
            else pw.println("NO");
            
        }
        pw.close();
    }
}