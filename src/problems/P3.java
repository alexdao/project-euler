package problems;

import util.Util;

import java.math.BigInteger;

/**
 * Created by alex on 5/11/16.
 */
public class P3 {

    public static void main(String args[]) {
        BigInteger large = new BigInteger("600851475143");
        BigInteger start = new BigInteger("2");
        while (start.multiply(start).compareTo(large) < 0) {
            if (large.mod(start).equals(new BigInteger("0"))) {
                large = large.divide(start);
                if(Util.isPrime(large)){
                    System.out.print(large);
                    return;
                }
            }
            start = start.add(new BigInteger("1"));
        }
        System.out.print("not found");
    }

}
