/**
 * https://projecteuler.net/problem=6
 */
public class P006 implements Problem{

    public static void main(String args[]) {
        System.out.println(new P006().solve());
    }

    @Override
    public String solve() {
        long sumOfSquares = 0;
        long squareOfSum = 0;
        for (int i = 1; i <= 100; i++) {
            sumOfSquares += i * i;
            squareOfSum += i;
        }
        squareOfSum *= squareOfSum;
        return Long.toString(squareOfSum - sumOfSquares);
    }
}
