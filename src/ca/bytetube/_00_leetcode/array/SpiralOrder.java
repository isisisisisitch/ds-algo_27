package ca.bytetube._00_leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/
 *
 * @author dall.
 */
public class SpiralOrder {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4}};
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int top = 0;
        int left = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            //left top--->right top
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;

            //right top --->right bottom
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;

            if (top > bottom || left > right) break;
            //right bottom ---> left bottom

            for (int i = right; i >= left; i--) {
                list.add(matrix[bottom][i]);
            }

            bottom--;

            //left bottom --->left top
            for (int i = bottom; i >= top; i--) {
                list.add(matrix[i][left]);
            }
            left++;

        }
        return list;
    }
}
