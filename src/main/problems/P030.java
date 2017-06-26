/**
 * Problem: https://projecteuler.net/problem=30
 */
public class P030 implements Problem {

    public static void main(String args[]) {
        System.out.println(new P030().solve());
    }

    @Override
    public String solve() {
        int sum = 0;
        for (int i = 2; i <= 999999; i++) {
            if (isSumOfFifthPower(i)) {
                sum += i;
            }
        }
        return Integer.toString(sum);
    }

    // Max that the number can be is a 6 digit number
    private static boolean isSumOfFifthPower(int num) {
        int sum = 0;
        int temp = num;
        while (temp != 0) {
            int curr = temp % 10;
            temp /= 10;
            sum += Math.pow(curr, 5);
        }
        return sum == num;
    }
}
