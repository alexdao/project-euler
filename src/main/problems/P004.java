package problems;

import util.Util;

/**
 * https://projecteuler.net/problem=4
 */
public class P004 implements Problem{

    public static void main(String args[]) {
        System.out.println(new P004().solve());
    }

    @Override
    public String solve() {
        int maxProduct = 998002;
        while (maxProduct >= 10000) {
            maxProduct--;
            if (!Util.isPalindrone(maxProduct)) {
                continue;
            }
            for (int i = 100; i < 999; i++) {
                int divisor = maxProduct / i;
                if (maxProduct % i == 0 && divisor >= 100 && divisor <= 999) {
                    return Integer.toString(maxProduct);
                }
            }
        }
        return "not found";
    }
}
