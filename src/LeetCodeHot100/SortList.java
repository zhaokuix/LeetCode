package LeetCodeHot100;

import LeetCodeHot100.common.ListNode;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/sort-list/
 */
public class SortList {

    /**
     * 链表排序
     * 方法一：归并排序（使用递归）
     * 链表排序使用到的工具
     * 1、合并两条有序链表
     * 2、链表分割
     */
    public ListNode sortList(ListNode head) {
        return merge(head);
    }

    public ListNode merge(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        //快慢指针将链表分割为两部分
        ListNode slow = head;
        //fast必须指向next.next,否则递归过程中，slow无法指向头节点
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rightStart = slow.next;
        slow.next = null;
        ListNode left = merge(head);
        ListNode right = merge(rightStart);
        return mergeTwoLists(left, right);
    }
    /**
     * 合并两条有序链表
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode dummyNode = new ListNode();
        ListNode point = dummyNode;
        while (list1 != null && list2 != null){
            if (list1.val <= list2.val){
                point.next = list1;
                list1 = list1.next;
                point = point.next;
            }else {
                point.next = list2;
                list2 = list2.next;
                point = point.next;
            }
        }
        if (list1 == null){
            point.next = list2;
        }else {
            point.next = list1;
        }
        return dummyNode.next;
    }

    /**
     * 链表排序
     * 方法一：归并排序（自底向上归并，不使用递归）
     * 链表排序使用到的工具
     * 1、合并两条有序链表
     * 2、链表分割
     */
    public ListNode sortList2(ListNode head) {
        return merge(head);
    }

    public ListNode merge2(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode sizePoint = head;
        //计算节点个数
        int size = 0;
        while (sizePoint != null){
            ++size;
            sizePoint = sizePoint.next;
        }
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        //i = i<<1相当于 i = i*2
        for (int i = 1; i <= size; i = i<<1) {
            ListNode point = dummyNode.next;
            ListNode head0 = dummyNode;
            while (point != null){
                //左链
                ListNode l1 = point;
                for (int l1Index = 1; l1Index < i && point.next != null; l1Index++) {
                    point = point.next;
                }
                //右链
                ListNode l2 = point.next;
                //断开左链
                point.next = null;
                point = l2;
                for (int l1Index = 1; l1Index < i && point != null && point.next != null; l1Index++) {
                    point = point.next;
                }
                if (point != null){
                    ListNode tmp = point.next;
                    //截断右链
                    point.next = null;
                    point = tmp;
                }
                //合并左右链
                head0.next = mergeTwoLists(l1, l2);
                while (head0.next != null){
                    head0 = head0.next;
                }
            }
        }
        return dummyNode.next;
    }
}
