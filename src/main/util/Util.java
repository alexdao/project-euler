import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    static int calcFactorial(int n) {
        if (n == 0) {
            return 1;
        }
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;

        }
        return sum;
    }

    static BigInteger calcFactorial(BigInteger n) {
        BigInteger factorial = BigInteger.valueOf(1);
        if (n.equals(BigInteger.valueOf(0))) {
            return factorial;
        }

        for (int i = 1; i <= n.intValue(); i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        return factorial;
    }

    static int combination(int n, int r) {
        return calcFactorial(n) / (calcFactorial(r) * calcFactorial(n - r));
    }

    static long combination(long n, long r) {
        return calcFactorial(n) / (calcFactorial(r) * calcFactorial(n - r));
    }

    static BigInteger combination(BigInteger n, BigInteger r) {
        return calcFactorial(n).divide(calcFactorial(r).multiply(calcFactorial(n.subtract(r))));
    }

    static boolean isPandigital(int n) {
        String num = Integer.toString(n);
        int length = num.length();
        List<Character> chars = new ArrayList<>();
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '0') {
                return false;
            }
            if (Integer.parseInt(Character.toString(num.charAt(i))) > length) {
                return false;
            }
            if (chars.contains(num.charAt(i))) {
                return false;
            }
            chars.add(num.charAt(i));
        }
        return true;
    }

    static boolean isPentagonal(long n) {
        double i = (Math.sqrt(24 * n + 1) + 1) / 6;
        return i == Math.floor(i);
    }

    static boolean isHexagonal(long n) {
        double i = (Math.sqrt(8 * n + 1) + 1) / 4;
        return i == Math.floor(i);
    }

    static Set<Integer> getPrimeFactorization(int n) {
        Set<Integer> primeFactors = new HashSet<>();
        return getPrimeFactorizationHelper(n, primeFactors);
    }

    private static Set<Integer> getPrimeFactorizationHelper(int n, Set<Integer> primeFactors) {
        boolean added = false;
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                added = true;
                primeFactors.add(i);
                n /= i;
                break;
            }
        }
        if (added) {
            getPrimeFactorizationHelper(n, primeFactors);
        }
        return primeFactors;
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
        Set<Integer> primes = getPrimeFactorization(20);
        for(Integer i: primes) {
            System.out.println(i);
        }
    }
}
