package net.rayxiao;

/**
 *
 * 209. Minimum Size Subarray Sum
 *
 * https://leetcode.com/problems/minimum-size-subarray-sum/discuss/
 *
 *
 */

public class MinimumSizeSubarraySum {
    public static void main(String[] args ){
        int[] a = new int[]{2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7,a));
    }


    public static int minSubArrayLen(int s, int[] a) {
        if (a == null || a.length == 0)
            return 0;

        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;

        while (j < a.length) {
            sum += a[j];
            j++;
            while (sum >= s) {
                min = Math.min(min, j - i);
                sum -= a[i];
                i++;
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
