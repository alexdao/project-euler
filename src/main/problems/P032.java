package problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * https://projecteuler.net/problem=32
 */
public class P032 {

    public static void main(String args[]) {
        HashSet<Long> products = new HashSet<>();
        for (long i = 123456789L; i <= 987654321L; i++) {
            if (!checkUsesEveryDigit(i)) {
                continue;
            }
            products.add(checkPandigital(i));
        }
        System.out.println(products.stream().mapToLong(Long::longValue).sum());
    }

    private static long checkPandigital(long n) {
        String num = "" + n;
        for (int i = 1; i <= num.length() - 5; i++) {
            String leftSide = num.substring(0, i + 1);
            String rightSide = num.substring(i + 1);
            for (int j = 1; j < leftSide.length(); j++) {
                String first = leftSide.substring(0, j);
                String second = leftSide.substring(j);
                if (Long.parseLong(first) * Long.parseLong(second)
                        == Long.parseLong(rightSide)) {
                    System.out.println(n);
                    return Long.parseLong(rightSide);
                }
            }
        }
        return 0;
    }

    private static boolean checkUsesEveryDigit(long n) {
        String num = "" + n;
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
}
