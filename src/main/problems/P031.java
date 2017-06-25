package problems;

/**
 * Created by alex on 9/11/16.
 * Problem: https://projecteuler.net/problem=31
 */
public class P031 {

    public static void main(String args[]) {
        int sum = 200;
        int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};
        int[] combos = new int[sum + 1];

        //base case
        combos[0] = 1;
        //1-dimensional dp
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= sum; j++) {
                combos[j] += combos[j - coins[i]];
            }
        }

        System.out.println(combos[sum]);
    }

}
