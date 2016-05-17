import java.math.BigInteger;

/**
 * Created by alex on 5/13/16.
 */
public class P20 {

    public static void main(String args[]){
        int num = 100;
        BigInteger total = new BigInteger("1");
        while(num > 1){
            total = total.multiply(new BigInteger("" + num));
            num--;
        }
        String factorial = total.toString();
        int sum = 0;
        for(int i=0; i<factorial.length(); i++){
            sum += Integer.parseInt(factorial.substring(i, i+1));
        }
        System.out.print(sum);
    }
}
