package ca.bytetube._05_queue;


import ca.bytetube._05_queue.doubly.LinkedList;

public class Queue<E> {
    private LinkedList<E> list = new LinkedList<>();

    // Number of elements
    public int size() {
        return list.size;
    }

    // Is it empty
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // Clear elements
    public void clear() {
        list.clear();
    }

    //enQueue
    public void enQueue(E element) {
        list.add(element);
    }

    // deQueue
    public E deQueue() {
        return list.remove(0);
    }

    //Get the head element of
    public E front() {
        return list.get(0);
    }


}
