public class LeetCode203SolutionByRecursion {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {

        if(head == null) {
            return null;
        }

        // last version
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;

        // second version
/*        head.next = removeElements(head.next, val);
        if(head.val == val) {
            return head.next;
        } else {
            return head;
        }*/

        // first version
        /* ListNode res = removeElements(head.next, val);

        if(head.val == val) {
            return res;
        } else {
            head.next = res;
            return head;
        }*/
    }

}
