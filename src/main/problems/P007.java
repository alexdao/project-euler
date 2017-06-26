import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * https://projecteuler.net/problem=7
 */
public class P007 implements Problem {

    public static void main(String args[]) {
        System.out.println(new P007().solve());
    }

    @Override
    public String solve() {
        Set<Integer> primes = new HashSet<>();
        for (int i = 2; i < Integer.MAX_VALUE; i++) {
            boolean hasFactor = false;
            for (int prime : primes) {
                if (i % prime == 0) {
                    hasFactor = true;
                }
            }
            if (!hasFactor) {
                primes.add(i);
            }
            if (primes.size() == 10001) {
                break;
            }
        }
        return Integer.toString(Collections.max(primes));
    }
}
