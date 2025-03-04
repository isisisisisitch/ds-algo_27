package ca.bytetube._03_list.singly;

import ca.bytetube._03_list.AbstractList;

public class SingleLinkedList<E> extends AbstractList<E> {
    Node<E> first;

    // Clear all the elements
    public void clear() {
        first = null;
        size = 0;
    }

    private Node<E> node(int index) {
        rangeCheck(index);
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    // Add elements to the index position
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        //头插
        if (index == 0) {
            first = new Node<>(element, first);
        } else {
            //1.普通位置/尾部位置
            Node<E> prevNode = node(index - 1);
        /*
        "="
        1.赋值 int i = 10;===>从右向左看
        2.指向  prevNode.next = newNode;===>从左向右看

         */
            prevNode.next = new Node<>(element, prevNode.next);
        }

        size++;
    }


    // Set the element at the index position
    public E set(int index, E element) {
        rangeCheck(index);
        Node<E> oldNode = node(index);
        E oldElement = oldNode.element;
        oldNode.element = element;
        return oldElement;
    }

    // Returns the element corresponding to the index position
    public E get(int index) {
        rangeCheck(index);
        return node(index).element;
    }

    // Delete elements to the index position
    public E remove(int index) {
        rangeCheck(index);
        //头删/最后一个节点的删除
        Node<E> removed = first;
        if (index == 0) {
            first = first.next;
        } else {
            //普通位置/尾部
            Node<E> prevNode = node(index - 1);//2
            removed = prevNode.next;//3
            prevNode.next = removed.next;
        }

        size--;
        return removed.element;
    }


    // Return the index of the element
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


}
