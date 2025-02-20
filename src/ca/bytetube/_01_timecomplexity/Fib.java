package ca.bytetube._01_timecomplexity;

/**
 * https://leetcode.com/problems/fibonacci-number/
 *
 * @author dall.
 */
public class Fib {

    public int fib(int n) {
        if (n <= 1) return n;
        int first = 0;
        int second = 1;
        for (int i = 0; i < n - 1; i++) {
            int sum = first + second;
            first = second;
            second = sum;
        }

        return second;
    }
    //在递归过程的每层中如何共享（容器）数据
    //1.把要共享的容器作为递归方法的参数传递
    //2.把要共享的容器作为成员变量


    public int fib2(int n) {

        if (n <= 1) return n;
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 1;

       return fib2(n, arr);
    }

    private int fib2(int n, int[] arr) {
        if (arr[n] == 0) {
            arr[n] = fib2(n - 1, arr) + fib2(n - 2, arr);
        }

        return arr[n];
    }

    public int fib1(int n) {
        if (n <= 1) return n;
        return fib1(n - 1) + fib1(n - 2);
    }
}
