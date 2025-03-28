package ca.bytetube._08_heap;

import ca.bytetube._07_avl.printer.BinaryTrees;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });


        Integer[] arr = {30, 34, 73, 60, 68, 43};
        BinaryHeap<Integer> heap2 = new BinaryHeap<>(null, arr);
       // BinaryTrees.println(heap2);
//        BinaryHeap<Integer> heap = new BinaryHeap<>(15);
//
        heap.add(72);
        heap.add(68);
        heap.add(50);
        heap.add(43);
        heap.add(38);
        heap.add(47);
        heap.add(21);
        heap.add(14);
        System.out.println(heap);
//       // BinaryTrees.println(heap);
//        heap.add(80);
//        BinaryTrees.println(heap);
//        heap.replace(8);
//        BinaryTrees.println(heap);

//        heap.add(72);


    }
}
