package ca.bytetube._03_list;

public interface List<E> {

    public int size();

    // Is it empty
    public boolean isEmpty();

    // Clear all the elements
    public abstract void clear();

    // Add elements to the end
    public void add(E element);

    // Add elements to the index position
    public abstract void add(int index, E element);

    // Set the element at the index position

    public abstract E set(int index, E element);

    // Delete elements to the index position

    public abstract E remove(int index);

    // Returns the element corresponding to the index position

    public abstract E get(int index);

    // Return the index of the element

    public abstract int indexOf(E element);

    //Contains a certain element
    public boolean contains(E element);
}
