import java.util.HashSet;
import java.util.Set;

public class P046 implements Problem {

    public static void main(String args[]) {
        System.out.println(new P046().solve());
    }

    @Override
    public String solve() {
        Set<Integer> primes = new HashSet<>();
        int curr = 2;
        while (true) {
            if (Util.isPrime(curr)) {
                primes.add(curr);
            }
            if (curr % 2 != 0) {
                boolean sumFound = false;
                for (Integer prime : primes) {
                    double square = (curr - prime) / 2.0;
                    if (Math.sqrt(square) == Math.floor(Math.sqrt(square))) {
                        sumFound = true;
                        break;
                    }
                }
                if (!sumFound) {
                    return Integer.toString(curr);
                }
            }
            curr++;
        }
    }
}
