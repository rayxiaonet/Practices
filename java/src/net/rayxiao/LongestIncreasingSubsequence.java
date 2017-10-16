package net.rayxiao;

import java.util.Arrays;

/**
 * Created by Ray Xiao on 10/15/17.
 *
 * LeetCode #300
 *
 * This is a very smart solution!
 *
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args){
        int[] nums = {3,4,-1,5,8,2,3,12,7,9,10};
        // 3,4
        //-1,4
        //-1,4,5
        //-1,4,5,8
        //-1,2,5,8
        //-1,2,3,8
        //-1,2,3,8,12
        //-1,2,3,7,12
        //-1,2,3,7,9
        //-1,2,3,7,9,10
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }

        return len;
    }
}
