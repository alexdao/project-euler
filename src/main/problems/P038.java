/**
 * 987654321 is the largest 1 to 9 pandigital number, so we don't need to consider anything past this.
 */
public class P038 implements Problem {

    private static final int UPPER_LIMIT = 987654321;

    public static void main(String args[]) {
        System.out.println(new P038().solve());
    }

    @Override
    public String solve() {
        int curr = 1;
        int max = 0;
        while (true) {
            if (this.overLimit(curr)) {
                break;
            }
            int newPandigital = this.findConcatProduct(curr);
            if (newPandigital > max) {
                max = newPandigital;
            }
            curr++;
        }
        return Integer.toString(max);
    }

    /**
     * Return -1 if it cannot find a pandigital concatenated product
     */
    private int findConcatProduct(int n) {
        String concat = Integer.toString(n);
        int counter = 2;
        while (Integer.parseInt(concat) < UPPER_LIMIT) {
            int newMultipleToConcat = n * counter;
            concat += newMultipleToConcat;
            if (concat.length() > 9) {
                return -1;
            }
            if (Util.isPandigital(Integer.parseInt(concat))) {
                return Integer.parseInt(concat);
            }
            counter++;
        }
        return -1;
    }

    private boolean overLimit(int n) {
        int doubleN = n * 2;
        String concat = Integer.toString(n) + Integer.toString(doubleN);
        return Integer.parseInt(concat) > UPPER_LIMIT;
    }

}
