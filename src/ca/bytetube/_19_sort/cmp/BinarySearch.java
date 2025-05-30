package ca.bytetube._19_sort.cmp;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 8,8, 8, 8, 10, 12, 14};
        System.out.println(indexOf(arr, 8));
        System.out.println(search(arr, 8));
    }

    public static int search(int[] array, int v) {
        if (array == null || array.length == 0) return -1;
        int begin = 0;
        int end = array.length;

        while (begin < end) {
            int mid = (begin + end) >> 1;
            if (v < array[mid]) end = mid;
            else begin = mid + 1;
        }
        return begin;
    }

    public static int indexOf(int[] array, int v) {
        if (array == null || array.length == 0) return -1;
        int begin = 0;
        int end = array.length;

        while (begin < end) {
            int mid = (begin + end) >> 1;
            if (v == array[mid]) return mid;
            else if (v < array[mid]) end = mid;
            else begin = mid + 1;
        }
        return -1;
    }
}
