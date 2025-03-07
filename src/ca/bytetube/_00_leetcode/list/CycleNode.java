package ca.bytetube._00_leetcode.list;

/**
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. The node that tail's next pointer is connected to is called cycle node.You need to return the cycle node.
 * <p>
 * Returns the intersection node of two acyclic singly linked lists
 * Returns the cycle node of two cycle singly linked lists
 */
public class CycleNode {
    public static void main(String[] args) {
// 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getAcyclicIntersectionNode(head1, head2).value);

//        System.out.println(getFirstInsertionNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
//        Node head1 = new Node(1);
//        head1.next = new Node(2);
//        head1.next.next = new Node(3);
//        head1.next.next.next = new Node(4);
//        head1.next.next.next.next = new Node(5);
//        head1.next.next.next.next.next = new Node(6);
//        head1.next.next.next.next.next.next = new Node(7);
//        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4
//        System.out.println(getCycleNode(head1).value);

        // 0->9->8->2...
//        head2 = new Node(0);
//        head2.next = new Node(9);
//        head2.next.next = new Node(8);
//        head2.next.next.next = head1.next; // 8->2
////        System.out.println(getFirstInsertionNode(head1, head2).value);
//
//        // 0->9->8->6->4->5->6..
//        head2 = new Node(0);
//        head2.next = new Node(9);
//        head2.next.next = new Node(8);
//        head2.next.next.next = head1.next.next.next.next.next; // 8->6
//        System.out.println(getFirstInsertionNode(head1, head2).value);
    }

    public static Node getCycleNodeOfCycleList(Node head1, Node head2) {
        Node cycleNode1 = getCycleNode(head1);
        Node cycleNode2 = getCycleNode(head2);
        if (cycleNode1 != cycleNode2) {
            Node temp = cycleNode1;
            while (temp != cycleNode2) {
                temp = temp.next;
                if (temp == cycleNode1) return null;
            }
        }
        return cycleNode1;
    }

    public static Node getAcyclicIntersectionNode(Node head1, Node head2) {
        int size1 = sizeOfList(head1);
        int size2 = sizeOfList(head2);
        int difference = size1 - size2;
        if (difference < 0) {
            for (int i = 0; i < -difference; i++) {
                head2 = head2.next;
            }
        } else {
            for (int i = 0; i < difference; i++) {
                head1 = head1.next;
            }
        }
        while (head1 != head2) {
            head1 = head1.next;
            head2 = head2.next;
        }
        return head1;
    }


    private static int sizeOfList(Node head) {
        int size = 0;
        while (head.next != null) {
            head = head.next;
            size++;
        }
        return size;
    }

    public static Node getCycleNode(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) break;
        }
        fast = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }


    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
