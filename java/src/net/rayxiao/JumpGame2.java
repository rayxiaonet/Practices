package net.rayxiao;

/**
 * Created by Ray Xiao on 9/24/17.
 * <p>
 * LeetCode #45/Hard
 * https://leetcode.com/problems/jump-game-ii/description/
 * <p>
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p>
 * For example:
 * Given array A = [2,3,1,1,4]
 * <p>
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 * <p>
 * Note:
 * You can assume that you can always reach the last index.
 * <p>
 * <p>
 * a. BFS
 * <p>
 * b. greedy (can we get the global optimal result by greedy?)
 */
public class JumpGame2 {
    public static void main(String[] args) {
        int[] input = {2, 4, 1, 1, 1, 3, 6};
        System.out.println(jumpBfs(input));
        System.out.println(jumpGreedy(input));
    }

    private static int countMax = -1;
    private static String pathMax = "";

    public static int jumpBfs(int[] input) {
        dfsInternal(input, 0, "", 0);
        System.out.println(pathMax);
        return countMax;

    }

    private static void dfsInternal(int[] input, int current, String path, int count) {
        if (countMax != -1 && count >= countMax) {
            return;
        }
        if (current == input.length - 1) {
            countMax = count;
            pathMax = path;
            return;
        }
        for (int i = 1; i <= input[current] && current + i < input.length; i++) {
            dfsInternal(input, current + i, path + "," + input[current], count + 1);
        }

    }

    //greedy

    public static int jumpGreedy(int[] input){
        int current=0;
        int jumps=0;
        int currentJumped=0;
        int currentMostReachable = 0;
        for (int i=0;i<input.length-1;i++) {
            //current jumpable =input[i];
            currentMostReachable=Math.max(currentMostReachable,i+input[i]);
            if (i==currentJumped){
                jumps++;
                currentJumped = currentMostReachable;
            }
        }
        return jumps;
    }

}
