package ca.bytetube._00_leetcode.array;

import java.util.Arrays;
import java.util.Map;

/**
 * https://leetcode.com/problems/most-profit-assigning-work/
 *
 * @author dall.
 */
public class MaxProfitAssignment {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] jobs = new int[n][2];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }

        Arrays.sort(jobs, (int[] a, int[] b) -> a[0] - b[0]);

        Arrays.sort(worker);

        int jobIndex = 0;
        int bestProfit = 0;
        int totalProfit = 0;
        for (int ability : worker) {
            while (jobIndex < n && jobs[jobIndex][0] <= ability) {
                bestProfit = Math.max(bestProfit, jobs[jobIndex][1]);
                jobIndex++;
            }
            totalProfit += bestProfit;
        }

        return totalProfit;
    }
}
