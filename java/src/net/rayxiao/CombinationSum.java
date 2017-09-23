package net.rayxiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ray Xiao on 9/22/17.
 * <p>
 * LeetCode # 39. Combination Sum /Medium
 * <p>
 * <p>
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
 * <p>
 * The same repeated number may be chosen from C unlimited number of times.
 * <p>
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [2, 3, 6, 7] and target 7,
 * A solution set is:
 * [
 * [7],
 * [2, 2, 3]
 * ]
 */
public class CombinationSum {
    //first, the candiates need to be sorted

    public static void main(String[] args) {
        int[] input = {2, 3, 6, 7};
        List<List<Integer>> result = CombinationSum.combinationSum(input, 7);
        result.stream().forEach(l -> {
            System.out.println(Arrays.toString(l.toArray()));

        });
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> existing = new ArrayList<Integer>();
        int i = 0;

        sumInternal(result, existing, candidates, 0,target);
        return result;
    }

    private static void sumInternal(List<List<Integer>> solutions, List<Integer> existing, int[] candidates, int index, int target) {
        if (target == 0) {
            List<Integer> l = new ArrayList<Integer>();
            l.addAll(existing);
            solutions.add(l);
            return;
        } else if (target < 0) {
            return;
        } else {
            for (int i = index; i < candidates.length; i++) {
                List<Integer> l = new ArrayList<Integer>();
                l.addAll(existing);
                l.add(candidates[i]);
                sumInternal(solutions, l, candidates, i,target - candidates[i]);
            }
        }


    }
}
