import java.math.BigInteger;

/**
 * Created by alex on 11/14/16.
 * Problem: https://projecteuler.net/problem=55
 */
public class P55 {

    public static void main(String args[]) {
        int count = 0;
        for (int i = 0; i < 10000; i++) {
            if (isLychel(i)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean isLychel(long n) {
        int iteration = 0;
        BigInteger curr = BigInteger.valueOf(n);
        StringBuilder buff = new StringBuilder();
        while(iteration < 50) {
            buff.setLength(0);
            buff.append(curr);
            BigInteger reversed = new BigInteger(buff.reverse().toString());
            curr = curr.add(reversed);
            iteration ++;

            if(isPalindrone(curr)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindrone(BigInteger n) {
        String num = n.toString();
        for (int i = 0; i < num.length() / 2; i++) {
            if (num.charAt(i) != num.charAt(num.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
