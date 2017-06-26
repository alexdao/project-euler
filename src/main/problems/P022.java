import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

/**
 * https://projecteuler.net/problem=22
 */
public class P022 implements Problem {

    public static void main(String args[]) {
        System.out.println(new P022().solve());
    }

    @Override
    public String solve() {
        try {
            Scanner in = new Scanner(new FileReader("data/p022_data.txt"));
            String longString = in.next();
            List<String> names = Arrays.asList(longString.split(","));
            List<String> rawNames = new ArrayList<>();
            for (String name : names) {
                rawNames.add(name.substring(1, name.length() - 1));
            }
            Collections.sort(rawNames);

            List<String> processedNames = new ArrayList<>();
            for (String name : rawNames) {
                processedNames.add(name.toLowerCase());
            }

            long score = 0;
            for (int j = 0; j < processedNames.size(); j++) {
                String name = processedNames.get(j);
                long letterScore = 0;
                for (int i = 0; i < name.length(); i++) {
                    letterScore += name.charAt(i) - 96;
                }
                score += letterScore * (j + 1);
            }

            in.close();
            return Long.toString(score);
        } catch (FileNotFoundException e) {
            return e.toString();
        }
    }
}
