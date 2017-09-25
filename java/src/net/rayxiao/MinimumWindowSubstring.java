package net.rayxiao;

/**
 * Created by Ray Xiao on 9/24/17.
 *
 * LeetCode #76/Hard
 *
 * https://leetcode.com/problems/minimum-window-substring/description/
 *
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

 For example,
 S = "ADOBECODEBANC"
 T = "ABC"
 Minimum window is "BANC".

 Note:
 If there is no such window in S that covers all characters in T, return the empty string "".

 If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.


 */
public class MinimumWindowSubstring {
    public static void main(String[] args){
        String S = "ADOBECODEBANC";
        String T = "ABC";
        System.out.println(minWindow(S,T));
    }

    public static String minWindow(String s, String t) {
        int[] needed = new int['Z'];
        int[] found = new int['Z'];
        int count = 0;
        int minFrom = 0;
        int minTo = -1;
        for (char c:t.toCharArray()) {
            needed[c]++;
        }

        for (int start=0,end=0;end<s.length();end++){
            final char c = s.charAt(end);
            if (needed[c]==0){
                //the [end] character is not needed
                continue;
            }
            if (needed[c]>0){
                if (found[c]<needed[c]) {
                    //it's a useful found
                    count++;
                }
                found[c]++;

                if (count==t.length()) {
                    System.out.println("found match from "+start+":"+end);

                    //enough we got for the window, we can shift forward now
                    //move start to next
                    for (int i=start;i<s.length() ;i++){
                        start=i;
                        char toFind = s.charAt(start);
                        if (needed[toFind]>0 && found[toFind]>needed[toFind]) {
                            found[toFind]--;
                        } else if (needed[toFind]>0 && found[toFind]<=needed[toFind]){
                            if (minTo==-1|| (end-start)<(minTo-minFrom) ){
                                minFrom = start;
                                minTo = end;
                            }
                            break;
                        }
                    }
                }

            }
        }
        return minTo==-1?null:s.substring(minFrom,minTo+1);


    }
}
