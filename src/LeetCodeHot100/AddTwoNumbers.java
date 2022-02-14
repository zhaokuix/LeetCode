package LeetCodeHot100;

import LeetCodeHot100.common.ListNode;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {
    /**
     * 大数的加法
     * Input: l1 = [2,4,3], l2 = [5,6,4]
     * Output: [7,0,8]
     * Explanation: 342 + 465 = 807.
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        ListNode temp = ans;
        int one = 0;
        //l1和l2能长度重合的部分处理
        while (l1 != null && l2 != null){
            int add = l1.val + l2.val + one;
            if (add < 10){
                temp.val = add;
                l1 = l1.next;
                l2 = l2.next;
                one = 0;
            }else {
                temp.val = add % 10;
                l1 = l1.next;
                l2 = l2.next;
                one = 1;
            }
            if (l1 == null && l2 != null){
                temp.next = l2;
            }else if (l1 != null && l2 == null){
                temp.next = l1;
            }else if (l1 != null && l2 != null){
                temp.next = new ListNode();
                temp = temp.next;
            }
        }
        //l1和l2能长度不重合的部分处理
        while (temp.next != null && one == 1){
            temp = temp.next;
            int add = temp.val + one;
            if (add < 10){
                temp.val = add;
                one = 0;
            }else {
                temp.val = add % 10;
                one = 1;
            }
        }
        //处理最后一个节点
        if (one == 1){
            temp.next = new ListNode(one);
        }
        return ans;
    }

    /**
     * 大数的加法，精简代码
     * Input: l1 = [2,4,3], l2 = [5,6,4]
     * Output: [7,0,8]
     * Explanation: 342 + 465 = 807.
     */
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        ListNode temp = ans;
        int addNum = 0;
        //l1和l2能长度无法重合的部分用0来处理，这样就不需要分步骤处理了,最后一个节点，l1==null并且l2==null时用addNum != 0的条件来处理
        while (l1 != null || l2 != null || addNum != 0){
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int z = x + y + addNum;
            temp.next = new ListNode(z % 10);
            temp = temp.next;
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
            addNum = z / 10;
        }
        return ans.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(7);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(2);

        ListNode listNode = addTwoNumbers2(l1, l2);
        while (listNode != null){
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }

    }
}
//class ListNode {
//     int val;
//     ListNode next;
//     ListNode() {}
//     ListNode(int val) { this.val = val; }
//     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
// }
