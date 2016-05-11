/**
 * Created by alex on 5/10/16.
 */
public class P2 {

    public static void main(String args[]) {
        int f1 = 1;
        int f2 = 2;
        int total = f2;
        while (f2 < 4000000) {
            int next = f1 + f2;
            if (next % 2 == 0) {
                total += next;
            }
            f1 = f2;
            f2 = next;
        }
        System.out.print(total);
    }
}
