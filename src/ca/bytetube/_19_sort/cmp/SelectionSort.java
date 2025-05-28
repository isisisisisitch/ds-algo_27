package ca.bytetube._19_sort.cmp;

public class SelectionSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    protected void sort() {
        for (int end = array.length - 1; end > 0; end--) {
            int maxIndex = 0;
            for (int start = 1; start <= end; start++) {
                if (cmp(array[maxIndex], array[start]) < 0) {
                    maxIndex = start;
                }
            }
            swap(maxIndex, end);
        }
    }
}
