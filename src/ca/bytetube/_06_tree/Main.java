package ca.bytetube._06_tree;

import ca.bytetube._06_tree.printer.BinaryTrees;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.add(7);
        bst.add(4);
        bst.add(9);
        bst.add(2);
        bst.add(5);
        bst.add(8);
        bst.add(11);
        bst.add(1);
        bst.add(3);
        bst.add(12);
//        bst.levelOrderTraversal();
        BinaryTrees.println(bst);
        bst.remove(7);
        BinaryTrees.println(bst);
//        bst.add(12);
//        BinaryTrees.println(bst);
//        bst.add(1);
//        BinaryTrees.println(bst);
//        BinarySearchTree<Student> bst = new BinarySearchTree<>(new StudentComparator());
//        Student student1 = new Student(21,17.6);
//        Student student2 = new Student(11,14.6);
//        Student student3 = new Student(28,16.6);
//        Student student4 = new Student(31,18.6);
//        bst.add(student1);
//        bst.add(student2);
//        bst.add(student3);
//        bst.add(student4);
//        BinaryTrees.println(bst);
    }
}
