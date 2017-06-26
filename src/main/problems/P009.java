import java.util.HashSet;
import java.util.Set;

/**
 * https://projecteuler.net/problem=9
 */
public class P009 implements Problem {

    public static void main(String args[]) {
        System.out.println(new P009().solve());
    }

    @Override
    public String solve() {
        Set<Integer> squares = new HashSet<>();
        for (int i = 1; i <= 1000; i++) {
            squares.add(i * i);
        }
        for (int j : squares) {
            for (int k : squares) {
                if (j != k && squares.contains(j + k)) {
                    double a = Math.sqrt(j);
                    double b = Math.sqrt(k);
                    double c = Math.sqrt(j + k);
                    if (a + b + c == 1000) {
                        return Double.toString(a * b * c);
                    }
                }
            }
        }
        return "Not found.";
    }
}
