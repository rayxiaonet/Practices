package net.rayxiao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ray Xiao on 9/21/17.
 * <p>
 * LeetCode #10/Hard
 * <p>
 * Implement regular expression matching with support for '.' and '*'.
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * <p>
 * The matching should cover the entire input string (not partial).
 * <p>
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * <p>
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 */
public class RegularExpressionMatching {
    private static class PatternToken {
        private char character;
        private char type;

        public PatternToken(char character, char type) {
            this.character = character;
            this.type = type;
        }

        public char getCharacter() {
            return this.character;
        }

        public char getType() {
            return this.type;
        }
    }

    public static void main(String[] args) {
        System.out.println(RegularExpressionMatching.isMatch("aaa", "aa"));

    }

    private static boolean isMatch(String s, String pattern) {
        List<PatternToken> patterns = new ArrayList<PatternToken>();
        //pre-process for pattern
        for (int i = 0; i < pattern.length(); i++) {
            if (i + 1 < pattern.length() && '*' == pattern.charAt(i + 1)) {
                patterns.add(new PatternToken(pattern.charAt(i), pattern.charAt(i++ + 1)));

            } else if (i + 1 < pattern.length() && '.' == (pattern.charAt(i + 1))) {
                patterns.add(new PatternToken(pattern.charAt(i), pattern.charAt(i++ + 1)));
            } else {
                patterns.add(new PatternToken(pattern.charAt(i), 'X'));
            }
        }

        return isMatchInternal(s, 0, patterns, 0);
    }

    private static boolean isMatchInternal(String s, int from, List<PatternToken> patterns, int patternFrom) {
        if (patterns.size() <= patternFrom ) {
            if (s.length()<=from)
                return true;
            else
                return false;

        }
        PatternToken token = patterns.get(patternFrom);
        if (token.getType() == '*') {
            //is asterisk
            return (s.charAt(from) == token.getCharacter() && isMatchInternal(s, from + 1, patterns, patternFrom)) ||
                    (s.charAt(from) != token.getCharacter() && isMatchInternal(s, from, patterns, patternFrom + 1));

        } else if (token.getType() == '.') {
            return isMatchInternal(s, from + 1, patterns, patternFrom + 1);
        } else {
            return s.charAt(from) == token.getCharacter() && isMatchInternal(s, from + 1, patterns, patternFrom + 1);
        }
    }
}
