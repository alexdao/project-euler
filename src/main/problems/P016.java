import java.math.BigInteger;

/**
 * https://projecteuler.net/problem=16
 */
public class P016 implements Problem{

    public static void main(String args[]){
        System.out.println(new P016().solve());
    }

    @Override
    public String solve() {
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
        return Long.toString(sum);
    }
}
