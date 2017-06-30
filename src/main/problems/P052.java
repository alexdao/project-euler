import java.util.HashSet;
import java.util.Set;

public class P052 implements Problem {

    public static void main(String args[]) {
        System.out.println(new P052().solve());
    }

    @Override
    public String solve() {
        long x = 1;
        long limit = 2 * x;
        long curr = x;
        while (true) {
            while (curr < limit) {
                Set<Long> digits = getDigits(curr);
                long curr2 = curr * 2;
                long curr3 = curr * 3;
                long curr4 = curr * 4;
                long curr5 = curr * 5;
                long curr6 = curr * 6;
                if (hasDigits(digits, curr2) &&
                        hasDigits(digits, curr3) &&
                        hasDigits(digits, curr4) &&
                        hasDigits(digits, curr5) &&
                        hasDigits(digits, curr6)) {
                    return Long.toString(curr);
                }

                curr++;
            }
            x *= 10;
            limit *= 10;
            curr = x;
        }
    }

    private Set<Long> getDigits(long n) {
        Set<Long> digits = new HashSet<>();
        while (n != 0) {
            digits.add(n % 10);
            n /= 10;
        }
        return digits;
    }

    private boolean hasDigits(Set<Long> digits, long n) {
        Set<Long> digitsCopy = new HashSet<>(digits);
        if (Long.toString(n).length() != digits.size()) {
            return false;
        }

        while (n != 0) {
            if (!digitsCopy.remove(n % 10)) {
                return false;
            }
            n /= 10;
        }
        return true;
    }
}
