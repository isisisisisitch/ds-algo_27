package ca.bytetube._05_queue.doubly;

import ca.bytetube._05_queue.AbstractList;

public class DoublyCircularLinkedList<E> extends AbstractList<E> {
    private Node<E> first;
    private Node<E> last;
    private Node<E> current;

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }


    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        if (index == size) { //tail
            Node<E> oldLast = last;
            Node<E> newLast = new Node<>(element, oldLast, first);
            last = newLast;
            //first node
            if (size == 0) {
                first = newLast;
                first.next = first;
                first.prev = first;
            } else {
                oldLast.next = newLast;
                first.prev = last;

            }
        } else {
            //current/head
            Node<E> nextNode = node(index);
            Node<E> prevNode = nextNode.prev;
            Node<E> newNode = new Node<>(element, prevNode, nextNode);
            nextNode.prev = newNode;
            prevNode.next = newNode;
            if (index == 0) first = newNode;

        }

        size++;

    }

    @Override
    public E get(int index) {
        rangeCheck(index);

        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        Node<E> oldNode = node(index);
        E oldVal = oldNode.element;
        oldNode.element = element;
        return oldVal;
    }

    private E remove(Node<E> current) {
        if (size == 1) {
            first = null;
            last = null;
        } else {
            //current //only one node
            Node<E> preNode = current.prev;
            Node<E> nextNode = current.next;
            if (current == first) {
                first = nextNode;// head
                last.next = nextNode;
            } else preNode.next = nextNode;

            if (current == last) {
                last = preNode;//tail
                first.prev = preNode;
            } else nextNode.prev = preNode;
        }
        size--;
        return current.element;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> node = node(index);
        return remove(node);
    }

    public E remove() {
        if (current == null) return null;
        Node<E> next = current.next;
        E remove = remove(current);
//        if (size == 0) current = null;
        current = next;
        return remove;
    }


    public void reset() {
        current = first;
    }

    public E next() {
        if (current == null) return null;
        current = current.next;
        return current.element;
    }

    @Override
    public int indexOf(E element) {
        if (element == null) {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (node.element == null) return i;
                node = node.next;
            }

        } else {

            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) return i;
                node = node.next;
            }

        }
        return ELEMENT_NOT_FOUND;
    }

    private Node<E> node(int index) {
        rangeCheck(index);
        Node<E> node;
        if (index < (size >> 1)) {
            node = first;
            for (int i = 0; i < index; i++) node = node.next;

        } else {
            node = last;
            for (int i = size - 1; i > index; i--) node = node.prev;
        }

        return node;
    }

    private static class Node<E> {
        E element;

        Node<E> prev;
        Node<E> next;

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }

}
