package ca.bytetube._12_recursion;

public class PrintAllSub {
    public static void main(String[] args) {
        printAllSub("abc");
    }


    public static void printAllSub(String s) {
        String str = "";
        printAllSub(s, 0, str);

    }

    private static void printAllSub(String s, int index, String str) {
        if (index == s.length()) {
            System.out.println(str);
            return;
        }

        printAllSub(s, index + 1, str);

        printAllSub(s, index + 1, str + s.charAt(index));

    }
}
