package ca.bytetube._19_sort.uncmp;


import java.util.LinkedList;
import java.util.List;

public class BucketSort {
    public static void main(String[] args) {
        Double[] arr = {0.34, 0.47, 0.29, 0.84, 0.45, 0.38, 0.35, 0.75};
        sort(arr);
      for (double d: arr){
          System.out.print(d+",");
      }
    }

    public static void sort(Double[] arr) {
        if (arr == null || arr.length == 0 || arr.length == 1) return;
        // 1.创建一定数量的桶（可以用数组或者链表作为桶）
        List<Double>[] buckets = new List[arr.length];
        // 2.按照一定的规则（不同数据类型和规模，规则不同），尽可能的将序列中的元素均匀地分配到对应的桶中
        for (int i = 0; i < arr.length; i++) {
            int bucketIndex = (int) (arr[i] * buckets.length);
            List<Double> bucket = buckets[bucketIndex];
            if (bucket == null) {
                bucket = new LinkedList<>();
                buckets[bucketIndex] = bucket;
            }
            bucket.add(arr[i]);
        }
        int index = 0;
        // 3.分别对每个桶进行单独的排序
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] == null) continue;
            buckets[i].sort(null);
            // 4.将所有的非空桶合并成一个有序数组
            for (double d : buckets[i]) {
                arr[index++] = d;
            }
        }


    }
}
