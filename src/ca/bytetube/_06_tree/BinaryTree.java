package ca.bytetube._06_tree;

import ca.bytetube._06_tree.printer.BinaryTreeInfo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<E> implements BinaryTreeInfo {
    protected Node<E> root;
    protected int size;

    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public void preorderTraversal() {
        preorderTraversal(root);
    }

    public void preorderTraversal0(Node<E> node) {
        if (node == null) return;
        System.out.println(node.element);
        preorderTraversal0(node.left);
        preorderTraversal0(node.right);

    }

    //有右先压右，有左再压左
    public void preorderTraversal(Node<E> node) {
        if (node == null) return;

        Stack<Node<E>> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node<E> pop = stack.pop();
            System.out.println(pop.element);

            if (pop.right != null) stack.push(pop.right);
            if (pop.left != null) stack.push(pop.left);
        }


    }

    public void inorderTraversal() {
        inorderTraversal0(root);
    }

    public void inorderTraversal0(Node<E> node) {
        if (node == null) return;
        inorderTraversal0(node.left);
        System.out.println(node.element);
        inorderTraversal0(node.right);

    }

    //有左一直压左，否则弹出栈顶元素判断栈顶元素是否有右，如果有右再压右
    public void inorderTraversal(Node<E> node) {
        if (node != null) {
            Stack<Node<E>> stack = new Stack<>();
            while (!stack.isEmpty() || node != null) {
                if (node != null) {
                    stack.push(node);
                    node = node.left;
                } else {
                    Node<E> pop = stack.pop();
                    System.out.println(pop.element);
                    node = node.right;
                }
            }

        }

    }

    public void postorderTraversal() {
        postorderTraversal(root);
    }

    public void postorderTraversal0(Node<E> node) {
        if (node == null) return;

        postorderTraversal0(node.left);
        postorderTraversal0(node.right);
        System.out.println(node.element);

    }

    public void postorderTraversal(Node<E> node) {
        if (node == null) return;
        Stack<Node<E>> stack = new Stack<>();
        Stack<Node<E>> helpStack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node<E> pop = stack.pop();
            helpStack.push(pop);
            if (pop.left != null) stack.push(pop.left);
            if (pop.right != null) stack.push(pop.right);
        }
        while (!helpStack.isEmpty()) System.out.println(helpStack.pop().element);
    }


    public void levelOrderTraversal() {
        levelOrderTraversal(root);
    }

    public void levelOrderTraversal(Node<E> node) {
        if (node == null) return;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node<E> poll = queue.poll();
            System.out.println(poll);
            if (poll.left != null) queue.offer(poll.left);
            if (poll.right != null) queue.offer(poll.right);
        }

    }

    public int height() {
        return height0(root);
    }

    public int height0(Node<E> node) {
        if (node == null) return 0;
        return Math.max(height0(node.left), height0(node.right)) + 1;
    }


    public int height(Node<E> node) {
        if (node == null) return 0;
        int height = 0;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(node);
        int levelSize = 1;

        while (!queue.isEmpty()) {
            Node<E> poll = queue.poll();
            levelSize--;
            // System.out.println(poll);
            if (poll.left != null) queue.offer(poll.left);
            if (poll.right != null) queue.offer(poll.right);

            if (levelSize == 0) {
                height++;
                levelSize = queue.size();
            }
        }

        return height;
    }

    public boolean isComplete() {
        return isComplete(root);
    }

    public boolean isComplete(Node<E> node) {
        if (node == null) return false;
        boolean isLeaf = false;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (isLeaf && !(node.left == null && node.right == null)) return false;
            if (node.left != null && node.right != null) {//1
                queue.offer(node.left);
                queue.offer(node.right);
            } else if (node.left == null && node.right != null) return false;//2
            else if (node.left != null && node.right == null) {//3
                queue.offer(node.left);
                isLeaf = true;
            } else {//4
                isLeaf = true;
            }
        }
        return true;
    }

    @Override
    public Object root() {
        return null;
    }

    @Override
    public Object left(Object node) {
        return null;
    }

    @Override
    public Object right(Object node) {
        return null;
    }

    @Override
    public Object string(Object node) {
        return null;
    }

    public static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node() {
        }

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }
    }
}
