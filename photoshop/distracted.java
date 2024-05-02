import java.io.*;
import java.util.*;
public class distracted{
    public static void main(String [] args) throws IOException{
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(r.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        HashMap<String, Character> hm = new HashMap<>();
        for(int x = 0; x < N;x++){
            st = new StringTokenizer(r.readLine());
            hm.put(st.nextToken(), st.nextToken().charAt(0));
        }
        char ans = '0';
        HashSet<String> hs = new HashSet<>();
        for(int x = 0; x < L;x++){
            st = new StringTokenizer(r.readLine());
        	char pers = hm.get(st.nextToken());
        	st.nextToken();
        	String find = st.nextToken();
            char val = hm.get(find);
            if(pers != 'u' && val != 'm') ans = '?';
            if(!hs.contains(find)){
                hs.add(find);
                if(pers == 'm'){
                    if(val == 'u'){
                        ans = '1';
                        break;
                    }
                    else if(val == '?') ans = '?';    
                }
            }
        }
        System.out.println(ans);
    }
}