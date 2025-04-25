package ca.bytetube._12_recursion;

/**
 * https://leetcode.com/problems/fibonacci-number/
 */
public class Fib {

    public int fib(int n) {
        if (n <= 1) return n;
        return fib(n, 0, 1);
    }

    private int fib(int n, int first, int second) {
        if (n <= 1) return second;
        return fib(n - 1, second, first + second);
    }

    public int fib6(int n) {
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

    public int fib5(int n) {
        if (n <= 1) return n;
        int[] arr = new int[2];
        arr[0] = 1;
        arr[1] = 1;

        for (int i = 3; i <= n; i++) {
            arr[i & 1] = arr[(i - 1) & 1] + arr[(i - 2) & 1];
        }
        return arr[n & 1];
    }

    public int fib4(int n) {
        if (n <= 1) return n;
        int[] arr = new int[2];
        arr[0] = 1;
        arr[1] = 1;

        for (int i = 3; i <= n; i++) {
            //arr[3] = arr[2] + arr[1];
            //         arr[0] + arr[1];
            //arr[4] = arr[3] + arr[2];
            //         arr[1] + arr[(i - 2)%2]
            arr[i % 2] = arr[(i - 1) % 2] + arr[(i - 2) % 2];
        }
        return arr[n % 2];
    }


    public int fi3(int n) {
        if (n <= 1) return n;
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 1;

        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }


    /**
     * 递归过程中，数据共享的方法：
     * 1.把数据共享容器作为参数进行传递（推荐）
     * 2.把容器作为类的成员变量
     */
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

    /**
     * @param n 待求的fib num
     * @return fib num所对应的fib val
     */
    public int fib1(int n) {
        if (n <= 1) return n;
        return fib1(n - 1) + fib1(n - 2);
    }


}
