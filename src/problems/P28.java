package problems;

/**
 * Created by alex on 11/14/16.
 * Problem: https://projecteuler.net/problem=28
 */
public class P28 {

    public static void main(String args[]) {
        double sum = 1;
        double incrementer = 0;
        double curr = 1;

        for(int j=1; j<= 500; j++) {
            // update incrementer bc there is one extra row/col
            incrementer += 2;

            // add curr number for each diagonal
            for (int i = 0; i <= 3; i++) {
                curr += incrementer;
                sum += curr;
            }
        }

        System.out.println(sum);
    }
}
