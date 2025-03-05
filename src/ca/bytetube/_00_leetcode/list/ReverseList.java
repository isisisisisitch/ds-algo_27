package ca.bytetube._00_leetcode.list;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 *
 * @author dall.
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = newHead;
            newHead = head;
            head = temp;
        }


        return newHead;
    }

    public ListNode reverseList01(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList01(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
