import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class P042 implements Problem {

    public static void main(String args[]) {
        System.out.println(new P042().solve());
    }

    @Override
    public String solve() {
        try {
            Scanner in = new Scanner(new FileReader("data/p042_data.txt"));
            String longString = in.next();
            List<String> words = Arrays.asList(longString.split(","));
            List<String> trimmedWords = new ArrayList<>();

            int maxLength = 0;
            for (String word : words) {
                String trimmedWord = word.substring(1, word.length() - 1);
                maxLength = Math.max(trimmedWord.length(), maxLength);
                trimmedWords.add(trimmedWord);
            }

            Set<Integer> triangleNumbers = this.calculateTriangleNumbers(maxLength * 26);

            int numOfTriangleWords = 0;
            for (String word : trimmedWords) {
                if (isTriangleWord(word, triangleNumbers)) {
                    numOfTriangleWords++;
                }
            }
            return Integer.toString(numOfTriangleWords);
        } catch (FileNotFoundException e) {
            return e.toString();
        }
    }

    private boolean isTriangleWord(String word, Set<Integer> triangleNumbers) {
        int wordValue = 0;
        for (int i = 0; i < word.length(); i++) {
            wordValue += word.charAt(i) - 64;
        }
        return triangleNumbers.contains(wordValue);
    }

    private Set<Integer> calculateTriangleNumbers(int max) {
        Set<Integer> triangleNumbers = new HashSet<>();
        int currTriangleNum = 1;
        int i = 1;
        while (currTriangleNum <= max) {
            currTriangleNum = (i * (i + 1)) / 2;
            triangleNumbers.add(currTriangleNum);
            i++;
        }
        return triangleNumbers;
    }

}
