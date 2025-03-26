package ca.bytetube._07_avl;

import ca.bytetube._07_avl.printer.BinaryTreeInfo;

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

    public void clear() {
        root = null;
        size = 0;
    }

    public void preorderTraversal() {
        preorderTraversal(root);
    }

    public void preorderTraversal0(Node<E> node) {
        if (node == null) return;
        System.out.print(node.element + " ");
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
            System.out.print(pop.element + " ");

            if (pop.right != null) stack.push(pop.right);
            if (pop.left != null) stack.push(pop.left);
        }


    }

    public void inorderTraversal() {
        inorderTraversal(root);
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
                    System.out.print(pop.element + " ");
                    node = pop.right;
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
        while (!helpStack.isEmpty()) System.out.print(helpStack.pop().element + " ");
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
            System.out.print(poll.element + " ");
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

    public boolean isComplete(Node<E> head) {
        if (head == null) return false;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(head);
        boolean isLeaf = false;
        while (!queue.isEmpty()) {
            Node<E> node = queue.poll();
            if (isLeaf && !node.isLeafNode()) return false;
            if (node.hasTwoChildren()) {
                queue.offer(node.left);
                queue.offer(node.right);
            } else if (node.left == null && node.right != null) return false;

            else if (node.left != null && node.right == null) {
                queue.offer(node.left);
                isLeaf = true;
            } else {
                isLeaf = true;
            }
        }
        return true;
    }

    public Node<E> predecessor(Node<E> node) {
        if (node == null) return null;
        //1.node.left != null
        Node<E> left = node.left;
        if (left != null) {
            while (left.right != null) left = left.right;
            return left;

        }
        //2.node.left == null && node.parent != null
        while (node.parent != null && node == node.parent.left) node = node.parent;
        return node.parent;
    }

    public Node<E> successor(Node<E> node) {
        if (node == null) return null;
        //1.node.right != null
        Node<E> right = node.right;
        if (right != null) {
            while (right.left != null) right = right.left;
            return right;

        }
        //2.node.right == null && node.parent != null
        while (node.parent != null && node == node.parent.right) node = node.parent;
        return node.parent;
    }

    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>) node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>) node).right;
    }

    @Override
    public Object string(Object node) {
        Node<E> myNode = (Node<E>) node;
        String parentString = "null";
        if (myNode.parent != null) {
            parentString = myNode.parent.element.toString();
        }

        return myNode.element + "_p(" + parentString + ")";
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

        protected boolean hasTwoChildren() {
            return this.left != null && this.right != null;
        }

        protected boolean isLeafNode() {
            return this.left == null && this.right == null;
        }

        protected boolean isLeftChild() {
            return this.parent != null && this == this.parent.left;
        }

        protected boolean isRightChild() {
            return this.parent != null && this == this.parent.right;
        }

    }
}
