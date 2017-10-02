package net.rayxiao;

import java.util.*;


/**
 * 140. Word Break II
 * Hard
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. You may assume the dictionary does not contain duplicate words.
 * <p>
 * Return all such possible sentences.
 * <p>
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * <p>
 * A solution is ["cats and dog", "cat sand dog"].
 */
public class WordBreakII {
    public static void main(String[] args) {
        String s = "catsanddog";
        Set<String> dict = new HashSet<String>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");
        List<String> result = wordBreak(s,dict);
        for (String s1:result){
            System.out.println(s1);
        }

    }

    public static List<String> wordBreak(String s, Set<String> wordDict) {
        return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
    }

    // DFS function returns an array including all substrings derived from remainder.
    private static List<String>  DFS(String remainder, Set<String> wordDict, HashMap<String, LinkedList<String>> map) {
        if (map.containsKey(remainder))
            return map.get(remainder);

        LinkedList<String>result = new LinkedList<>();
        if (remainder.length() == 0) {
            result.add("");
            return result;
        }
        for (String word : wordDict) {
            if (remainder.startsWith(word)) {
                List<String>sublist = DFS(remainder.substring(word.length()), wordDict, map);
                for (String sub : sublist)
                    result.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(remainder, result);
        return result;
    }
}
