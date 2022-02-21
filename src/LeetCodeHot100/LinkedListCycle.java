package LeetCodeHot100;

import LeetCodeHot100.common.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

    /**
     * 判断链表是否有环
     *
     */
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        ListNode head0 = new ListNode();
        head0.next = head;
        boolean flag = false;
        while (head0.next != null){
            head0 = head0.next;
            nodes.add(head0);
            if (head0.next != null && nodes.contains(head0.next)){
                flag = true;
                break;
            }
        }
        return flag;
    }
}
