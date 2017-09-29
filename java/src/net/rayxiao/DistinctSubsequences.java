package net.rayxiao;

/**
 * LeetCode #115/Distince Sequences
 * <p>
 * https://leetcode.com/problems/distinct-subsequences/discuss/
 * <p>
 * <p>
 * use matrix DP
 */
public class DistinctSubsequences {
    public static void main(String[] args) {
        String S = "rabbbit";
        String T = "rabbit";
        System.out.println(numDistinct(S, T));

    }

    /**
     * S    rabbbit
     * 11111111
     * r   01111111
     * a   00111111
     * b   00012333
     * b   00001333
     * i   00000033
     * t   00000003
     */

    public static int numDistinct(String s, String t) {
        int[][] mem = new int[t.length() + 1][s.length() + 1];
        for (int i = 0; i < mem[0].length; i++) {
            mem[0][i] = 1;
        }
        printMatrix(mem);

        for (int i=0;i<t.length();i++) {
            for (int j=0;j<s.length();j++){
                if (s.charAt(j)==t.charAt(i)){
                    mem[i+1][j+1]=mem[i][j]+mem[i+1][j];
                }else{
                    mem[i+1][j+1]=mem[i+1][j];
                }

            }
            printMatrix(mem);
        }

        return mem[mem.length-1][mem[0].length-1];

    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println();
        }
        System.out.println();

    }
}
