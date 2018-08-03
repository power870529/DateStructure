/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 *
 * Note: 1 ≤ m ≤ n ≤ length of list.
 *
 * Example:
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */
public class LeetCode92ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
/*
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode subListHead = dummyHead;
        int k = 1;
        // k先和m比较，后++
        while(k++<m){
            subListHead = subListHead.next;
        }

        ListNode subListIter = subListHead.next;
        while(m++<n){
            ListNode temp = subListIter.next;
            subListIter.next = temp.next;
            temp.next = subListHead.next;
            subListHead.next = temp;
        }

        return dummyHead.next;*/

        int k = 1;
        while (k ++ < 2) {
            System.out.println(k);
        }
        ListNode prevM = new ListNode(-1);
        prevM.next = head;
        ListNode dummyHead = prevM;

        if((head == null) || (head.next == null) || (m == n)) {
            return head;
        }
        for(int i = 0; i < m - 1; i ++) {
            prevM = prevM.next;
        }
        ListNode nodeM = prevM.next;
        ListNode cur = nodeM.next;
        nodeM.next = null;
        ListNode temp = null;
        for(int i = m; i < n; i ++) {
            temp = cur.next;
            cur.next = nodeM;
            nodeM = cur;
            cur = temp;
        }
        prevM.next.next = cur;
        prevM.next = nodeM;
        return dummyHead.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1 );
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        LeetCode92ReverseLinkedListII list = new LeetCode92ReverseLinkedListII();
        ListNode slow = list.reverseBetween(head, 2, 4);
    }
}
