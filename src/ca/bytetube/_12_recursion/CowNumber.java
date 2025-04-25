package ca.bytetube._12_recursion;

public class CowNumber {
    public static void main(String[] args) {
        System.out.println(cowNumber(5));
    }

    public int cowNumber1(int n) {
        if (n <= 4) return n;
        return cowNumber1(n - 1) + cowNumber1(n - 3);
    }

    public static int cowNumber(int n) {
        if (n <= 1) return n;
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        arr[4] = 4;
        return cowNumber(n, arr);
    }

    private static int cowNumber(int n, int[] arr) {
        if (arr[n] == 0) {
            arr[n] = cowNumber(n - 1, arr) + cowNumber(n - 3, arr);
        }

        return arr[n];
    }


}
