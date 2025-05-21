package ca.bytetube._17_sequence;

public class BruteForce {
    public static void main(String[] args) {
        String pattern = "1000";
        String text = "1001000010";
        System.out.println( indexOf(text,pattern));
    }
    public static int indexOf(String text, String pattern) {
        if (text == null || pattern == null || pattern.isEmpty() || text.isEmpty())
            throw new RuntimeException("invalid params");

        char[] textCharArray = text.toCharArray();
        char[] patternCharArray = pattern.toCharArray();
        int pi = 0;
        int ti = 0;
        int pLen = patternCharArray.length;
        int tLen = textCharArray.length;
        while (pi < pLen && ti <= tLen - pLen) {
            //match successfully
            //pi++
            //ti++
            if (textCharArray[ti] == patternCharArray[pi]) {
                pi++;
                ti++;
            } else {
                //match unsuccessfully
                //ti –= pi – 1
                //pi = 0

                ti -= pi - 1;
                pi = 0;
            }
        }

        return pi == pLen ? ti - pi : -1;


    }
}
