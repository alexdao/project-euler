/**
 * We know that any 8-digit or 9-digit pandigital number is divisible by 9, based on
 * the divisibility rule for 9 for summing digits. We only need to search for 7-digit pandigitals or lower.
 */

public class P041 implements Problem {

    public static void main(String args[]) {
        System.out.println(new P041().solve());
    }

    @Override
    public String solve() {
        for (int i = 7654321; i > 1; i--) {
            if (Util.isPandigital(i) && Util.isPrime(i)) {
                return Integer.toString(i);
            }
        }
        return "Not found.";
    }
}
