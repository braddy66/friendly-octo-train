import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class WelcomeBack {
    String getMiddle(String str){
       return str.length()%2 == 1 ? str.substring(str.length()/2, str.length()/2+1) : str.substring(str.length()/2-1, str.length()/2+1);
    }
    int[] sumNumbers(int n){
        int[] arr = new int[n+1];
        arr[0]= 0;
        for(int x = 1; x < n+1; x++){
            arr[x] = arr[x-1]+x;
        }
        return arr;
    }
    int sumDigits(int n){
        if(n == 0)
            return n;
        return sumDigits(n/10) + n%10;
    }
    int keepSumminDigits(int n){
        if(n/10 == 0)
            return n;
        return keepSumminDigits(sumDigits(n));
    }
    String getIntersection(int [] a , int[] b){
        String s = "";
        for(int x = 0; x < a.length;x++){
            for(int y = 0; y < b.length;y++){
                if(a[x] == b[y] && !s.contains(""+a[x]))
                    s+=a[x];
            }
        }
        return s;
    }
    Map<Integer, Integer> mapLengths(String [] words){
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (String word : words) {
            if (hm.containsKey(word.length()))
                hm.put(word.length(), hm.get(word.length()) + 1);
            else
                hm.put(word.length(), 1);

        }
        return hm;

    }
    int sumDigitsRecur (int n){
        return n/10 == 0 ? n : sumDigitsRecur(n/10)+n%10;
    }
    int sumWithoutCarry(int a, int b){
        int sum = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        while(a == 0 && b ==0){
            arr.add((a%10+b%10)%10);
            a/=10;
            b/=10;

        }
        for(int x : arr){
            sum+=x;
            sum*=10;
        }

        return sum;
    }
    int buySell(int [] stock){
       int p = 0;
				int min = Integer.MAX_VALUE;
				for(int num : stock){
					p = Math.max(p, num-min);
					min = Math.min(min,num);
				}
		return p;
    }
    void zeck(String fileName) throws FileNotFoundException{
        File f = new File(fileName);
        Scanner s = new Scanner(f);
        while(s.hasNextLine()){
            int x = s.nextInt();
            Integer[] nums = GetFibs(x);
            String line = x+" = ";
            if(nums[nums.length-1] == x)
                line+=x;
            else{
                x-=nums[nums.length-1];
                line+=nums[nums.length-1]+" ";
                int y = -1;
                while(y!= x){
                    y = Arrays.binarySearch(nums,x);
                    x-=y;
                    line+= y+ " ";
                }
            }
            System.out.println(line);
            
        }
 
    }
     Integer[] GetFibs(int n){
        ArrayList<Integer> fibs = new ArrayList<Integer>();
        fibs.add(0);
        fibs.add(1);

        while(fibs.get(fibs.size()-1)+fibs.get(fibs.size()-2) < n){
            fibs.add(fibs.get(fibs.size()-1)+fibs.size()-2);
        }
         Integer[] array = fibs.toArray(new Integer[fibs.size()]);
        return array;

    }
    



}
