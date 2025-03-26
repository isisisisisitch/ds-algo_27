package ca.bytetube._07_avl;

import ca.bytetube._07_avl.printer.BinaryTrees;

public class Main {
    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>();
        for (int i = 0; i < 10; i++) {
            tree.add(i);
        }
//        tree.add(7);
//        tree.add(4);
//        tree.add(9);
//        tree.add(2);
//        tree.add(5);
//        tree.add(8);
//        tree.add(11);
//        tree.add(1);
//        tree.add(3);
//        tree.add(12);
//        bst.levelOrderTraversal();
        BinaryTrees.println(tree);
//        tree.remove(7);
        //BinaryTrees.println(tree);
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
