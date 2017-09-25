package net.rayxiao;

/**
 * Created by Ray Xiao on 9/24/17.
 * <p>
 * LeetCode #72
 * <p>
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
 * <p>
 * You have the following 3 operations permitted on a word:
 * <p>
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 * <p>
 * <p>
 * <p>
 * Dynamic programming
 */
public class EditDistance {
    public static void main(String[] args) {
        String from = "kitfen";
        String to = "sitten";
        System.out.println(minDistance(from, to));

    }

    public static int minDistance(String word1, String word2) {
        return dpInternal(word1, 0, word2, 0, 0);

    }

    private static int dpInternal(String w1, int i1, String w2, int i2, int count) {
        int remaining1 = w1.length() - i1 - 1; //0 means hit end
        int remaining2 = w2.length() - i2 - 1;
        if (remaining1 == 0 && remaining2 == 0) {
            return count;
        }
        if (remaining1 == 0) {
            return count + remaining2;
        }
        if (remaining2 == 0) {
            return count + remaining1;
        }
        if (w1.charAt(i1) == w2.charAt(i2)) {
            return dpInternal(w1, i1 + 1, w2, i2 + 1, count);

        } else {
            int count1 = dpInternal(w1, i1 + 1, w2, i2, count + 1);
            int count2 = dpInternal(w1, i1, w2, i2 + 1, count + 1);
            int count3 = dpInternal(w1, i1 + 1, w2, i2 + 1, count + 1);
            return Math.min(Math.min(count1, count2), count3);
        }
    }


}
