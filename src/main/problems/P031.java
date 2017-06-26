/**
 * Problem: https://projecteuler.net/problem=31
 */
public class P031 implements Problem {

    public static void main(String args[]) {
        System.out.println(new P031().solve());
    }

    @Override
    public String solve() {
        int sum = 200;
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};
        int[] combos = new int[sum + 1];

        //base case
        combos[0] = 1;
        //1-dimensional dp
        for (int coin : coins) {
            for (int j = coin; j <= sum; j++) {
                combos[j] += combos[j - coin];
            }
        }

        return Integer.toString(combos[sum]);
    }
}
