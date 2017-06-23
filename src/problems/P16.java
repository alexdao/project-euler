package problems;

import java.math.BigInteger;

/**
 * Created by alex on 5/12/16.
 */
public class P16 {
    public static void main(String args[]){
        BigInteger two = new BigInteger("2");
        BigInteger curr = new BigInteger("2");
        for(int i=1; i<1000; i++){
            curr = curr.multiply(two);
        }
        long sum = 0;
        String bigNum = curr.toString();
        for(int i=0; i<bigNum.length(); i++){
            sum += Integer.parseInt(bigNum.substring(i, i+1));
        }
        System.out.print(sum);
    }
}
