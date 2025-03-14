package ca.bytetube._00_leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/implement-stack-using-queues/
 *
 * @author dall.
 */
class MyStack {
    Queue<Integer> dataQ;
    Queue<Integer> helpQ;


    public MyStack() {
        dataQ = new LinkedList<>();
        helpQ = new LinkedList<>();
    }

    public void push(int x) {
        dataQ.offer(x);
    }

    public int pop() {
        while (dataQ.size() > 1) helpQ.offer(dataQ.poll());
        int polled = dataQ.poll();
        swap();
        return polled;
    }


    public int top() {
        while (dataQ.size() > 1) helpQ.offer(dataQ.poll());
        int polled = dataQ.poll();
        helpQ.offer(polled);
        swap();
        return polled;
    }

    public boolean empty() {
        return dataQ.isEmpty() && helpQ.isEmpty();
    }

    private void swap() {
        Queue<Integer> temp = helpQ;
        helpQ = dataQ;
        dataQ = temp;
    }
}

