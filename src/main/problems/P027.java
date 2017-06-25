package problems;

import util.Util;

import java.math.BigInteger;

/**
 * Created by alex on 6/22/17.
 */
public class P027 {

    public static void main(String args[]) {
        int maxConsecutivePrimes = 0;
        int maxA = 0;
        int maxB = 0;
        for (int a = -999; a <= 999; a++) {
            for (int b = -999; b <= 1000; b++) {
                int currMax = calcNumOfConsecutivePrimes(a, b);
                if (currMax > maxConsecutivePrimes) {
                    maxConsecutivePrimes = currMax;
                    maxA = a;
                    maxB = b;
                }
            }
        }

        System.out.println(maxA * maxB);
    }

    private static int calcNumOfConsecutivePrimes(int a, int b) {
        int counter = 0;
        while (true) {
            int quadraticRes = calcQuadratic(a, b, counter);
            if (!Util.isPrime(new BigInteger("" + quadraticRes))) {
                break;
            }
            counter++;
        }
        return counter;
    }

    private static int calcQuadratic(int a, int b, int n) {
        return n * n + a * n + b;
    }

}
