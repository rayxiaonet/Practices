package net.rayxiao;

import java.util.Stack;

/**
 * Created by Ray Xiao on 9/22/17.
 * LeetCode #25/Hard
 * https://leetcode.com/problems/reverse-nodes-in-k-group/description/
 * <p>
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * <p>
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * <p>
 * Only constant memory is allowed.
 * <p>
 * For example,
 * Given this linked list: 1->2->3->4->5
 * <p>
 * For k = 2, you should return: 2->1->4->3->5
 * <p>
 * For k = 3, you should return: 3->2->1->4->5
 * <p>
 * <p>
 * This looks a pretty straight forward one to me. use stack for reverse anything
 */
public class ReverseNodesInkGroup {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode a1 = new ListNode(2);
        ListNode a2 = new ListNode(3);
        ListNode a3 = new ListNode(4);
        ListNode a4 = new ListNode(5);
        head.next = a1;
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;

        output(ReverseNodesInkGroup.reverseKGroup(head, 3));

    }

    private static void output(ListNode n) {
        System.out.println();
        while (n != null) {
            System.out.print("=>" + n.val);
            n = n.next;
        }
        System.out.println();

    }

//1->2->3->4->5 , 2
//
//      +current
//newheader=2
//gp:2
//    2->1

    public static ListNode reverseKGroup(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode current = head;
        ListNode newHead = null;
        ListNode groupPointer = null;
        while (current != null) {
            while (stack.size() < k) {
                stack.push(current);
                if (current.next == null) {
                    return newHead;
                }
                current = current.next;
            }
            if (k == stack.size()) {
                //one group has completed successfuly
                if (newHead == null) {
                    newHead = stack.peek();
                } else {
                    groupPointer.next = stack.peek();
                }

                groupPointer = stack.pop();
                while (!stack.isEmpty()) {
                    groupPointer.next = stack.peek();
                    groupPointer = stack.pop();
                }
                groupPointer.next = current;

            }
            //otherwise it's quit without finish a new group
        }

        return newHead;
    }
}
