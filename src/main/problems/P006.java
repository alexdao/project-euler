package problems;

/**
 * Created by alex on 5/10/16.
 */
public class P006 {

    public static void main(String args[]) {
        long sumOfSquares = 0;
        long squareOfSum = 0;
        for (int i = 1; i <= 100; i++) {
            sumOfSquares += i * i;
            squareOfSum += i;
        }
        squareOfSum *= squareOfSum;
        System.out.print(squareOfSum - sumOfSquares);
    }
}
