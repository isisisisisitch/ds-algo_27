package ca.bytetube._07_avl;

public class AVLTree<E> extends BinarySearchTree<E> {

    @Override
    public void afterAdd(Node<E> node) {
        while ((node = node.parent) != null) {
            if (isBalanced(node)) {
                calculateHeight(node);
            } else {
                rebalance2(node);
                break;
            }
        }

    }

    @Override
    public void afterRemove(Node<E> node) {
        while ((node = node.parent) != null) {
            if (isBalanced(node)) {
                calculateHeight(node);
            } else {
                rebalance2(node);
            }
        }

    }

    @Override
    public Node<E> createNode(E element, Node<E> parent) {
        return new AVLNode<>(element, parent);
    }

    private void rebalance2(Node<E> grand) {
        Node<E> parent = ((AVLNode<E>) grand).tallerChild();
        Node<E> node = ((AVLNode<E>) parent).tallerChild();
        if (parent.isLeftChild()) {//L
            if (node.isLeftChild()) {//L
                rotation(grand, node.left, node, node.right, parent, parent.right, grand, grand.right);
            } else {//R
                rotation(grand, parent.left, parent, node.left, node, node.right, grand, grand.right);
            }
        } else {//R
            if (node.isLeftChild()) {//L
                rotation(grand, grand.left, grand, node.left, node, node.right, parent, parent.right);
            } else {//R
                rotation(grand, grand.left, grand, parent.left, parent, node.left, node, node.right);
            }
        }

    }

    private void rotation(Node<E> r, Node<E> a, Node<E> b, Node<E> c,
                          Node<E> d, Node<E> e, Node<E> f, Node<E> g) {
        //1.让d成为子树的根节点
        d.parent = r.parent;
        if (r.isLeftChild()) r.parent.left = d;
        if (r.isRightChild()) r.parent.right = d;
        else root = d;

        //abc
        b.left = a;
        if (a != null) a.parent = b;
        b.right = c;
        if (c != null) c.parent = b;
        calculateHeight(b);

        //efg
        f.left = e;
        if (e != null) e.parent = f;
        f.right = g;
        if (g != null) g.parent = f;
        calculateHeight(f);

        //bdf
        d.left = b;
        d.right = f;
        b.parent = d;
        f.parent = d;
        calculateHeight(d);

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
