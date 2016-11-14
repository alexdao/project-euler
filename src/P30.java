/**
 * Created by alex on 11/14/16.
 * Problem: https://projecteuler.net/problem=30
 */
public class P30 {

    public static void main(String args[]) {
        P30 p30 = new P30();
        p30.solve();
    }

    public void solve() {
        int sum = 0;
        for(int i=2; i<= 999999; i++) {
            if(isSumOfFifthPower(i)) {
                sum += i;
            }
        }
        System.out.println(sum);
    }

    // Max that the number can be is a 6 digit number
    public static boolean isSumOfFifthPower(int num) {
        int sum = 0;
        int temp = num;
        while(temp != 0) {
            int curr = temp % 10;
            temp /= 10;
            sum += Math.pow(curr, 5);
        }
        return sum == num;
    }
}
