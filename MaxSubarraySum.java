public class MaxSubarraySum {
    
    public static int getMaxSum(int[] nums) {

        int maxSum = nums[0];
        int curSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            curSum = Math.max(nums[i] + curSum, nums[i]);
            System.out.println(curSum);
            maxSum = Math.max(curSum, maxSum);
        }

        return maxSum;
    }

    public static void main(String args[]) {
        int[] test1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] test2 = {1};
        int[] test3 = {5, 4, -1, 7, 8};

        System.out.println(getMaxSum(test1)); // 6
        //System.out.println(getMaxSum(test2)); // 1
        //System.out.println(getMaxSum(test3)); // 23
    }
}
