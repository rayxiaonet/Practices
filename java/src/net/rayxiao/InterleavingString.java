package net.rayxiao;

/**
 * LeetCode #97/Hard
 * <p>
 * 97. Interleaving String
 * https://leetcode.com/problems/interleaving-string/solution/
 * <p>
 * <p>
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * <p>
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * <p>
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 * <p>
 * <p>
 * <p>
 * Start with a simple recursion solution first
 * Then Recursion with memorization
 */


public class InterleavingString {

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        String s4 = "aadbbbaccc";
        System.out.println(isInterleave(s1, s2, s3));
        System.out.println(isInterleave(s1, s2, s4));
        System.out.println("method 2");
        System.out.println(isInterleave2(s1, s2, s3));
        System.out.println(isInterleave2(s1, s2, s4));

    }
    private static int count1=0,count2=0;

    public static boolean isInterleave(String s1, String s2, String s3) {
        boolean result = isILInternal(s1, 0, s2, 0, s3, 0, "");
        System.out.println("looping count:"+count1);
        return result;

    }

    public static boolean isILInternal(String s1, int i1, String s2, int i2, String s3, int i3, String result) {
        count1++;
        if (i1 == s1.length() && i2 == s2.length()) {
            System.out.println(i1 + "," + i2 + "," + i3);
            System.out.println(result);
            return true;
        }
        if (i1 < s1.length() && s1.charAt(i1) == s3.charAt((i1 + i2))) {
            if (isILInternal(s1, i1 + 1, s2, i2, s3, i3 + 1, result + s1.charAt(i1)))
                return true;

        }
        if (i2 < s2.length() && s2.charAt(i2) == s3.charAt((i1 + i2))) {
            if (isILInternal(s1, i1, s2, i2 + 1, s3, i3 + 1, result + s2.charAt(i2)))
                return true;
        }
        return false;

    }


    public static boolean isInterleave2(String s1, String s2, String s3) {
        int[][] mem = new int[s1.length()+1][s2.length()+1];
        boolean result = isILInternal2(s1, 0, s2, 0, s3, 0, mem);
        System.out.println("looping count:"+count2);
        return result;

    }

    public static boolean isILInternal2(String s1, int i1, String s2, int i2, String s3, int i3, int[][] mem) {
        count2 ++;
        if (i1 == s1.length() && i2 == s2.length()) {
            System.out.println(i1 + "," + i2 + "," + i3);
            return true;
        }
            if (mem[i1][i2] == -1) {
                return false;
            }
            if (mem[i1][i2] == 1) {
                return true;
            }
        boolean matchS2 = false;
        if (i1 < s1.length() && s1.charAt(i1) == s3.charAt((i1 + i2))) {
            if (isILInternal2(s1, i1 + 1, s2, i2, s3, i3 + 1, mem)) {
                mem[i1][i2] = 1;
                return true;
            }
        }
        if (i2 < s2.length() && s2.charAt(i2) == s3.charAt((i1 + i2))) {
            if (isILInternal2(s1, i1, s2, i2 + 1, s3, i3 + 1, mem)) {
                mem[i1][i2] = 1;
                return true;
            }
        }
        return false;

    }
}

