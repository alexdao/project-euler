import java.util.HashSet;

/**
 * https://projecteuler.net/problem=32
 */
public class P032 implements Problem {

    public static void main(String args[]) {
        System.out.println(new P032().solve());
    }

    private static long checkPandigital(long n) {
        String num = "" + n;
        for (int i = 1; i <= num.length() - 5; i++) {
            String leftSide = num.substring(0, i + 1);
            String rightSide = num.substring(i + 1);
            for (int j = 1; j < leftSide.length(); j++) {
                String first = leftSide.substring(0, j);
                String second = leftSide.substring(j);
                if (Long.parseLong(first) * Long.parseLong(second)
                        == Long.parseLong(rightSide)) {
                    return Long.parseLong(rightSide);
                }
            }
        }
        return 0;
    }

    @Override
    public String solve() {
        HashSet<Long> products = new HashSet<>();
        for (int i = 123456789; i <= 987654321; i++) {
            if (!Util.isPandigital(i)) {
                continue;
            }
            products.add(checkPandigital(i));
        }
        return Long.toString(products.stream().mapToLong(Long::longValue).sum());
    }
}
