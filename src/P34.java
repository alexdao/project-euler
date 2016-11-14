/**
 * Created by alex on 11/14/16.
 * Problem: https://projecteuler.net/problem=34
 */
public class P34 {

    public static void main(String args[]) {
        long sum = 0;

        // max it can be is a 7 digit number
        for (int i = 3; i <= 9999999; i++) {
            if (isSumOfFactorial(i)) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    private static boolean isSumOfFactorial(long n) {
        long sum = 0;
        long temp = n;
        while (temp != 0) {
            long curr = temp % 10;
            temp /= 10;
            sum += calcFactorial(curr);
        }
        return sum == n;
    }

    private static long calcFactorial(long n) {
        long sum = 1;
        for (long i = 1; i <= n; i++) {
            sum *= i;

        }
        return sum;
    }
}
