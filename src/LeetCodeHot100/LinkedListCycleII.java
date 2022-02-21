package LeetCodeHot100;

import LeetCodeHot100.common.ListNode;

import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 */
public class LinkedListCycleII {

    /**
     * 给定一个链表的头节点  head ，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
     */
    public ListNode detectCycle(ListNode head) {
        ListNode node = new ListNode();
        node.next = head;
        HashSet<ListNode> set = new HashSet<>();
        while (node.next != null){
            node = node.next;
            set.add(node);
            if (node.next != null && set.contains(node.next)){
                return node.next;
            }
        }
        return null;
    }
}
