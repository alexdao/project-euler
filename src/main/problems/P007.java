package problems;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by alex on 5/10/16.
 */
public class P007 {

    public static void main(String args[]) {
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
        System.out.print(Collections.max(primes));
    }
}
