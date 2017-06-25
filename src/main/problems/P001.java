package problems;

import java.util.HashSet;
import java.util.Set;

/**
 * https://projecteuler.net/problem=1
 */
public class P001 implements Problem {

    public static void main(String args[]) {
        System.out.println(new P001().solve());
    }

    @Override
    public String solve() {
        Set<Integer> multiples = new HashSet<>();
        for (int i = 3; i < 1000; i += 3) {
            multiples.add(i);
        }
        for (int i = 5; i < 1000; i += 5) {
            multiples.add(i);
        }
        int total = 0;
        for (Integer i : multiples) {
            total += i;
        }
        return Integer.toString(total);
    }
}
