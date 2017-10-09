package net.rayxiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Path Sum 2
 * LeetCode #113
 *
 */
public class PathSum2 {


    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n4= new TreeNode(4);
        TreeNode n4_2= new TreeNode(4);
        TreeNode n5= new TreeNode(5);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8= new TreeNode(8);
        TreeNode n11 = new TreeNode(11);
        TreeNode n13 = new TreeNode(13);
        root.left=n4;
        root.right=n8;
        n4.left=n11;
        n11.left=n7;
        n11.right=n2;
        n8.left=n13;
        n8.right=n4_2;
        n4_2.left=n5;
        n4_2.right=n1;

        List<List<Integer>> result = pathSum(root,22);
        for (List<Integer> l:result){
            System.out.println(Arrays.toString(l.toArray()));
        }
    }


    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        iter(root,sum,result,current);
        return result;

    }

    private static void iter (TreeNode rootNode,int target,List<List<Integer>> result,List<Integer> current ){
        if (rootNode.left==null && rootNode.right==null){
            if (rootNode.val==target){
                current.add(rootNode.val);
                result.add(new ArrayList<>(current));
                current.remove(current.size()-1);
            }
            return;
        }
        if (rootNode.val>target ){
            return;
        }else{
            current.add(rootNode.val);
            if (rootNode.left!=null) iter(rootNode.left,target-rootNode.val,result,current);
            if (rootNode.right!=null) iter(rootNode.right,target-rootNode.val,result,current);
            current.remove(current.size()-1);

        }
        return;
    }
}
