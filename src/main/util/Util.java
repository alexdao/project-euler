import java.math.BigInteger;

/**
 * Common functions for Project Euler problems
 */
public class Util {

    static boolean isPrime(BigInteger n) {
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

    static boolean isPrime(int n){
        if(n <= 1)
            return false;
        else if (n<=3)
            return true;
        else if (n % 2 == 0 || n % 3 == 0)
            return false;
        int i = 5;
        while(i*i <= n){
            if(n%i == 0 || n % (i+2)== 0){
                return false;
            }
            i += 6;
        }
        return true;
    }

    static boolean isPalindrone(String s) {
        for(int i=0; i<=s.length()/2; i++) {
            if(s.charAt(i) != s.charAt(s.length()-i-1)) {
                return false;
            }
        }
        return true;
    }

    static boolean isPalindrone(int i) {
        String s = "" + i;
        return isPalindrone(s);
    }

    static long calcFactorial(long n) {
        long sum = 1;
        for (long i = 1; i <= n; i++) {
            sum *= i;

        }
        return sum;
    }

    public static void main (String args[]) {
        String s = "1234321";
        System.out.println(isPalindrone(s));
    }
}
