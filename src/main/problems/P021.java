import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://projecteuler.net/problem=21
 */
public class P021 implements Problem {

    public static void main(String args[]) {
        System.out.println(new P021().solve());
    }

    private static int divisorSum(int n) {
        if (n == 1) {
            return 0;
        }
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

    @Override
    public String solve() {
        Map<Integer, Integer> divisors = new HashMap<>();
        Set<Integer> amicableNums = new HashSet<>();
        for (int i = 1; i < 10000; i++) {
            int divisorSum = divisorSum(i);
            Integer amicable = divisors.get(divisorSum);
            if (amicable != null
                    && amicable == i) {
                amicableNums.add(i);
                amicableNums.add(divisorSum);
            }

            divisors.put(i, divisorSum);
        }

        long sum = 0;
        for (int i : amicableNums) {
            sum += i;
        }
        return Long.toString(sum);
    }
}
