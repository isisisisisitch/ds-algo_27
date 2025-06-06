package ca.bytetube._19_sort.cmp;

public class QuickSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    protected void sort() {
        sort(0, array.length);
    }

    private void sort(int begin, int end) {
        if (end - begin < 2) return;
        int pivot = pivotIndex(begin, end);
        sort(begin, pivot);
        sort(pivot + 1, end);

    }

    private int pivotIndex(int begin, int end) {
        //0.增加随机pivot的选择
        swap(begin, begin + (int) (Math.random() * (end - begin)));
        //1.备份pivot
        T pivot = array[begin];
        end--;

        while (begin < end) {
            //2.1从右向左
            while (begin < end) {
                if (cmp(array[end], pivot) < 0) {
                    array[begin++] = array[end];
                    break;
                } else {
                    end--;
                }
            }

            //2.1从左向右
            while (begin < end) {
                if (cmp(array[begin], pivot) > 0) {
                    array[end--] = array[begin];
                    break;
                } else {
                    begin++;
                }
            }
        }

        //3.将之前备份的pivot放到重合位置
        array[begin] = pivot;
        return begin;
    }
}
