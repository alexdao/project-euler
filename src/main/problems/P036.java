package problems;

import util.Util;

/**
 * https://projecteuler.net/problem=36
 */

public class P036 {

    public static void main(String args[]) {
        long sum = 0L;
        for(int i=1; i<=1000000; i++) {
            String binaryString = Integer.toBinaryString(i);
            if(Util.isPalindrone(i) && Util.isPalindrone(binaryString)) {
                sum += i;
            }
        }
        System.out.println(sum);
    }
}
