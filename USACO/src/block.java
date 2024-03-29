import java.io.*;
import java.util.*;

public class block {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        String[] statement = new String[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            statement[i] = st.nextToken();
        }

        // Precompute the prefix and suffix results
        boolean[][] prefix = precomputePrefix(statement);
        boolean[][] suffix = precomputeSuffix(statement);

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            String desiredOutput = st.nextToken();

            pw.println(isQueryPossible(prefix, suffix, l, r, desiredOutput) ? 'Y' : 'N');
        }

        pw.close();
        br.close();
    }

    private static boolean[][] precomputePrefix(String[] statement) {
        int n = statement.length;
        boolean[][] prefix = new boolean[n][2];
        
        prefix[0][0] = statement[0].equals("true");
        prefix[0][1] = !prefix[0][0];
        
        for (int i = 2; i < n; i += 2) {
            prefix[i][0] = evaluate(prefix[i - 2], statement[i - 1], true);
            prefix[i][1] = evaluate(prefix[i - 2], statement[i - 1], false);
        }
        
        return prefix;
    }

    private static boolean[][] precomputeSuffix(String[] statement) {
        int n = statement.length;
        boolean[][] suffix = new boolean[n][2];
        
        suffix[n - 1][0] = statement[n - 1].equals("true");
        suffix[n - 1][1] = !suffix[n - 1][0];
        
        for (int i = n - 3; i >= 0; i -= 2) {
            suffix[i][0] = evaluate(suffix[i + 2], statement[i + 1], true);
            suffix[i][1] = evaluate(suffix[i + 2], statement[i + 1], false);
        }
        
        return suffix;
    }

    private static boolean evaluate(boolean[] prev, String operator, boolean value) {
        if (operator.equals("and")) {
            return prev[0] && value || prev[1] && value;
        } else {
            return prev[0] || value && prev[1] || value;
        }
    }

    private static boolean isQueryPossible(boolean[][] prefix, boolean[][] suffix, int l, int r, String desiredOutput) {
        // Adjust indices to match 0-based indexing
        l--; r--;
        
        // Check if the precomputed result for the segment matches the desired output
        boolean leftTrue = l > 0 ? prefix[l - 2][0] : true;
        boolean leftFalse = l > 0 ? prefix[l - 2][1] : false;
        boolean rightTrue = r < prefix.length - 1 ? suffix[r + 2][0] : true;
        boolean rightFalse = r < prefix.length - 1 ? suffix[r + 2][1] : false;
        boolean desired = desiredOutput.equals("true");
        
        return ((leftTrue && rightTrue) || (leftFalse && rightFalse)) == desired;
    }
}
