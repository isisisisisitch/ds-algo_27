package ca.bytetube._19_sort.cmp;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 *
 * @author dall.
 */
public class Search {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int i = search(arr, 8);
        System.out.println(i);
    }

    public static int search(int[] nums, int target) {
        int begin = 0;
        int end = nums.length;

        while (begin < end) {
            int mid = (begin + end) >> 1;
            if (nums[mid] == target) return mid;

            //判定数组哪一半是序数组
            if (nums[begin] <= nums[mid]) {
                if (nums[begin] <= target && target < nums[mid]) {
                    end = mid;
                } else {
                    begin = mid + 1;
                }
            } else {//数组的右半部分是有序数组
                if (nums[mid] < target && nums[end - 1] >= target) {
                    begin = mid + 1;
                } else {
                    end = mid;
                }
            }

        }

        return -1;
    }
}
