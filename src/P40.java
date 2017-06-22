/**
 * Created by alex on 6/22/17.
 * https://projecteuler.net/problem=40
 */
public class P40 {

    private static long digitCount = 0;
    private static long output = 1;

    public static void main(String args[]) {
        long currNum = 1;

        while(true) {
            checkLength(currNum);
            if (digitCount == -1) {
                System.out.println(output);
                return;
            }
            currNum++;
        }
    }

    private static void checkLength(long currNum) {
        long lengthToAdd = Long.toString(currNum).length();

        for (int i = 1; i <= lengthToAdd; i++) {
            digitCount++;
            if (digitCount == 1 || digitCount == 10 || digitCount == 100 || digitCount == 1000 || digitCount == 10000 ||
                    digitCount == 100000 || digitCount == 1000000) {
                System.out.println("found digit" + currNum);

                output *= Long.parseLong(""+Long.toString(currNum).charAt(i-1));
            }
        }

        if (digitCount > 1000000) {
            digitCount = -1;
        }
    }
}
