package net.rayxiao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ray Xiao on 9/22/17.
 * LeetCode #22/Medium
 *
 * https://leetcode.com/problems/generate-parentheses/description/
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 */
public class GenerateParentheses {
    public static void main(String[] args){
        List<String> l = GenerateParentheses.generateParenthesis(4);
        l.stream().forEach(s->{System.out.println(s);});
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        String current = "";

        generate(result,current,n,n);
        return result;

    }
    private static void generate(List<String> results,String current,int l,int r){
        if (l==0 && r==0){
            results.add(current);
            return;
        }
        if (l>0) {
            generate(results, current + "(", l - 1, r);
        }
        if (l<r){
            generate(results,current+")",l,r-1);
        }
    }

}
