package net.rayxiao;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode #212   Word Search II
 * <p>
 * https://leetcode.com/problems/word-search-ii/description/
 */
public class WordSearchII {
    static class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

    public static void main(String[] args) {
        char[][] board =
                {{'o', 'a', 'a', 'n'},
                 {'e', 't', 'a', 'e'},
                 {'i', 'h', 'k', 'r'},
                 {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};

        findWords(board, words).stream().forEach(System.out::println);
    }

    public static List<String> findWords(char[][] board, String[] words) {
        TrieNode trieWords = initTrie(words);
        List<String> result = new ArrayList<>();
        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board.length;j++){
                dfs(board,i,j,trieWords,result);
            }
        }
        return result;
    }
    private static TrieNode initTrie(String[] words){
        TrieNode root = new TrieNode();
        for (String w:words){
            TrieNode node = root;

            for (char c:w.toCharArray()){
                int i=c-'a';
                if (node.next[i]==null) {
                    node.next[i]=new TrieNode();
                    node=node.next[i];
                }
            }
            node.word=w;
        }
        return root;
    }

    private static void dfs(char[][] board,int i,int j,TrieNode trie, List<String> results) {
        char c = board[i][j];
        if (c=='!'){
            //it's already visited in current stack
            return;
        }
        if (trie.next[c-'a']==null){
            //reach the end of trie, no match found
            return;
        }
        trie=trie.next[c-'a'];
        if (trie.word!=null){
            results.add(trie.word);
            //dedupe
            trie.word=null;
        }
        board[i][j]='!';
        if (i>0) dfs(board,i-1,j,trie,results);
        if (i<board.length-1) dfs(board,i+1,j,trie,results);
        if (j>0) dfs(board,i,j-1,trie,results);
        if (j<board[0].length-1) dfs(board,i,j+1,trie,results);
        board[i][j]=c;

    }
}
