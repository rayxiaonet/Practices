package net.rayxiao;

import java.util.Stack;

/**
 * LeetCode #84/Hard
 *
 * https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/
 *
 *
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


 Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


 The largest rectangle is shown in the shaded area, which has area = 10 unit.

 For example,
 Given heights = [2,1,5,6,2,3],
 return 10.


 use divide and conquer for O(nlogn)
 or, there is a O(n) solution
 */
public class LargestRectangleInHistogram {
    public static void main(String[] args){
        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }


    public static int largestRectangleArea(int[] height) {
        int len = height.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : height[i]);
            if(s.isEmpty() || h >= height[s.peek()]){
                s.push(i);
            }else{
                int tp = s.pop();
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }
}
