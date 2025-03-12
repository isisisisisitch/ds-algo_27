package ca.bytetube._04_stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
            //stack.add(3,15);
        }

        while (!stack.isEmpty()){
            System.out.println( stack.pop());
            //stack.remove(4);
        }
    }
}
