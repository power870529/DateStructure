/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * Note: Do not modify the linked list.
 * Follow up:
 * Can you solve it without using extra space?
 */
public class LeetCode142LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 如果slow == fast，说明有环的存在
            if(slow == fast) {
                slow = head;

                while(slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }
}
