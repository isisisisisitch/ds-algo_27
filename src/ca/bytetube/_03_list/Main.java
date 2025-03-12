package ca.bytetube._03_list;

import ca.bytetube._03_list.doubly.DoublyCircularLinkedList;
import ca.bytetube._03_list.singly.SingleLinkedList;

public class Main {
    public static void main(String[] args) {
      //  test();
        josephus(9,2);
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            list.add(i);
//        }
//
//        list.remove(5);


//        AbstractList<Integer> linkedList = new SingleLinkedList<>();
//        //System.out.println( linkedList.isEmpty());
//        linkedList.add(10);
//        linkedList.add(11);
//        linkedList.add(0,100);
//
//        System.out.println(linkedList.indexOf(100));
//        System.out.println();

        // System.out.println(linkedList.ELEMENT_NOT_FOUND);
    }

    public static void josephus(int num, int step) {
        DoublyCircularLinkedList<Integer> doublyCircularLinkedList = new DoublyCircularLinkedList<>();
        for (int i = 1; i < num; i++) {
            doublyCircularLinkedList.add(i);
        }

        doublyCircularLinkedList.reset();

        while (!doublyCircularLinkedList.isEmpty()) {
            for (int i = 0; i < step; i++) doublyCircularLinkedList.next();
            System.out.println(doublyCircularLinkedList.remove());
        }

    }

    public static void test() {
        DoublyCircularLinkedList<Integer> doublyCircularLinkedList = new DoublyCircularLinkedList<>();
        for (int i = 0; i < 3; i++) {
            doublyCircularLinkedList.add(0, i);
        }

        while (!doublyCircularLinkedList.isEmpty()) {
            Integer removed = doublyCircularLinkedList.remove(0);
            System.out.println(removed);
        }
        System.out.println();


    }
}
