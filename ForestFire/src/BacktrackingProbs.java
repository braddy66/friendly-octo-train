import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
public class BacktrackingProbs {
    public static void main(String[] args) {
        System.out.println(printBinary(2));
        climbStairs(4);
        campSite(2, 1);
        System.out.println(getMax(Arrays.asList(7, 30, 8, 22, 6, 1, 14), 19));
        System.out.println(makeChange2(13));
        System.out.println(makeChange(100));
        System.out.println(longestCommonSub("ABCDEFG", "BGCEHAF"));
        System.out.println(longestCommonSub("12345","543212154321"));
        System.out.println(getMax(Arrays.asList(1, 6, 9) , 8));
    }
    static String printBinary(int n) {
        return printBinaryHelper(n, "");
    }
    static String printBinaryHelper(int n, String s){
        if(s.length() == n) return s + " ";
        return printBinaryHelper(n, s+0) + printBinaryHelper(n, s+1);
        
    }
   static void climbStairs(int steps){
         climbStairsHelper(steps, "");
    }
    static void climbStairsHelper(int steps, String soFar){
        if(steps >= 0){
            if(steps == 0) System.out.println(soFar.substring(1));
            climbStairsHelper(steps-1, soFar+", 1");
            climbStairsHelper(steps-2, soFar+", 2");
        }
    }
    static void campSite(int x, int y){
        campSiteHelper(x, y, "");
    }
   static void campSiteHelper(int x, int y, String soFar){
    if(x == 0 && y == 0){
        System.out.println(soFar);
        return;
    }
    if(x > 0) campSiteHelper(x-1, y, soFar+"E "); 
    if(y > 0) campSiteHelper(x, y-1, soFar+"N ");
    if(x > 0 && y > 0) campSiteHelper(x-1, y-1, soFar+"NE ");
    }
    static int getMax(List<Integer> nums, int limit){
        return getMaxHelper(nums, limit, 0,0);
    }
    static int getMaxHelper(List<Integer> nums, int limit, int i, int max){
        if(i == nums.size()) return max;
        else if(max > limit) return -1;

        max =  Math.max(getMaxHelper(nums, limit, i+1, max+nums.get(i)), getMaxHelper(nums,limit, i+1, max));
        if(max > limit) max-= nums.get(i);
        return max;
    }
    static int makeChange(int amount){
        return makeChangeHelper(new int[]{1,5,10,25}, 0, amount);
    }
    static int makeChangeHelper(int[] coins, int coin, int amount) {
        if (amount < 0 || coin == coins.length) return 0; // do nothing
        if (amount == 0) return 1;// combo found
        return  makeChangeHelper(coins, coin, amount - coins[coin]) + makeChangeHelper(coins, coin+ 1, amount); // sum of combos with and without current coin
    } // the first call finds all the combos with the current coin and second recursive call just progresses the for loop
    public static int makeChange2(int amt){
        HashSet<String> hs = new HashSet<>();
        System.out.println(" P  N  D  Q\n" + "------------");
        printChange(new int[]{1,5,10,25},amt,0,new int[] {0,0,0,0},hs);
        return hs.size();
    }
    static void printChange(int[] coins ,int amt, int coin, int [] combo, HashSet<String> hs){
      if(coin < coins.length && amt >= 0){
         if(amt == 0){
            hs.add(Arrays.toString(combo));
            System.out.println(Arrays.toString(combo));
            return;
         }
         printChange(coins,amt, coin+1, combo,hs);
         combo[coin]++;
         printChange(coins,amt-coins[coin],coin, combo, hs);
         combo[coin]--;
      }
    }
    static String longestCommonSub(String s1, String s2) {
        return longestCommonSubHelper(s1, s2, 0, 0, "");
    }
    static String longestCommonSubHelper(String s1, String s2, int i, int j, String lcs) {
        // return the lcs if we reach the end of either string
        if (i == s1.length() || j == s2.length())  return lcs;

        // If the current characters in both strings match, include this character in the LCS
        if (s1.charAt(i) == s2.charAt(j))
            return longestCommonSubHelper(s1, s2, i + 1, j + 1, lcs + s1.charAt(i));

        else {
            //Move to the next character in s1
            String lcs1 = longestCommonSubHelper(s1, s2, i + 1, j, lcs);
            // Move to the next character in s2
            String lcs2 = longestCommonSubHelper(s1, s2, i, j + 1, lcs);

            return (lcs1.length() > lcs2.length()) ? lcs1 : lcs2;
        }
    
    }
}