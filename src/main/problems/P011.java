import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * https://projecteuler.net/problem=11
 */
public class P011 implements Problem {

    public static void main(String args[]) {
        System.out.println(new P011().solve());
    }

    @Override
    public String solve() {
        try {
            Scanner in = new Scanner(new FileReader("data/p011_data.txt"));
            long[][] nums = new long[20][20];
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    nums[i][j] = in.nextLong();
                }
            }

            long max = 0;
            for (int j = 0; j < 20; j++) {
                for (int i = 0; i < 17; i++) {
                    long curr = nums[i][j] * nums[i + 1][j] * nums[i + 2][j] * nums[i + 3][j];
                    if (curr > max) {
                        max = curr;
                    }
                }
            }

            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 17; j++) {
                    long curr = nums[i][j] * nums[i][j + 1] * nums[i][j + 2] * nums[i][j + 3];
                    if (curr > max) {
                        max = curr;
                    }
                }
            }

            for (int i = 0; i < 17; i++) {
                for (int j = 0; j < 17; j++) {
                    long curr = nums[i][j] * nums[i + 1][j + 1] * nums[i + 2][j + 2] * nums[i + 3][j + 3];
                    if (curr > max) {
                        max = curr;
                    }
                }
            }

            for (int i = 19; i > 2; i--) {
                for (int j = 0; j < 17; j++) {
                    long curr = nums[i][j] * nums[i - 1][j + 1] * nums[i - 2][j + 2] * nums[i - 3][j + 3];
                    if (curr > max) {
                        max = curr;
                    }
                }
            }
            in.close();
            return Long.toString(max);
        } catch (IOException e) {
            return e.toString();
        }
    }
}
