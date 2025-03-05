package ca.bytetube._00_leetcode.list;

public class DivideList {
    public static void main(String[] args) {
        ListNode head = new ListNode(12, null);
        head.next = new ListNode(44, null);
        head.next.next = new ListNode(14, null);
        head.next.next.next = new ListNode(9, null);
        head.next.next.next.next = new ListNode(25, null);
        head.next.next.next.next.next = new ListNode(33, null);
        head.next.next.next.next.next.next = new ListNode(16, null);
        ListNode newHead = divideList(head, 33);
        System.out.println(newHead);
    }

    public static ListNode divideList(ListNode head, int pivot) {
        ListNode lessHead = null;
        ListNode lessTail = null;
        ListNode equalHead = null;
        ListNode equalTail = null;
        ListNode moreHead = null;
        ListNode moreTail = null;

        ListNode next = null;
        while (head != null) {
            next = head.next;
            if (head.val < pivot) {
                //less
                if (lessHead == null) {
                    lessHead = head;
                    lessTail = head;
                } else {
                    lessTail.next = head;
                    lessTail = head;
                }

            } else if (head.val == pivot) {
                //equal
                if (equalHead == null) {
                    equalHead = head;
                    equalTail = head;
                } else {
                    equalTail.next = head;
                    equalTail = head;
                }
            } else {
                //more
                if (moreHead == null) {
                    moreHead = head;
                    moreTail = head;
                } else {
                    moreTail.next = head;
                    moreTail = head;
                }
            }
            head = next;
        }

        //less --->equal
        if (lessTail != null) {
            lessTail.next = equalHead;
            equalTail = equalTail == null ? lessTail : equalTail;
        }

        //equal--->more
        if (equalTail != null) {
            equalTail.next = moreHead;
            moreTail = moreTail == null ? equalTail : moreTail;
            moreTail.next = null;
        }


        return lessHead != null ? lessHead : equalHead != null ? equalHead : moreHead;
    }

}
