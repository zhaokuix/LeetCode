package LeetCodeHot100;

import LeetCodeHot100.common.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 */
public class IntersectionTwoLinkedLists {

    /**
     * 给你两个单链表的头节点 headA 和 headB ，
     * 请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
     *
     * 方法一：借用Set遍历,时间复杂度O(n)
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode ans = null;
        HashSet<ListNode> set = new HashSet<>();

        ListNode head0 = headA;
        while (head0 != null){
            set.add(head0);
            head0 = head0.next;
        }
        head0 = headB;
        while (head0 != null){
            if (set.contains(head0)){
                ans = head0;
                break;
            }
            head0 = head0.next;
        }
        return ans;
    }

    /**
     * 双指针
     * 定义两个指针pA、pB指向两条链表的头部
     * 两根指针同时移动，
     * 当pA == null 时让pA = headB
     * 当pB == null 时让pB = headA
     * 第一轮遍历可以抹除两者的长度差，
     * 第二轮遍历如果相交返回交点，如果不相交最后pA、pB都变成null，两个链表没有故事
     *
     * 请一定要珍惜身边的那个 ta 啊！你们之所以相遇，正是因为你走了 ta 走过的路，而 ta 也刚好走了你走过的路。这是何等的缘分！
     * 而当你们携手继续走下去时，你会慢慢变成 ta 的样子，ta 也会慢慢变成你的样子。
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
