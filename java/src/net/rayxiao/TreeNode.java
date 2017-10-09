package net.rayxiao;

class TreeNode {
    /**
     * Definition for a binary tree node.
     */
    int val;
    TreeNode left;
    TreeNode right;
    String name;

    TreeNode(int x) {
        val = x;
    }

    TreeNode(int x, String name) {
        val = x;
        this.name = name;}

}
