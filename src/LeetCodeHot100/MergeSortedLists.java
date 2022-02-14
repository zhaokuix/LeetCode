package LeetCodeHot100;

import LeetCodeHot100.common.ListNode;

/**
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/
 */
public class MergeSortedLists {

    /**
     * 合并k个有序链表
     * 方法一、循环合并两个有序链表
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head0 = null;
        for (ListNode list : lists) {
            head0 = mergeTwoLists(head0,list);
        }
        return head0;
    }

    /**
     * 方法二、分治算法
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

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
