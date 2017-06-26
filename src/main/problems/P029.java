import java.util.HashSet;

/**
 * Problem: https://projecteuler.net/problem=29
 */
public class P029 implements Problem {

    public static void main(String args[]) {
        System.out.println(new P029().solve());
    }

    @Override
    public String solve() {
        HashSet<Double> terms = new HashSet<>();
        for (double a = 2; a <= 100; a++) {
            for (double b = 2; b <= 100; b++) {
                terms.add(Math.pow(a, b));
            }
        }

        return Integer.toString(terms.size());
    }
}
