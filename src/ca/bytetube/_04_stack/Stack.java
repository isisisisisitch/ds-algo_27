package ca.bytetube._04_stack;

import ca.bytetube._04_stack.singly.ArrayList;

public class Stack<E> {
    private ArrayList<E> list = new ArrayList<>();

    // Number of elements
    public int size() {
        return list.size();
    }

    // Is stack empty
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // Push
    public void push(E element) {
        list.add(element);
    }

    // Pop
    public E pop() {
        return list.remove(list.size - 1);
    }

    // Get the top element of the stack
    public E top() {
        return list.get(list.size - 1);
    }

    // Clear all elements in stack
    public void clear() {
        list.clear();
    }

}
