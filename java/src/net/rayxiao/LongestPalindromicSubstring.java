package net.rayxiao;

/**
 * Created by Ray Xiao on 9/21/17.
 * LeetCode #5/Medium
 * https://leetcode.com/problems/longest-palindromic-substring/solution/
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example:
 * <p>
 * Input: "babad"
 * <p>
 * Output: "bab"
 * <p>
 * Note: "aba" is also a valid answer.
 * Example:
 * <p>
 * Input: "cbbd"
 * <p>
 * Output: "bb"
 *
 *
 *
 *
 *
 * Solution Time complexity O(Log(N^2))
 */
public class LongestPalindromicSubstring {
    // iterate all possibilities through center of the potential palindromic string

    public static void main(String args[]) {
        System.out.println(LongestPalindromicSubstring.find("babab"));
        System.out.println(LongestPalindromicSubstring.find("cbbd"));

    }

    public static String find(String s) {
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            String s1= findLongestPalindrom(s, i, i);
            String s2=findLongestPalindrom(s, i, i + 1);
            if (s1.length()>s2.length() && s1.length()>result.length()){
                result=s1;
            }
            if (s2.length()>s1.length() && s2.length()>result.length()){
                result=s2;
            }

        }
        return result;
    }

    private static String findLongestPalindrom(String s, int left, int right) {
        for (; left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right); ) {
            left--;
            right++;

        }
        return s.substring(left+1,right);
    }


}
