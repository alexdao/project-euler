import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * https://projecteuler.net/problem=43
 * This one takes a while.. Can probably do it more efficiently
 */

public class P043 implements Problem {

    public static void main(String args[]) {
        System.out.println(new P043().solve());
    }

    private static boolean checkUsesEveryDigit(long n) {
        String num = "" + n;
        List<Character> chars = new ArrayList<>();
        for (int i = 0; i < num.length(); i++) {
            if (chars.contains(num.charAt(i))) {
                return false;
            }
            chars.add(num.charAt(i));
        }
        return true;
    }

    private static boolean hasDivisibilityProperty(long n) {
        String num = "" + n;
        String first = num.substring(1, 4);
        String second = num.substring(2, 5);
        String third = num.substring(3, 6);
        String fourth = num.substring(4, 7);
        String fifth = num.substring(5, 8);
        String sixth = num.substring(6, 9);
        String seventh = num.substring(7, 10);

        return !(Integer.valueOf(first) % 2 != 0 ||
                Integer.valueOf(second) % 3 != 0 ||
                Integer.valueOf(third) % 5 != 0 ||
                Integer.valueOf(fourth) % 7 != 0 ||
                Integer.valueOf(fifth) % 11 != 0 ||
                Integer.valueOf(sixth) % 13 != 0 ||
                Integer.valueOf(seventh) % 17 != 0);
    }

    @Override
    public String solve() {
        BigInteger sum = BigInteger.ZERO;
        for (long i = 1023456789L; i <= 9876543210L; i++) {
            if (!checkUsesEveryDigit(i)) {
                continue;
            }
            if (hasDivisibilityProperty(i)) {
                sum = sum.add(new BigInteger("" + i));
            }
        }
        return sum.toString();
    }
}
