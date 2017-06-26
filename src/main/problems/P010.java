/**
 * https://projecteuler.net/problem=10
 */
public class P010 implements Problem {

    public static void main(String args[]) {
        System.out.println(new P010().solve());
    }

    @Override
    public String solve() {
        long total = 0;
        for (int i = 2; i < 2000000; i++) {
            if (Util.isPrime(i)) {
                total += i;
            }
        }
        return Long.toString(total);
    }
}
