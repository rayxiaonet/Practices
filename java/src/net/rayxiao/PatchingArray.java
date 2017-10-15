package net.rayxiao;

/**
 * Created by Ray Xiao on 10/15/17.
 *
 * LeetCode #330
 * https://leetcode.com/problems/patching-array/description/
 */
public class PatchingArray {

    public static void main(String[] args){
        int[] nums = {1, 5, 10};
        System.out.println(minPatches(nums,20));


    }
    public static int minPatches(int[] nums, int target) {
        int current = 1;
        int result = 0;
        int i=0;
        while(current<=target) {
            if (current>=nums[i] &&i<nums.length){
                current+=nums[i];
                i++;
            }else{
                result++;
                current=current*2;
            }
        }
        return result;

    }
}




