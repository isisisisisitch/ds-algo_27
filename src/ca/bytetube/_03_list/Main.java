package ca.bytetube._03_list;

import ca.bytetube._03_list.singly.SingleLinkedList;

public class Main {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            list.add(i);
//        }
//
//        list.remove(5);


        AbstractList<Integer> linkedList = new SingleLinkedList<>();
        //System.out.println( linkedList.isEmpty());
        linkedList.add(10);
        linkedList.add(11);
        linkedList.add(0,100);

        System.out.println(linkedList.indexOf(100));
        System.out.println();

       // System.out.println(linkedList.ELEMENT_NOT_FOUND);
    }
}
