/**
 * https://projecteuler.net/problem=36
 */

public class P036 implements Problem {

    public static void main(String args[]) {
        System.out.println(new P036().solve());
    }

    @Override
    public String solve() {
        long sum = 0L;
        for (int i = 1; i <= 1000000; i++) {
            String binaryString = Integer.toBinaryString(i);
            if (Util.isPalindrone(i) && Util.isPalindrone(binaryString)) {
                sum += i;
            }
        }
        return Long.toString(sum);
    }
}
