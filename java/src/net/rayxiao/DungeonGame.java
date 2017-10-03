package net.rayxiao;

/**
 * LeetCode 174. Dungeon Game
 * https://leetcode.com/problems/dungeon-game/description/
 *
 */

public class DungeonGame {
    public static void main(String[] args){
        int[][] dungeon = new int[][]{
                {-2,-3,3},
            {-5,-10,1},
            {10,30,-5}};
        System.out.println(calculateMinimumHP(dungeon));
    }


    public static int calculateMinimumHP(int[][] dungeon) {
        return 1-iterInternal(dungeon,0,0,0,0);

    }

    private static int iterInternal(int[][] dungeon, int fromX, int fromY,int currentHp,int minHpRequired){

        int newCurrentHp = currentHp+dungeon[fromY][fromX];

        minHpRequired=Math.min(minHpRequired,newCurrentHp);
        if (fromX==dungeon[0].length-1 && fromY==dungeon.length-1){
            return minHpRequired;
        }else {
            int newMin = Integer.MIN_VALUE;
            if (fromX < dungeon[0].length - 1) {
                newMin = Math.max(iterInternal(dungeon, fromX + 1, fromY, newCurrentHp, minHpRequired),newMin);
            }
            if (fromY < dungeon.length - 1) {
                newMin= Math.max(iterInternal(dungeon, fromX, fromY + 1, newCurrentHp, minHpRequired),newMin);
            }
            return newMin;

        }
    }
}
