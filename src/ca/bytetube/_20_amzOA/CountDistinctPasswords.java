package ca.bytetube._20_amzOA;

import java.util.HashSet;
import java.util.Set;

public class CountDistinctPasswords {
    public static void main(String[] args) {
        System.out.println(countDistinctPasswords("abaa"));
    }

    public static int countDistinctPasswords(String password) {
        Set<String> set = new HashSet<>();

        for (int i = 0; i < password.length(); i++) {
            for (int j = i; j < password.length(); j++) {
                String reversed = new StringBuilder(password.substring(i, j + 1)).reverse().toString();
                String newPassword = password.substring(0, i) + reversed + password.substring(j + 1);
                set.add(newPassword);
            }
        }

        return set.size();

    }

}
