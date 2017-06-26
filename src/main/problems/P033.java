import java.util.ArrayList;
import java.util.List;

public class P033 implements Problem {

    public static void main(String args[]) {
        System.out.println(new P033().solve());
    }

    @Override
    public String solve() {
        List<BadFraction> fractions = new ArrayList<>();
        for (int i = 10; i < 99; i++) {
            for (int j = i + 1; j <= 99; j++) {
                // Skip over trivial examples
                if (i % 10 == 0 && j % 10 == 0) {
                    continue;
                }

                BadFraction curr = new BadFraction(i, j);
                if (curr.badSimplify()) {
                    if ((double) i / j == (double) curr.getNumerator() / curr.getDenominator()) {
                        fractions.add(curr);
                    }
                }
            }
        }

        int numerator = 1;
        int denominator = 1;
        for (Util.Fraction fraction : fractions) {
            numerator *= fraction.getNumerator();
            denominator *= fraction.getDenominator();
        }

        Util.Fraction outputFraction = new Util.Fraction(numerator, denominator);
        outputFraction.simplifyFraction();
        return Integer.toString(outputFraction.getDenominator());
    }

    private class BadFraction extends Util.Fraction {

        BadFraction(int numerator, int denominator) {
            super(numerator, denominator);
        }

        boolean badSimplify() {
            String numString = Integer.toString(numerator);
            String denomString = Integer.toString(denominator);
            if (numString.charAt(0) == denomString.charAt(0)) {
                numerator = Integer.parseInt(numString.substring(1));
                denominator = Integer.parseInt(denomString.substring(1));
                return denominator != 0;
            } else if (numString.charAt(0) == denomString.charAt(1)) {
                numerator = Integer.parseInt(numString.substring(1));
                denominator = Integer.parseInt(denomString.substring(0, 1));
                return denominator != 0;
            } else if (numString.charAt(1) == denomString.charAt(0)) {
                numerator = Integer.parseInt(numString.substring(0, 1));
                denominator = Integer.parseInt(denomString.substring(1));
                return denominator != 0;
            } else if (numString.charAt(1) == denomString.charAt(1)) {
                numerator = Integer.parseInt(numString.substring(0, 1));
                denominator = Integer.parseInt(denomString.substring(0, 1));
                return denominator != 0;
            }
            return false;
        }
    }
}
