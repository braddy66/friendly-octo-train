import java.util.*;
import java.io.*;
public class Main{
  private static HashMap<Integer, Integer> hm;
  private static int[] arr;
  public static void main(String[] args) throws IOException{
    BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter pw = new PrintWriter(System.out);
    StringTokenizer st = new StringTokenizer(r.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    arr = new int[N];
    st = new StringTokenizer(r.readLine());
    for(int i = 0; i < N;i++) arr[i] = Integer.parseInt(st.nextToken());
    hm = new HashMap<>();
    pw.print(solve(N-1, K));
    pw.close();
  }
  static int solve(int i, int K){
    if(i == 0) return 0;
    if(hm.containsKey(i)) return hm.get(i);
    int min = Integer.MAX_VALUE;
    int minI = 0;
    for(int n = 1; n <= K;n++){
      if(i-n == -1) break;
      min = Math.min(solve(i-n, K)+Math.abs(arr[i-n]-arr[i]), min);
    }
    hm.put(i, min);
    return min;
  }
}