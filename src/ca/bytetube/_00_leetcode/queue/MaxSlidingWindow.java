package ca.bytetube._00_leetcode.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/sliding-window-maximum/
 *
 * @author dall.
 */
//monotonic queue
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        int w = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.offer(i);
            if (i >= k - 1) {//合法窗口形成
                while (deque.peekFirst() < w) {
                    deque.removeFirst();
                }
                res[w++] = nums[deque.peekFirst()];

            }

        }

        return res;
    }
}
