package ca.bytetube._00_leetcode.array;

/**
 * https://leetcode.com/problems/sort-colors/
 *
 * @author dall.
 */
public class SortColors {
    public void sortColors(int[] nums) {
        partition(nums, 1);
    }

    private void partition(int[] nums, int pivot) {
        partition(nums, pivot, 0, nums.length - 1);

    }

    private void partition(int[] nums, int pivot, int l, int r) {
        int less = l - 1;
        int more = r + 1;
        while (l < more) {
            if (nums[l] < pivot) swap(nums, ++less, l++);
            else if (nums[l] > pivot) swap(nums, --more, l);
            else l++;
        }

    }


    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
