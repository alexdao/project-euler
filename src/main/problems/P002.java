package problems;

/**
 * https://projecteuler.net/problem=2
 */
public class P002 implements Problem{

    public static void main(String args[]) {
        System.out.println(new P002().solve());
    }

    @Override
    public String solve() {
        int f1 = 1;
        int f2 = 2;
        int total = f2;
        while (f2 < 4000000) {
            int next = f1 + f2;
            if (next % 2 == 0) {
                total += next;
            }
            f1 = f2;
            f2 = next;
        }
        return Integer.toString(total);
    }
}
