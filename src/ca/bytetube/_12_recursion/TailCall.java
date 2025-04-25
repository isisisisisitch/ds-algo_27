package ca.bytetube._12_recursion;

public class TailCall {

    public void test1() {
        int a = 10;
        int b = a + 20;
        test2();
    }

    private void test2() {
        int x = 100;
        int y = 200;
    }

}
