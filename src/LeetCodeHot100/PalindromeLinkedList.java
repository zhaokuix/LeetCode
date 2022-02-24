package LeetCodeHot100;

import LeetCodeHot100.common.ListNode;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * 回文链表
 */
public class PalindromeLinkedList {

    /**
     * 回文链表
     * 1、找到中间节点
     * 2、左侧链表转置
     * 顺序遍历左右链表看是否完全相同
     */
    public static boolean isPalindrome(ListNode head) {
        //计算链表个数
        ListNode dummyNode = head;
        int size = 0;
        while (dummyNode != null){
            size++;
            dummyNode = dummyNode.next;
        }
        if (size <= 1){
            return true;
        }

        if (size % 2 == 0){
            int left = size >> 1;
            ListNode point = head;
            while (left > 1){
                point = point.next;
                left--;
            }
            ListNode rightStart = point.next;
            point.next = null;
            //转置左侧链表
            ListNode leftStart = reverse(head);
            while (leftStart != null && rightStart != null && leftStart.val == rightStart.val){
                leftStart = leftStart.next;
                rightStart = rightStart.next;
            }
            return leftStart == null && rightStart == null;
        }else {
            int left = size >> 1;
            ListNode point = head;
            while (left > 1){
                point = point.next;
                left--;
            }
            ListNode rightStart = point.next.next;
            point.next = null;
            //转置左侧链表
            ListNode leftStart = reverse(head);
            while (leftStart != null && rightStart != null && leftStart.val == rightStart.val){
                leftStart = leftStart.next;
                rightStart = rightStart.next;
            }
            return leftStart == null && rightStart == null;
        }
    }

    public static ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode current = head;
        while (current != null){
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        //[1,2,2]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
//        head.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head));
    }
}
