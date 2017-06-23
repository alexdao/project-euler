package problems;

import java.math.BigInteger;

/**
 * Created by alex on 5/11/16.
 */
public class P25 {

    public static void main(String args[]){
        BigInteger f1 = new BigInteger("1");
        BigInteger f2 = new BigInteger("1");
        int f2Index = 2;
        while(!checkLen(f2)){
            BigInteger temp = f1.add(f2);
            f1 = f2;
            f2 = temp;
            f2Index++;
        }
        System.out.print(f2Index);
    }

    private static boolean checkLen(BigInteger f2){
        String f2String = f2.toString();
        if(f2String.length() == 1000){
            return true;
        }
        return false;
    }
}
