import java.util.ArrayList;
import java.util.List;

/**
 * https://projecteuler.net/problem=24
 */
public class P024 implements Problem {

    public static void main(String args[]) {
        System.out.println(new P024().solve());
    }

    private static void permute(String prefix, String str, List<String> permutations) {
        int n = str.length();
        if (n == 0) {
            permutations.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                permute(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n), permutations);
            }
        }
    }

    @Override
    public String solve() {
        String num = "0123456789";
        List<String> permutations = new ArrayList<>();
        permute("", num, permutations);
        return permutations.get(1000000);
    }
}
