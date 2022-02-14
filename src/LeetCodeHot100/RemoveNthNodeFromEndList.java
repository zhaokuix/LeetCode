package LeetCodeHot100;

import LeetCodeHot100.common.ListNode;

/**
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodeFromEndList {
    /**
     * 删除链表中倒数第N个节点。
     * 快慢指针，快指针先走N步，然后快慢指针一起走，快指针走到头以后，慢指针所在节点即要删除的节点。
     * 为了方便删除，新建一个空头节点，慢指针指向空头节点，这样遍历完后慢指针的next就是要删除的节点
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode head0 = new ListNode();
        head0.next = head;
        ListNode slowPointer = head0;
        ListNode fastPointer = head;
        //快指针先走N步
        for (int i = 1; i < n && fastPointer.next != null; i++) {
            fastPointer = fastPointer.next;
        }
        //快指针走到头
        while (fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }
        //删除节点
        if (slowPointer.next != null){
            slowPointer.next = slowPointer.next.next;
        }
        return head0.next;
    }
}