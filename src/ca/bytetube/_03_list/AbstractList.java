package ca.bytetube._03_list;

public abstract class AbstractList<E> implements List<E> {
    public int size;
    public static final int ELEMENT_NOT_FOUND = -1;

    // Number of elements
    public int size() {
        return size;
    }

    // Is it empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Add elements to the end
    public void add(E element) {
        add(size, element);
    }

    //Contains a certain element
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }


    protected void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("index:" + index + ",size:" + size);
    }

    protected void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) outOfBounds(index);
    }

    protected void rangeCheck(int index) {
        if (index < 0 || index >= size) outOfBounds(index);
    }

}
