package ca.bytetube._03_list.singly;

import ca.bytetube._03_list.AbstractList;

public class SingleCircularLinkedList<E> extends AbstractList<E> {
    Node<E> first;

    @Override
    public void clear() {
        first = null;
        size = 0;
    }

    private Node<E> node(int index) {
        rangeCheck(index);
        Node<E> node = first;
        for (int i = 0; i < index; i++) node = node.next;
        return node;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        //head/first node
        size++;
        if (index == 0) {
            Node<E> newFirst = new Node<>(element, first);
            first = newFirst;
            Node<E> last = (size == 0) ? newFirst : node(size - 1);
            last.next = newFirst;

        } else {
            //current/tail
            Node<E> prevNode = node(index - 1);

            prevNode.next = new Node<>(element, prevNode.next);
        }

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

    //todo
    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> removed = first;
        //head
        if (index == 0) {
            //only one node
            if (size == 1) first = null;
            else {
                first = first.next;
                Node<E> last = node(size - 1);
                last.next = first;
            }

        } else {
            //current/tail
            Node<E> prevNode = node(index - 1);
            removed = prevNode.next;
            prevNode.next = removed.next;
        }

        size--;
        return removed.element;
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

    private static class Node<E> {
        E element;
        Node<E> next;


        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    //size=3,elements=[a, b, c]
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("size=").append(size).append(",elements=[");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) sb.append(", ");
            sb.append(node.element);
            node = node.next;
        }
        sb.append("]");

        return sb.toString();
    }


}
