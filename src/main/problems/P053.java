import java.math.BigInteger;

public class P053 implements Problem {

    public static void main(String args[]) {
        System.out.println(new P053().solve());
    }

    @Override
    public String solve() {
        int count = 0;
        for (int n = 1; n <= 100; n++) {
            for (int r = 1; r <= n; r++) {
                BigInteger bigN = BigInteger.valueOf(n);
                BigInteger bigR = BigInteger.valueOf(r);
                if (Util.combination(bigN, bigR).compareTo(BigInteger.valueOf(1000000)) > 0) {
                    count++;
                }

            }
        }
        return Integer.toString(count);
    }
}
