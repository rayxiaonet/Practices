package net.rayxiao;


/**
 * LeetCode #250 Count Univalue Substrees
 * <p>
 * https://leetcode.com/problemset/all/
 */
public class CountUnivalueSubtrees {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, "root");
        TreeNode n1 = new TreeNode(1, "n1");
        TreeNode n2 = new TreeNode(5, "n2");
        TreeNode n3 = new TreeNode(5, "n3");
        TreeNode n4 = new TreeNode(5, "n4");
        TreeNode n5 = new TreeNode(5, "n5");
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.right = n5;
        System.out.println(count(root));
    }

    private static int count = 0;

    private static int count(TreeNode root) {
        isUni(root, -1);
        return count;
    }

    private static boolean isUni(TreeNode n, int parentValue) {
        boolean b1=true, b2=true;
        if (n.left == null && n.right == null) {
            count++;
            return true;
        }
        if (n.left != null) {
            b1 = isUni(n.left, n.val);
        }
        if (n.right != null) {
            b2 = isUni(n.right, n.val);
        }
        boolean r= b1 && b2 && n.val==parentValue;
        if (r) count++;
        return r;

    }


}
