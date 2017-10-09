package net.rayxiao;

import java.util.*;

/**
 * 218. The Skyline Problem
 * https://leetcode.com/problems/the-skyline-problem/discuss/
 */
public class SkyLine {

    public static void main(String[] args) {
        int[][] buildings = {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}};
        getSkyLine(buildings).stream().forEach(s -> System.out.println(Arrays.toString(s)));

    }

    private static List<int[]> getSkyLine(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for (int[] b : buildings) {
            height.add(new int[]{b[0], b[2]});
            height.add(new int[]{b[1], -b[2]});
        }
        Collections.sort(height, (a, b) -> {
            if (a[0] != b[0])
                return a[0]-b[0];
            return b[1]-a[1];
        });
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b-a));
        pq.offer(0);
        int prev = 0;
        for (int[] h : height) {
            if (h[1] > 0) {
                pq.offer(h[1]);
            } else {
                pq.remove(-h[1]);
            }
            int cur = pq.peek();
            if (prev != cur) {
                result.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        return result;

    }
}
