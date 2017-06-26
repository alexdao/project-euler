/**
 * https://projecteuler.net/problem=12
 */
public class P012 implements Problem {

    public static void main(String args[]) {
        System.out.println(new P012().solve());
    }

    private static int countDivisor(long num) {
        int count = 0;
        for (long i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                if (i * i == num)
                    count++;
                else
                    count += 2;

            }
        }
        return count;
    }

    @Override
    public String solve() {
        long triangleNum = 0;
        long addNum = 1;
        while (true) {
            triangleNum += addNum;
            if (countDivisor(triangleNum) > 500) {
                break;
            }
            addNum++;
        }
        return Long.toString(triangleNum);
    }
}
