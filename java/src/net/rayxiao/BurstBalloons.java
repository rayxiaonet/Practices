package net.rayxiao;

/**
 * Created by Ray Xiao on 10/15/17.
 *
 * LeetCode #312 Busr Balloons
 * https://leetcode.com/problems/burst-balloons/description/
 *
 */
public class BurstBalloons {
    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};
        System.out.println(maxCoins(nums));
    }


    public static int maxCoins(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int x : iNums) if (x > 0) nums[n++] = x;
        nums[0] = nums[n++] = 1;


        int[][] memo = new int[n][n];
        return burst(memo, nums, 0, n - 1);
    }

    public static int burst(int[][] memo, int[] nums, int left, int right) {
        if (left + 1 == right) return 0;
        //if (memo[left][right] > 0) return memo[left][right];
        int ans = 0;
        for (int i = left + 1; i < right; ++i) {
            int leftVal=burst(memo, nums, left, i);
            int rightVal=burst(memo, nums, i, right);
            int newAns = nums[left] * nums[i] * nums[right]
                    +  leftVal+ rightVal;
            if (newAns>ans){
                ans=newAns;
                System.out.println("new D/C: "+left+":"+i+":"+right+"   "+ans);
                System.out.println("  from "+nums[left] * nums[i] * nums[right]+",+ left "+leftVal+", + right"+rightVal);
            }
        }
        //memo[left][right] = ans;
        return ans;
    }
}
