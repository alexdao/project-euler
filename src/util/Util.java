package util;

import java.math.BigInteger;

/**
 * Created by alex on 6/23/17.
 */
public class Util {

    public static boolean isPrime(BigInteger n) {
        if (n.compareTo(new BigInteger("1")) < 0)
            return false;
        else if (n.compareTo(new BigInteger("3")) <= 0)
            return true;
        else if (n.mod(new BigInteger("2")).equals(new BigInteger("0")) || n.mod(new BigInteger("3")).equals(new BigInteger("0")))
            return false;
        BigInteger i = new BigInteger("5");
        while (i.multiply(i).compareTo(n) <= 0) {
            if (n.mod(i).equals(new BigInteger("0")) || n.mod(i.add(new BigInteger("2"))).equals(new BigInteger("0"))) {
                return false;
            }
            i = i.add(new BigInteger("6"));
        }
        return true;
    }
}
