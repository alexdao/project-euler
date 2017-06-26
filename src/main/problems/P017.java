/**
 * https://projecteuler.net/problem=17
 */
public class P017 implements Problem {

    public static void main(String args[]) {
        System.out.println(new P017().solve());
    }

    private static int countLetters(int n) {
        if (n > 999) {
            return 11;
        } else if (n > 99) {
            int hundreds = n / 100;
            if (n % 100 == 0) {
                return countBase(hundreds) + 7;
            } else {
                return countBase(hundreds) + 10 + countLetters(n % 100);
            }
        } else if (n > 20) {
            if (n % 10 == 0) {
                return countBase(n);
            } else {
                //39
                int remainder = n % 10; //9
                int base = n - remainder; //30
                return countBase(base) + countBase(remainder);
            }
        } else {
            return countBase(n);
        }
    }

    private static int countBase(int n) {
        if (n == 1) {
            return 3;
        } else if (n == 2) {
            return 3;
        } else if (n == 3) {
            return 5;
        } else if (n == 4) {
            return 4;
        } else if (n == 5) {
            return 4;
        } else if (n == 6) {
            return 3;
        } else if (n == 7) {
            return 5;
        } else if (n == 8) {
            return 5;
        } else if (n == 9) {
            return 4;
        } else if (n == 10) {
            return 3;
        } else if (n == 11) {
            return 6;
        } else if (n == 12) {
            return 6;
        } else if (n == 13) {
            return 8;
        } else if (n == 14) {
            return 8;
        } else if (n == 15) {
            return 7;
        } else if (n == 16) {
            return 7;
        } else if (n == 17) {
            return 9;
        } else if (n == 18) {
            return 8;
        } else if (n == 19) {
            return 8;
        } else if (n == 20) {
            return 6;
        } else if (n == 30) {
            return 6;
        } else if (n == 40) {
            return 5;
        } else if (n == 50) {
            return 5;
        } else if (n == 60) {
            return 5;
        } else if (n == 70) {
            return 7;
        } else if (n == 80) {
            return 6;
        } else if (n == 90) {
            return 6;
        } else if (n == 0) {
            return 0;
        } else {
            System.out.println("error");
            return -1;
        }
    }

    @Override
    public String solve() {
        int total = 0;
        for (int i = 1; i <= 1000; i++) {
            int count = countLetters(i);
            total += count;
        }
        return Integer.toString(total);
    }
}
