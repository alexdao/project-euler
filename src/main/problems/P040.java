/**
 * https://projecteuler.net/problem=40
 */
public class P040 implements Problem {

    private static long digitCount = 0;
    private static long output = 1;

    public static void main(String args[]) {
        System.out.println(new P040().solve());
    }

    private static void checkLength(long currNum) {
        long lengthToAdd = Long.toString(currNum).length();

        for (int i = 1; i <= lengthToAdd; i++) {
            digitCount++;
            if (digitCount == 1 || digitCount == 10 || digitCount == 100 || digitCount == 1000 || digitCount == 10000 ||
                    digitCount == 100000 || digitCount == 1000000) {
                System.out.println("found digit" + currNum);

                output *= Long.parseLong("" + Long.toString(currNum).charAt(i - 1));
            }
        }

        if (digitCount > 1000000) {
            digitCount = -1;
        }
    }

    @Override
    public String solve() {
        long currNum = 1;

        while (true) {
            checkLength(currNum);
            if (digitCount == -1) {
                return Long.toString(output);
            }
            currNum++;
        }
    }
}
