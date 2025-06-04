package ca.bytetube._00_leetcode.list;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 *
 * @author dall.
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode dummy = new ListNode(0);
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((ListNode a, ListNode b) -> a.val - b.val);
        //将所有list的头节点放到heap中
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.add(node);
            }
        }
        ListNode curTail = dummy;
        //不断从minHeap中取出最小的节点，并将其下一个节点放入heap中
        while (!minHeap.isEmpty()) {
            ListNode minNode = minHeap.poll();
            curTail.next = minNode;
            curTail = curTail.next;
            if (minNode.next != null) {
                minHeap.add(minNode.next);
            }
        }
        return dummy.next;
    }
}
