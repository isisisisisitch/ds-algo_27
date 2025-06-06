package ca.bytetube._19_sort.cmp;

import java.util.LinkedList;
import java.util.List;

public class ShellSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    protected void sort() {
        List<Integer> sequence = shellSequence();
        for (Integer step : sequence) {//8
            sort(step);
        }
    }

    private void sort(int step) {//step = 8
        for (int col = 0; col < step; col++) {
            for (int begin = col + step; begin < array.length; begin += step) {
                int cur = begin;
                while (cur > col && cmp(cur, cur - step) < 0) {
                    swap(cur, cur - step);
                    cur -= step;
                }
            }
        }


    }

    private List<Integer> shellSequence() {
        List<Integer> sequence = new LinkedList<>();
        int len = array.length;
        while ((len = len >> 1) > 0) {
            sequence.add(len);
        }

        return sequence;
    }
}
