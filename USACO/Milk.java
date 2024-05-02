import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Milk {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(r.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        String s = r.readLine();
        long [] bucket = new long[N];
        long total = 0;
        st = new StringTokenizer(r.readLine());
        for(int i = 0; i < N;i++){
            bucket[i] = Long.parseLong(st.nextToken());
            total+=bucket[i];
        }
        long[] left = new long[N];
        long[] right = new long[N];
        for (int i = 0; i < N; i++) {
            if (s.charAt(i) == 'L') {
                left[(i - 1 + N) % N]++;
            } else {
                right[(i + 1) % N]++;
            }
        }
        for (int i = 0; i < N; i++) {
            long receive = Math.min(M, left[i] + right[i]);
            long give = Math.min(M, bucket[i]);
            if(bucket[i] + receive - give > bucket[i]) {
                total -= (bucket[i] + receive - give - bucket[i]);
            }
            bucket[i] = bucket[i] - give + receive;
        }
        System.out.println(total);
    }
}
