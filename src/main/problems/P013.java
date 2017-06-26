import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://projecteuler.net/problem=13
 */
public class P013 implements Problem {

    public static void main(String args[]) {
        System.out.println(new P013().solve());
    }

    @Override
    public String solve() {
        try {
            Scanner in = new Scanner(new FileReader("data/p013_data.txt"));
            List<BigInteger> nums = new ArrayList<>();
            for (int i = 0; i < 100; i++) {
                nums.add(new BigInteger(in.nextLine()));
            }
            BigInteger total = new BigInteger("0");
            for (BigInteger i : nums) {
                total = total.add(i);
            }
            in.close();
            return total.toString().substring(0, 10);
        } catch (FileNotFoundException e) {
            return e.toString();
        }

    }
}
