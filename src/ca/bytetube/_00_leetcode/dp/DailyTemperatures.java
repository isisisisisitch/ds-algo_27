package ca.bytetube._00_leetcode.dp;

import java.util.Stack;

/**
 * https://leetcode.com/problems/daily-temperatures/
 *
 * @author dall.
 */
public class DailyTemperatures {

    public int[] dailyTemperatures2(int[] temperatures) {
        int[] result = new int[temperatures.length];
        for (int i = temperatures.length - 2; i >= 0; i--) {
            int j = i + 1;
            while (true) {
                if (temperatures[i] < temperatures[j]) {
                    result[i] = j - i;
                    break;
                } else if (result[j] == 0) {//2.1 & 3.1
                    result[i] = 0;
                    break;
                } else if (temperatures[i] == temperatures[j]) {//2.2
                    result[i] = result[j] + j - i;
                    break;

                } else {//3.2
                    j = j + result[j];
                }

            }
        }

        return result;
    }


    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();

        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                result[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return result;
    }
}
