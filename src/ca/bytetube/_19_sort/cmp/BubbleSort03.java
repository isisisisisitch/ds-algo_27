package ca.bytetube._19_sort.cmp;

public class BubbleSort03<T extends Comparable<T>> extends Sort<T> {
    @Override
    protected void sort() {

        for (int end = array.length - 1; end > 0; end--) {
            int sortedIndex = 0;
            for (int start = 1; start <= end; start++) {
                if (cmp(array[start], array[start - 1]) < 0) {
                    swap(start, start - 1);
                    sortedIndex = start;
                }
            }
            end = sortedIndex;
        }

    }
}
