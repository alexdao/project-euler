public class P047 implements Problem {

    public static void main(String args[]) {
        System.out.println(new P047().solve());
    }

    @Override
    public String solve() {
        int i = 648;
        int count = 0;
        while (true) {
            if (Util.getPrimeFactorization(i).size() == 4) {
                count++;
            } else {
                count = 0;
            }
            if (count == 4) {
                return Integer.toString(i - 3);
            }
            i++;
        }
    }
}
