import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * https://projecteuler.net/problem=18
 */
public class P018 implements Problem {

    private static List<List<Integer>> tree = new ArrayList<>();

    public static void main(String args[]) {
        System.out.println(new P018().solve());
    }

    private static int calcMaxPath(int line, int index) {
        if (line == 14) {
            return tree.get(line).get(index);
        }
        return tree.get(line).get(index) + Math.max(calcMaxPath(line + 1, index), calcMaxPath(line + 1, index + 1));
    }

    @Override
    public String solve() {
        try {
            Scanner in = new Scanner(new FileReader("data/p018_data.txt"));
            int count = 1;
            int lines = 15;
            for (int i = 0; i < lines; i++) {
                List<Integer> line = new ArrayList<>();
                for (int j = 0; j < count; j++) {
                    line.add(in.nextInt());
                }
                tree.add(line);
                count++;
            }
            in.close();
            return Integer.toString(calcMaxPath(0, 0));
        } catch (FileNotFoundException e) {
            return e.toString();
        }
    }
}
