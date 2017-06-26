import java.util.HashMap;
import java.util.Map;

/**
 * https://projecteuler.net/problem=14
 */
public class P014 implements Problem {

    public static void main(String args[]) {
        System.out.println(new P014().solve());
    }

    @Override
    public String solve() {
        Map<Long, Long> visited = new HashMap<>();
        long max = 0;
        long maxPath = 0;
        for (int i = 1; i < 1000000; i++) {
            long pathLength = 1;
            long curr = i;
            while (curr != 1) {
                if (visited.containsKey(curr)) {
                    pathLength += visited.get(curr);
                    break;
                }
                if (curr % 2 == 0) {
                    curr /= 2;
                } else {
                    curr = 3 * curr + 1;
                }
                pathLength++;
            }

            visited.put(curr, pathLength);

            if (pathLength > maxPath) {
                maxPath = pathLength;
                max = i;
            }
        }
        return Long.toString(max);
    }
}
