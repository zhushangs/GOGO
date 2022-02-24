package DP;

public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        //dp[i] means the maximum subarray ending with A[i];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];

        for(int i = 1; i < nums.length; i++){
            dp[i] = Math.max(nums[i] + dp[i - 1] , nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

/*
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

Input: nums = [1]
Output: 1

 */