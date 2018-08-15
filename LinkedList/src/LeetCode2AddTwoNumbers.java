import org.w3c.dom.ls.LSException;

import java.util.List;

/**
 *You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */

public class LeetCode2AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cur = new ListNode(0);
        ListNode dummyHead = cur;
        int firstDigit = 0;
        int secondDigit = 0;
        while (l1 != null || l2 != null) {
            int sum = 0;
            if(l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += secondDigit;
            firstDigit = sum % 10;
            secondDigit = sum / 10;
            cur.next = new ListNode(firstDigit);
            if(secondDigit > 0) {
                cur.next.next = new ListNode(secondDigit);
            }
            cur = cur.next;
        }

        return dummyHead.next;
    }

    private static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int x) {
            this.val = x;
        }

    }

    public static void add(ListNode l1, int x) {
        ListNode cur = l1;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new ListNode(x);
    }

    public static String printListNode(ListNode l) {
        StringBuilder ret = new StringBuilder("ListNode: ");
        ListNode cur = l;
        while (cur.next != null) {
            ret.append(cur.val + " -> ");
            cur = cur.next;
        }
        ret.append(cur.val);
        return ret.toString();
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        System.out.println(printListNode(l1));
        ListNode l2 = new ListNode(0);
        add(l2, 8);
        System.out.println(printListNode(l2));

        ListNode ret = addTwoNumbers(l1, l2);
        System.out.println(printListNode(ret));
    }
}
