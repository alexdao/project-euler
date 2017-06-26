import java.math.BigInteger;

/**
 * https://projecteuler.net/problem=25
 */
public class P025 implements Problem {

    public static void main(String args[]) {
        System.out.println(new P025().solve());
    }

    private static boolean checkLen(BigInteger f2) {
        String f2String = f2.toString();
        return f2String.length() == 1000;
    }

    @Override
    public String solve() {
        BigInteger f1 = new BigInteger("1");
        BigInteger f2 = new BigInteger("1");
        int f2Index = 2;
        while (!checkLen(f2)) {
            BigInteger temp = f1.add(f2);
            f1 = f2;
            f2 = temp;
            f2Index++;
        }
        return Integer.toString(f2Index);
    }
}
