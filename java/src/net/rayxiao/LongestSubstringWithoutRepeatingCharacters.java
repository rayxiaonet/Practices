package net.rayxiao;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ray Xiao on 9/21/17.
 * Leet Code #3/Medium
 * <p>
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 * <p>
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * <p>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p>
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {

        System.out.println(LongestSubstringWithoutRepeatingCharacters.find("abcabcbb"));
        System.out.println(LongestSubstringWithoutRepeatingCharacters.find("bbb"));
        System.out.println(LongestSubstringWithoutRepeatingCharacters.find("pwwkew"));

    }

    public static int find(String s) {
        int max = 0;
        String maxString = "";
        Set characters = new HashSet<Character>();
        for (int i = 0, j = 0; i < s.length() && j < s.length(); ) {
            Character current = Character.valueOf(s.charAt(j));
            if (characters.contains(current)) {
                //already exists, move i
                characters.remove(Character.valueOf(s.charAt(i)));
                i++;
            } else {
                //not exists, increase max, add this character to set
                characters.add(current);
                if (characters.size() > max) {
                    max = characters.size();
                    maxString = s.substring(i, j + 1);
                    System.out.println("put max string:" + maxString);
                }

                j++;
            }
        }
        return max;
    }
}
