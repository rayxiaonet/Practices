package net.rayxiao;

/**
 * LeetCode 151
 * Given an input string, reverse the string word by word.

 For example,
 Given s = "the sky is blue",
 return "blue is sky the".

 Update (2015-02-12):
 For C programmers: Try to solve it in-place in O(1) space.
 */
public class ReverseWordsInAString {
    public static void main(String[] args){
        String s="the sky is blue";
        System.out.println(reverseWords(s));

    }

    public static String reverseWords(String s) {
        return revInternal(s);

    }

    private static String revInternal(String existing) {
        if (existing.length()>0) {
            for (int i=0;i<existing.length();i++) {
                if (' '==existing.charAt(i)) {
                    return revInternal(existing.substring(i+1)) + " "+ existing.substring(0,i);
                }
            }
            //remainer is a whole word
            return existing;
        }else return "";
    }
}
