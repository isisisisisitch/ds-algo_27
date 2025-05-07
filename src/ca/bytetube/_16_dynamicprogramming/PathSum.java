package ca.bytetube._16_dynamicprogramming;

public class PathSum {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{3, 1, 0, 2}, {4, 3, 2, 1}, {5, 2, 1, 0}};
        System.out.println(sum(matrix));
    }

    //计算从(0,0)出发，到达(m,n)时最小路径和
    //计算从(i,j)出发，到达(m,n)时最小路径和,当i = 0,j = 0时，即原问题的解
    public static int sum1(int[][] matrix) {

        return sum1(matrix, 0, 0);
    }

    //计算从(i,j)出发，到达(m,n)时最小路径和
    //sum(i,j) = matrix[i][j] + sum(i, j + 1)
    private static int sum1(int[][] matrix, int i, int j) {
        if (i == matrix.length - 1 && j == matrix[0].length - 1) return matrix[i][j];
        //1.last row
        if (i == matrix.length - 1) return matrix[i][j] + sum1(matrix, i, j + 1);

        //2.last col
        if (j == matrix[0].length - 1) return matrix[i][j] + sum1(matrix, i + 1, j);

        int right = sum1(matrix, i, j + 1);
        int down = sum1(matrix, i + 1, j);
        return Math.min(right, down) + matrix[i][j];
    }
    //计算从(0,0)出发，到达(i,j)时最小路径和
    //计算从(0,0)出发，到达(i,j)时最小路径和,当i = m,j = n时，即原问题的解
    public static int sum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        //① Define state
        int[][] dp = new int[rows][cols];
        //② Set initial state
        dp[0][0] = matrix[0][0];
        //first row
        for (int i = 1; i < cols; i++) dp[0][i] = dp[0][i - 1] + matrix[0][i];
        //first col
        for (int i = 1; i < rows; i++) dp[i][0] = dp[i - 1][0] + matrix[i][0];
        //③ Determine the state transition equation
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + matrix[i][j];
            }
        }

        return dp[rows - 1][cols - 1];
    }


}
