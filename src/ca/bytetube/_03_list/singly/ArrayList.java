package ca.bytetube._03_list.singly;

import ca.bytetube._03_list.AbstractList;

public class ArrayList<E> extends AbstractList<E> {
    private E[] elements;

    private static final int DEFAULT_CAPACITY = 10;
    public ArrayList() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];

    }
    // Clear all the elements
    public void clear() {
        size = 0;
    }


    // Add elements to the index position
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        ensureCapacity(size + 1);

        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }


    // Set the element at the index position
    public E set(int index, E element) {
        rangeCheck(index);
        E oldElement = elements[index];
        elements[index] = element;
        return oldElement;
    }


    // Delete elements to the index position
    public E remove(int index) {
        rangeCheck(index);
        E oldElement = elements[index];
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }
        size--;
        return oldElement;
    }

    // Returns the element corresponding to the index position
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    // Return the index of the element
    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) return i;
            }
        }

        return ELEMENT_NOT_FOUND;
    }


    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;

        int newCapacity = oldCapacity + (capacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) newElements[i] = elements[i];
        elements = newElements;

    }


}
