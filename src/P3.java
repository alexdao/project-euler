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
                if(isPrime(large)){
                    System.out.print(large);
                    return;
                }
            }
            start = start.add(new BigInteger("1"));
        }
        System.out.print("not found");
    }


    private static boolean isPrime(BigInteger n) {
        if (n.compareTo(new BigInteger("1")) < 0)
            return false;
        else if (n.compareTo(new BigInteger("3")) <= 0)
            return true;
        else if (n.mod(new BigInteger("2")).equals(new BigInteger("0")) || n.mod(new BigInteger("3")).equals(new BigInteger("0")))
            return false;
        BigInteger i = new BigInteger("5");
        while (i.multiply(i).compareTo(n) <= 0) {
            if (n.mod(i).equals(new BigInteger("0")) || n.mod(i.add(new BigInteger("2"))).equals(new BigInteger("0"))) {
                return false;
            }
            i = i.add(new BigInteger("6"));
        }
        return true;
    }
}
