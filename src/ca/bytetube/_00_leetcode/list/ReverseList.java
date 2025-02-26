package ca.bytetube._00_leetcode.list;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * @author dall.
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
