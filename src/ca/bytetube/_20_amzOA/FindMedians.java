package ca.bytetube._20_amzOA;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedians {

    public static void main(String[] args) {
        int[] medians = medians(new int[]{1, 2, 3}, 2);
        System.out.println(Arrays.toString(medians));
    }


    public static int[] findMedians(int[] values, int k) {
        //利用maxHeap维护最小的k个数
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int v : values) {
            maxHeap.offer(v);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int[] minArr = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            minArr[i] = maxHeap.poll();
        }

        Arrays.sort(minArr);
        int minMedian = minArr[(k - 1) / 2];
        //利用minHeap维护最大的k个数
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int v : values) {
            minHeap.offer(v);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] maxArr = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            maxArr[i] = minHeap.poll();
        }

        Arrays.sort(maxArr);
        int maxMedian = maxArr[(k - 1) / 2];


        return new int[]{maxMedian, minMedian};
    }

    public static int[] medians(int[] values, int k) {
        if (values.length == 0) return null;

        int[] ans = new int[2];
        Arrays.sort(values);
        if (k == 1) {
            ans[0] = values[values.length - 1];
            ans[1] = values[0];
            return ans;
        }
        int index = (k - 1) >> 1;
        ans[0] = values[values.length - 1 - index - 1];
        ans[1] = values[index];
        return ans;
    }
}
