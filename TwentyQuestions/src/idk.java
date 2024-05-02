import java.util.Arrays;

class idk {
    public static void main(String [] args){
        System.out.println(twoSumLessThanK(new int[] {34,23,1,24,75,33,54,8}, 60));
    }
    public static int twoSumLessThanK(int[] nums, int k) {
        if (nums.length == 1 || k == 1)
            return -1;
        Arrays.sort(nums);
        if (nums[0] + nums[1] >= k)
            return -1;
        int max = 0;
        for (int i = 0; i < nums.length; i++)
            if (k - nums[i] > -1 )
                max = Math.max(bs(nums, k - nums[i],i) + nums[i], max);
        return max;
    }

    static int bs(int[] nums, int t, int i) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] == t) 
                return (mid != 0 && mid-1 != i) ? nums[mid] : Integer.MIN_VALUE;
            if(nums[mid] > t) high = mid-1;
            else low = mid+1;
        }
        return (high != i) ? nums[high] : Integer.MIN_VALUE;
    }
}