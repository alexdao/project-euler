import java.util.ArrayList;

/**
 * Created by alex on 6/15/16.
 */
public class P24 {

    private static int count = 0;

    public static void main(String args[]) {
        String num = "0123456789";
        permute("", num);
    }

    private static void permute(String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            count++;
            if (count == 1000000) {
                System.out.println(prefix);
            }
        } else {
            for (int i = 0; i < n; i++) {
                permute(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
            }
        }
    }
}
