package problems;

/**
 * Created by alex on 5/10/16.
 */
public class P4 {

    public static void main(String args[]) {
        int maxProduct = 998002;
        while (maxProduct >= 10000) {
            maxProduct--;
            if (!isPalindrome(maxProduct)) {
                continue;
            }
            for (int i = 100; i < 999; i++) {
                int divisor = maxProduct / i;
                if (maxProduct % i == 0 && divisor >= 100 && divisor <= 999) {
                    System.out.print(maxProduct);
                    return;
                }
            }
        }
    }

    private static boolean isPalindrome(int num) {
        String numString = "" + num;
        for (int i = 0; i < numString.length() / 2; i++) {
            if (numString.charAt(i) != numString.charAt(numString.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
