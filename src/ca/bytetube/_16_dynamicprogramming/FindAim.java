package ca.bytetube._16_dynamicprogramming;

public class FindAim {
    public static void main(String[] args) {
        int[] arr = {3, 2, 5};
        System.out.println(findAim(arr, 9));
    }


    public static boolean findAim(int[] arr, int aim) {
        boolean[][] dp = new boolean[arr.length + 1][aim + 1];
        for (int i = 0; i < dp.length; i++) dp[i][aim] = true;
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = aim - 1; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                if (j + arr[i] <= aim) {
                    dp[i][j] = dp[i + 1][j] || dp[i + 1][j + arr[i]];
                }
            }
        }

        return dp[0][0];
    }

    public static boolean findAim1(int[] arr, int aim) {
        return findAim1(arr, aim, 0, 0);

    }

    private static boolean findAim1(int[] arr, int aim, int index, int sum) {
        if (sum == aim) return true;
        if (index == arr.length) return false;

        return findAim1(arr, aim, index + 1, sum + arr[index]) ||
                findAim1(arr, aim, index + 1, sum);

    }
}
