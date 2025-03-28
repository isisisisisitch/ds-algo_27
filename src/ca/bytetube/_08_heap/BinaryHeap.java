package ca.bytetube._08_heap;

import ca.bytetube._07_avl.printer.BinaryTreeInfo;

import java.lang.module.FindException;
import java.util.Comparator;

public class BinaryHeap<E> extends AbstractHeap<E> implements BinaryTreeInfo {
    private E[] elements;
    private static final int DEFAULT_CAPACITY = 10;

    public BinaryHeap() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public BinaryHeap(int initCapacity) {
        initCapacity = Math.max(initCapacity, DEFAULT_CAPACITY);
        elements = (E[]) new Object[initCapacity];
    }


    public BinaryHeap(Comparator<E> comparator, E[] elements) {
        super(comparator);
        if (elements == null || elements.length == 0) this.elements = (E[]) new Object[DEFAULT_CAPACITY];
        else {
            size = elements.length;
            int capacity = Math.max(elements.length, DEFAULT_CAPACITY);
            this.elements = (E[]) new Object[capacity];
            for (int i = 0; i < size; i++) {
                this.elements[i] = elements[i];
            }
        }

        heapify();
    }

    private void heapify() {
        for (int i = (size >> 1) - 1; i >= 0; i--) {
            siftDown(i);
        }

    }


    @Override
    public void add(E element) {
        elementNotNullCheck(element);
        ensureCapacity(size + 1);
        elements[size++] = element;
        siftUp(size - 1);
    }

    private void siftUp(int index) {
        E e = elements[index];
        while (index > 0) {
            int parentIndex = (index - 1) >> 1;
            E parent = elements[parentIndex];
            if (compare(e, parent) <= 0) break;

            elements[index] = parent;
            index = parentIndex;
        }
        elements[index] = e;
    }

    @Override
    public E remove() {
        E root = elements[0];
        int lastIndex = --size;
        elements[0] = elements[lastIndex];
        elements[lastIndex] = null;
        siftDown(0);
        return root;
    }

    //If node < the maximum child node
    //Swap with the maximum child node
    //If node ≥ the maximum child node， or node has not child node
    //Exit the loop
    private void siftDown(int index) {
        E element = elements[index];
        int half = size >> 1;
        while (index < half) {
            //对于child node有2种情况
            //1.只有左
            //2.有左有右
            int childIndex = (index << 1) + 1;
            E child = elements[childIndex];
            int rightIndex = childIndex + 1;

            if (rightIndex < size && compare(elements[rightIndex], child) > 0) {
                child = elements[childIndex = rightIndex];
            }
            if (compare(element, child) >= 0) break;
            elements[index] = child;
            index = childIndex;
        }

        elements[index] = element;

    }


    @Override
    public E get() {
        emptyCheck();
        return elements[0];
    }

    @Override
    public void clear() {
        size = 0;
    }


    @Override
    public E replace(E element) {
        elementNotNullCheck(element);
        E root = null;
        if (size == 0) {
            root = element;
            size++;
        } else {
            root = elements[0];
            elements[0] = element;
            siftDown(0);
        }

        return root;
    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;

        int newCapacity = oldCapacity + (capacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) newElements[i] = elements[i];
        elements = newElements;

    }

    private void emptyCheck() {
        if (size == 0) throw new IndexOutOfBoundsException("heap is empty!");
    }

    private void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("index:" + index + ",size:" + size);
    }

    private void elementNotNullCheck(E element) {
        if (element == null) throw new IllegalArgumentException("element can not be null!");
    }

    private int compare(E e1, E e2) {
        if (comparator != null) return comparator.compare(e1, e2);
        return ((Comparable<E>) e1).compareTo(e2);

    }

    @Override
    public Object root() {
        return 0;
    }

    @Override
    public Object left(Object node) {
        int index = ((int) node << 1) + 1;
        return index >= size ? null : index;
    }

    @Override
    public Object right(Object node) {
        int index = ((int) node << 1) + 2;
        return index >= size ? null : index;
    }

    @Override
    public Object string(Object node) {

        return elements[(int) node];
    }
}
