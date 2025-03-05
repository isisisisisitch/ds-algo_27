package ca.bytetube._00_leetcode.list;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 *
 * @author dall.
 */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode node = head;
        while (node.next != null) {
            if (node.val == node.next.val) node.next = node.next.next;
            else node = node.next;
        }

        return head;
    }
}
