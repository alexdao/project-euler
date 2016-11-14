import java.util.HashSet;

/**
 * Created by alex on 11/14/16.
 * Problem: https://projecteuler.net/problem=29
 */
public class P29 {

    public static void main(String args[]) {
        HashSet<Double> terms = new HashSet<>();
        for (double a = 2; a <= 100; a++) {
            for (double b = 2; b <= 100; b++) {
                terms.add(Math.pow(a,b));
            }
        }

        System.out.println(terms.size());
    }
}
