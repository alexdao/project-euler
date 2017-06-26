/**
 * Problem: https://projecteuler.net/problem=34
 */
public class P034 implements Problem {

    public static void main(String args[]) {
        System.out.println(new P034().solve());
    }

    private static boolean isSumOfFactorial(long n) {
        long sum = 0;
        long temp = n;
        while (temp != 0) {
            long curr = temp % 10;
            temp /= 10;
            sum += Util.calcFactorial(curr);
        }
        return sum == n;
    }

    @Override
    public String solve() {
        long sum = 0;

        // max it can be is a 7 digit number
        for (int i = 3; i <= 9999999; i++) {
            if (isSumOfFactorial(i)) {
                sum += i;
            }
        }
        return Long.toString(sum);
    }
}
