package ca.bytetube._07_avl;

import java.util.Comparator;

public class BinarySearchTree<E> extends BinaryTree<E> {
    private Comparator<E> comparator;

    public BinarySearchTree() {
    }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public void afterAdd(Node<E> node) {
    }

    public Node<E> createNode(E element, Node<E> parent) {
        return new Node<>(element, parent);
    }

    // add elements
    public void add(E element) {
        if (element == null) throw new IllegalArgumentException("element can not be null!");
        //添加的节点是第一个节点
        if (root == null) {
            root = createNode(element, null);
            size++;
            afterAdd(root);
            return;
        }
        //添加的节点不是第一个节点
        Node<E> node = root;
        Node<E> parent = root;
        int cmp = 0;
        while (node != null) {
            cmp = compare(element, node.element);
            parent = node;
            if (cmp > 0) node = node.right;
            else if (cmp < 0) node = node.left;
            else {
                node.element = element;
                return;
            }
        }

        Node<E> newNode = createNode(element, parent);
        if (cmp > 0) parent.right = newNode;
        else parent.left = newNode;
        size++;
        afterAdd(newNode);

    }

    // remove elements
    public void remove(E element) {
        remove(node(element));

    }

    public void afterRemove(Node<E> node) {
    }

    private void remove(Node<E> node) {
        //Delete node-node with degree 2
        if (node.hasTwoChildren()) {
            Node<E> s = successor(node);
            node.element = s.element;
            node = s;
        }
        //Delete node-node with degree 1
        Node<E> replacement = node.left != null ? node.left : node.right;
        if (replacement != null) {
            replacement.parent = node.parent;
            if (node == root) root = replacement;
            else {
                if (node == node.parent.left) node.parent.left = replacement;
                else node.parent.right = replacement;
                afterRemove(node);
            }
        }
        //Delete node-node with degree 0
        else if (node.parent == null) {
            root = null;
            afterRemove(node);
        } else {
            if (node == node.parent.left) node.parent.left = null;
            else node.parent.right = null;
            afterRemove(node);
        }
    }

    private Node<E> node(E element) {
        Node<E> node = root;
        while (node != null) {
            int cmp = compare(element, node.element);
            if (cmp > 0) node = node.right;
            else if (cmp < 0) node = node.left;
            else {
                return node;
            }
        }

        return null;

    }

    // does it contain an element or not
    public boolean contains(E element) {
        return node(element) != null;
    }

    private int compare(E e1, E e2) {
        if (comparator != null) return comparator.compare(e1, e2);
        return ((Comparable<E>) e1).compareTo(e2);

    }
}
