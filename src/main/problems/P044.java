import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 * https://projecteuler.net/problem=44
 */
public class P044 implements Problem {

    public static void main(String args[]) {
        System.out.println(new P044().solve());
    }

    @Override
    public String solve() {
        int curr = 1;
        Set<Integer> pentagonals = new TreeSet<>(Collections.reverseOrder());
        pentagonals.add(1);
        while (true) {
            int currPentagonal = curr * (3 * curr - 1) / 2;
            int d = checkSumAndDifference(currPentagonal, pentagonals);
            if (d > 0) {
                return Integer.toString(d);
            }
            pentagonals.add(currPentagonal);
            curr++;
        }
    }

    private int checkSumAndDifference(int currPentagonal, Set<Integer> pentagonals) {
        for (Integer n : pentagonals) {
            int difference = currPentagonal - n;
            if (pentagonals.contains(difference)) {
                int sum = currPentagonal + n;
                if (Util.isPentagonal(sum)) {
                    return Math.abs(currPentagonal - n);
                }
            }
        }
        return -1;
    }




}
