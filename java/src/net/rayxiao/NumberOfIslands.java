package net.rayxiao;

/**
 * LeetCode #200 Number of Islands
 * https://leetcode.com/problems/number-of-islands/description/
 */

public class NumberOfIslands {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}};

        System.out.println(numIslands(grid));

    }

    public static int numIslands(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    iter(grid,i,j);
                    result++;
                }
            }
        }
        return result;
    }

    private static void iter(int[][] grid,int i,int j) {
        if (i<0 || j<0|| i>=grid.length || j>=grid[0].length||grid[i][j]==0){
            return;
        }
        grid[i][j]=0;
        iter(grid,i+1,j);
        iter(grid,i-1,j);
        iter(grid,i,j+1);
        iter(grid,i,j-1);
        return;
    }
}
