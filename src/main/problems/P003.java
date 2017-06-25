package problems;

import util.Util;

import java.math.BigInteger;

/**
 * https://projecteuler.net/problem=3
 */
public class P003 implements Problem{

    public static void main(String args[]) {
        System.out.println(new P003().solve());
    }

    @Override
    public String solve() {
        BigInteger large = new BigInteger("600851475143");
        BigInteger start = new BigInteger("2");
        while (start.multiply(start).compareTo(large) < 0) {
            if (large.mod(start).equals(new BigInteger("0"))) {
                large = large.divide(start);
                if(Util.isPrime(large)){
                    return large.toString();
                }
            }
            start = start.add(new BigInteger("1"));
        }
        return "not found";
    }
}
