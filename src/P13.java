import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by alex on 5/12/16.
 */
public class P13 {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        List<BigInteger> nums = new ArrayList<>();
        for(int i=0; i<100; i++){
            nums.add(new BigInteger(in.nextLine()));
        }
        BigInteger total = new BigInteger("0");
        for(BigInteger i: nums){
            total = total.add(i);
        }
        System.out.print(total.toString().substring(0, 10));
    }
}
