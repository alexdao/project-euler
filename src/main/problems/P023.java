import java.math.BigInteger;
import java.util.HashSet;

/**
 * https://projecteuler.net/problem=23
 */
public class P023 implements Problem {

    public static void main(String args[]) {
        System.out.println(new P023().solve());
    }

    private static boolean isAbundant(int i) {
        int sum = 0;
        for (int j = 1; j < i / 2 + 1; j++) {
            if (i % j == 0) {
                sum += j;
            }
        }
        return sum > i;
    }

    @Override
    public String solve() {
        HashSet<Integer> abundantNums = new HashSet<>();
        for (int i = 1; i <= 28123; i++) {
            if (isAbundant(i)) {
                abundantNums.add(i);
            }
        }

        BigInteger sum = new BigInteger("0");
        for (int i = 1; i <= 28123; i++) {
            boolean isASumOfAbundantNums = false;
            for (Integer abundant : abundantNums) {
                int test = i - abundant;
                if (abundantNums.contains(test)) {
                    isASumOfAbundantNums = true;
                }
            }
            if (!isASumOfAbundantNums) {
                sum = sum.add(new BigInteger("" + i));
            }
        }
        return sum.toString();
    }
}
