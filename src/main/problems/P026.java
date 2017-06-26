/**
 * Problem: https://projecteuler.net/problem=26
 */
public class P026 implements Problem {

    public static void main(String args[]) {
        System.out.println(new P026().solve());
    }

    @Override
    public String solve() {
        int max = 0;

        for (int i = 999; i >= 2; i--) {
            if (max > i) {
                break;
            }

            int[] foundRemainders = new int[i];
            int value = 1;
            int position = 0;

            while (foundRemainders[value] == 0 && value != 0) {
                foundRemainders[value] = position;
                value *= 10;
                value %= i;
                position++;
            }

            max = Math.max(position, max);
        }

        return Integer.toString(max);
    }
}
