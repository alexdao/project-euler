import java.math.BigInteger;

/**
 * https://projecteuler.net/problem=20
 */
public class P020 implements Problem {

    public static void main(String args[]) {
        System.out.println(new P020().solve());
    }

    @Override
    public String solve() {
        int num = 100;
        BigInteger total = new BigInteger("1");
        while (num > 1) {
            total = total.multiply(new BigInteger("" + num));
            num--;
        }
        String factorial = total.toString();
        int sum = 0;
        for (int i = 0; i < factorial.length(); i++) {
            sum += Integer.parseInt(factorial.substring(i, i + 1));
        }
        return Integer.toString(sum);
    }
}
