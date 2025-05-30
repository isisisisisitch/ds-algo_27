package ca.bytetube._19_sort.cmp;

public class InsertionSort03<T extends Comparable<T>> extends Sort<T> {
    @Override
    protected void sort() {
        for (int begin = 1; begin < array.length; begin++) {
            T v = array[begin];
            int insertIndex = search(begin);
            for (int i = begin; i > insertIndex; i--) {
                array[i] = array[i - 1];
            }

            array[insertIndex] = v;

        }
    }

    private int search(int index) {
        if (array == null || array.length == 0) return -1;
        int begin = 0;
        int end = index;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            if (cmp(array[index], array[mid]) < 0) end = mid;
            else begin = mid + 1;
        }
        return begin;
    }
}
