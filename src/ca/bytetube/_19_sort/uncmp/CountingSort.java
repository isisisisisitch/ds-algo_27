package ca.bytetube._19_sort.uncmp;

import ca.bytetube._19_sort.utils.Asserts;
import ca.bytetube._19_sort.utils.Integers;

public class CountingSort {
    public static void main(String[] args) {
        Integer[] array = Integers.random(2000, 1, 20000);
        sort(array);
        Asserts.test(Integers.isAscOrder(array));

    }

    public static void sort(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr.length == 1) return;
        //1.找到最大值和最小值
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) max = arr[i];
            if (min > arr[i]) min = arr[i];
        }

        //2.创建counts数组，用来统计原数组中元素出现的次数的累加和
        int[] counts = new int[max - min + 1];
        //2.1统计元素出现的次数
        for (int i = 0; i < arr.length; i++) counts[arr[i] - min]++;

        //2.2 统计元素出现的次数的累加和
        for (int i = 1; i < counts.length; i++) counts[i] += counts[i - 1];

        //3.从右向左遍历原数组，从counts数组中将每个遍历过的元素放入到新数组中
        int[] newArray = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            newArray[--counts[arr[i] - min]] = arr[i];
        }

        //4.将新数组中的值复制回原数组
        for (int i = 0; i < newArray.length; i++) {
            arr[i] = newArray[i];
        }

    }


    public static void sort1(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr.length == 1) return;
        //1.找到最大值
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) max = arr[i];
        }


        //2.创建counts数组，用来统计原数组中元素出现的次数
        int[] counts = new int[max + 1];
        for (int i = 0; i < arr.length; i++) counts[arr[i]]++;

        //3.根据counts数组中非零元素的index出现的次数进而对原数组排序
        int index = 0;
        for (int i = 0; i < counts.length; i++) {
            while (counts[i]-- > 0) {
                arr[index++] = i;
            }

        }

    }

}
