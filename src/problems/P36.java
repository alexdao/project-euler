package problems;

import util.Util;

public class P36 {

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
