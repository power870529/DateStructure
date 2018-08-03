/**
 * Reverse a singly linked list.
 * Example:
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 *
 * Follow up:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class LeetCode206ReverseLinkedList {

    public static class ListNode {

        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseListIteratively(ListNode head) {
        ListNode prev = head;
        ListNode cur = head.next;
        ListNode temp = null;

        if(head == null) {
            return null;
        }

        while (cur != null) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        head.next = null;
        return prev;
    }

    public ListNode reverseListRecursively(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode rHead = reverseListRecursively(head.next);
        head.next.next = head;
        head.next = null;

        return rHead;
    }

}
