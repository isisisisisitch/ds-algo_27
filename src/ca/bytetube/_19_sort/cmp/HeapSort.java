package ca.bytetube._19_sort.cmp;

public class HeapSort<T extends Comparable<T>> extends Sort<T> {
    private int size;

    @Override
    protected void sort() {
        size = array.length;
        //① heapify
        for (int i = (size >> 1) - 1; i >= 0; i--) {
            siftDown(i);
        }

        //② Repeat the following operations
        //until there is only 1 element in the heap,
        //Swap the top and tail elements of the heap
        //Decrease the number of elements
        //in the heap by 1
        //Then do siftDown operation on the 0 position

        while (size > 1) {
            swap(0, --size);
            siftDown(0);
        }

    }

    private void siftDown(int index) {
        T element = array[index];
        int half = size / 2;

        while (index < half) {
            //2种情况
            //1.只有左
            //2.有左有右
            //3.默认与左孩子比
            int childIndex = index * 2 + 1;
            T child = array[childIndex];

            int rightIndex = childIndex + 1;
            if (rightIndex < size && cmp(array[rightIndex], child) > 0) {
                child = array[childIndex = rightIndex];
            }
            if (cmp(element, child) >= 0) break;
            array[index] = child;
            index = childIndex;
        }

        array[index] = element;
    }
}
