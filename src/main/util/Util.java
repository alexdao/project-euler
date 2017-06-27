import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Common functions for Project Euler problems
 */
public class Util {

    static boolean isPrime(BigInteger n) {
        if (n.compareTo(new BigInteger("1")) < 0)
            return false;
        else if (n.compareTo(new BigInteger("3")) <= 0)
            return true;
        else if (n.mod(new BigInteger("2")).equals(new BigInteger("0")) || n.mod(new BigInteger("3")).equals(new BigInteger("0")))
            return false;
        BigInteger i = new BigInteger("5");
        while (i.multiply(i).compareTo(n) <= 0) {
            if (n.mod(i).equals(new BigInteger("0")) || n.mod(i.add(new BigInteger("2"))).equals(new BigInteger("0"))) {
                return false;
            }
            i = i.add(new BigInteger("6"));
        }
        return true;
    }

    static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        else if (n <= 3)
            return true;
        else if (n % 2 == 0 || n % 3 == 0)
            return false;
        int i = 5;
        while (i * i <= n) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
            i += 6;
        }
        return true;
    }

    static boolean isPalindrone(String s) {
        for (int i = 0; i <= s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    static boolean isPalindrone(int i) {
        String s = "" + i;
        return isPalindrone(s);
    }

    static long calcFactorial(long n) {
        if (n == 0) {
            return 1;
        }
        long sum = 1;
        for (long i = 1; i <= n; i++) {
            sum *= i;

        }
        return sum;
    }

    static boolean isPandigital(int n) {
        String num = Integer.toString(n);
        if (num.length() != 9) {
            return false;
        }
        List<Character> chars = new ArrayList<>();
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '0') {
                return false;
            }
            if (chars.contains(num.charAt(i))) {
                return false;
            }
            chars.add(num.charAt(i));
        }
        return true;
    }

    static class Fraction {
        int numerator;
        int denominator;

        Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
        }

        void simplifyFraction() {
            for (int i = 2; i <= numerator; i++) {
                if (numerator % i == 0 && denominator % i == 0) {
                    numerator /= i;
                    denominator /= i;
                    simplifyFraction();
                    break;
                }
            }
        }

        int getDenominator() {
            return denominator;
        }

        int getNumerator() {
            return numerator;
        }
    }

    public static void main(String args[]) {
        String s = "1234321";
        System.out.println(isPalindrone(s));
    }
}
