package LeetCodeHot100;

import LeetCodeHot100.common.ListNode;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class MergeTwoSortedLists {

    /**
     * 合并两个有序链表
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head0 = new ListNode();
        ListNode pointer = head0;
        while (list1 != null || list2 != null){
            if (list1 == null){
                pointer.next = list2;
                break;
            }else if (list2 == null){
                pointer.next = list1;
                break;
            }else {
                if (list1.val <= list2.val){
                    pointer.next = list1;
                    list1 = list1.next;
                    pointer = pointer.next;
                }else {
                    pointer.next = list2;
                    list2 = list2.next;
                    pointer = pointer.next;
                }
            }
        }
        return head0.next;
    }
}
