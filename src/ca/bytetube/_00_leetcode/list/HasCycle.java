package ca.bytetube._00_leetcode.list;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 *
 * @author dall.
 */
public class HasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) return true;
        }


        return false;
    }
}
