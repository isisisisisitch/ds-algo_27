package ca.bytetube._00_leetcode.list;

/**
 * https://leetcode.com/problems/palindrome-linked-list/
 *
 * @author dall.
 */
public class IsPalindrome {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, null));
        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {

        //1.通过快慢指针找到中间节点
        ListNode midNode = getMidNode(head);
        //2.反转右半部分
        ListNode rightHead = reverseList(midNode.next);

        //3.设定left，right指针从两端遍历，只要有一次指针的值不相等则返回false
        ListNode left = head;
        ListNode right = rightHead;

        while (left != null && right != null) {
            if (left.val != right.val) return false;
            left = left.next;
            right = right.next;
        }

        return true;
    }

    private static ListNode getMidNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private static ListNode reverseList(ListNode head) {
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

}
