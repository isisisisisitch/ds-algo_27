package ca.bytetube._07_avl;

public class AVLTree<E> extends BinarySearchTree<E> {

    @Override
    public void afterAdd(Node<E> node) {
        // System.out.println("AVLTree afterAdd");

        while ((node = node.parent) != null) {
            if (isBalanced(node)) {
                calculateHeight(node);
            } else {
                rebalance(node);
                break;
            }
        }

    }

    @Override
    public Node<E> createNode(E element, Node<E> parent) {
        return new AVLNode<>(element, parent);
    }

    private void rebalance(Node<E> grand) {
        Node<E> parent = ((AVLNode<E>) grand).tallerChild();
        Node<E> node = ((AVLNode<E>) parent).tallerChild();
        if (parent.isLeftChild()) {//L
            if (node.isLeftChild()) {//L
                rightRotation(grand);
            } else {//R
                leftRotation(parent);
                rightRotation(grand);
            }
        } else {//R
            if (node.isLeftChild()) {//L
                rightRotation(parent);
                leftRotation(grand);
            } else {//R
                leftRotation(grand);
            }
        }
    }

    private void leftRotation(Node<E> grand) {
        //1.调整parent，grand子节点的指向
        Node<E> parent = grand.right;
        Node<E> child = parent.left;
        grand.right = child;
        parent.left = grand;

        afterRotation(grand, parent, child);
    }

    private void rightRotation(Node<E> grand) {
        //1.调整parent，grand子节点的指向
        Node<E> parent = grand.left;
        Node<E> child = parent.right;
        grand.left = child;
        parent.right = grand;

        afterRotation(grand, parent, child);

    }

    private void afterRotation(Node<E> grand, Node<E> parent, Node<E> child) {
        //2.更新t1,p,g的parent
        //2.1让parent成为这个子树的根节点
        parent.parent = grand.parent;
        if (grand.isLeftChild()) grand.parent.left = parent;
        else if (grand.isRightChild()) grand.parent.right = parent;
        else root = parent;
        //2.2更新t1 parent
        if (child != null) child.parent = grand;
        //2.2更新grand parent
        grand.parent = parent;

        //3.更新g，p的高度
        calculateHeight(grand);
        calculateHeight(parent);
    }


    private void calculateHeight(Node<E> node) {
        ((AVLNode<E>) node).calculateHeight();
    }

    private boolean isBalanced(Node<E> node) {
        int balanceFactor = ((AVLNode<E>) node).balanceFactor();
        return Math.abs(balanceFactor) <= 1;
    }

    public static class AVLNode<E> extends Node<E> {
        int height = 1;

        public AVLNode(E element, Node<E> parent) {
            super(element, parent);
        }

        public int balanceFactor() {
            int leftHeight = left == null ? 0 : ((AVLNode<E>) left).height;
            int rightHeight = right == null ? 0 : ((AVLNode<E>) right).height;

            return leftHeight - rightHeight;
        }

        public void calculateHeight() {
            int leftHeight = left == null ? 0 : ((AVLNode<E>) left).height;
            int rightHeight = right == null ? 0 : ((AVLNode<E>) right).height;
            height = Math.max(leftHeight, rightHeight) + 1;

        }

        public Node<E> tallerChild() {
            int leftHeight = left == null ? 0 : ((AVLNode<E>) left).height;
            int rightHeight = right == null ? 0 : ((AVLNode<E>) right).height;
            if (leftHeight > rightHeight) return left;
            if (leftHeight < rightHeight) return right;
            return this.isLeftChild() ? left : right;
        }
    }

}
