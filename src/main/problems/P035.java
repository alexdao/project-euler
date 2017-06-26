import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://projecteuler.net/problem=35
 */
public class P035 implements Problem {

    private static Set<Integer> primes = new HashSet<>();

    public static void main(String args[]) {
        System.out.println(new P035().solve());
    }

    @Override
    public String solve() {
        int count = 0;
        for (int i = 2; i < 1000000; i++) {
            boolean isCircularPrime = false;
            if (Util.isPrime(i)) {
                isCircularPrime = true;
                primes.add(i);
                List<Integer> permutations = getCycles(i);
                for (Integer num : permutations) {
                    if (!primes.contains(num)) {
                        if (Util.isPrime(num)) {
                            primes.add(num);
                        } else {
                            isCircularPrime = false;
                            break;
                        }
                    }
                }
            }
            if (isCircularPrime) {
                count++;
            }
        }
        return Integer.toString(count);
    }

    private static List<Integer> getCycles(int n) {
        List<Integer> cycles = new ArrayList<>();
        String num = Integer.toString(n);
        for (int i = 1; i < num.length(); i++) {
            cycles.add(Integer.parseInt(num.substring(i) + num.substring(0, i)));
        }
        return cycles;
    }
}
