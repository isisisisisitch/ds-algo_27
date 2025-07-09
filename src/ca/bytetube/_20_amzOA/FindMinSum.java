package ca.bytetube._20_amzOA;

public class FindMinSum {
    public static void main(String[] args) {
        System.out.println(findMinSum(new int[]{3,4,1,6,2}));
    }


    public static int findMinSum(int[] power) {
        int difference = 0;
        for (int i = 1; i < power.length; i++) {
            if (power[i] < power[i - 1]) {
                difference += power[i - 1] - power[i];
                power[i] = power[i - 1];
            }
        }

        return difference;
    }
}
