package ca.bytetube._00_leetcode.tree;

import java.util.Arrays;
import java.util.Stack;

/**
 * 给定一个maximum binary tree 数组，返回一个数组，数组中包含每个节点的父节点的索引
 */
public class ParentIndex {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1, 6, 0, 5};
        int[] parentIndex = parentIndex(arr);
        System.out.println(Arrays.toString(parentIndex));
    }

    //monotonic stack
    public static int[] parentIndex(int[] nums) {

        //1.做一个从底到顶的单调栈
        Stack<Integer> stack = new Stack<>();
        int[] lis = new int[nums.length];//保存左侧第一个比当前元素大的数的索引
        int[] ris = new int[nums.length];//保存右侧第一个比当前元素大的数的索引

        for (int i = 0; i < nums.length; i++) {
            ris[i] = -1;
            lis[i] = -1;
        }

        //从头扫描所有的元素
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                //找到了右侧第一个比栈顶大的元素的下标
                ris[stack.pop()] = i;
            }

            if (!stack.isEmpty()) {
                //找到了左侧第一个比栈顶大的元素的下标
                lis[i] = stack.peek();
            }

            stack.push(i);

        }

        System.out.println(Arrays.toString(lis));
        System.out.println(Arrays.toString(ris));

        int[] pis = new int[nums.length];
        for (int i = 0; i < pis.length; i++) {
            if (lis[i] == -1 && ris[i] == -1) {
                pis[i] = -1;
                continue;
            }
            if (lis[i] == -1) {
                pis[i] = ris[i];
            } else if (ris[i] == -1) {
                pis[i] = lis[i];
            } else if (nums[lis[i]] < nums[ris[i]]) {
                pis[i] = lis[i];
            } else {
                pis[i] = ris[i];
            }
        }


        return pis;

    }


}
