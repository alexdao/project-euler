public class P037 implements Problem {

    public static void main(String args[]) {
        System.out.println(new P037().solve());
    }

    @Override
    public String solve() {
        int i = 11;
        int sum = 0;
        int count = 0;
        while (i < Integer.MAX_VALUE && count < 11) {
            if (Util.isPrime(i)) {
                if (checkTruncations(i)) {
                    count++;
                    sum += i;
                }
            }
            i++;
        }

        return Integer.toString(sum);
    }

    private static boolean checkTruncations(int n) {
        String num = Integer.toString(n);

        for (int i = 1; i < num.length(); i++) {
            if (!Util.isPrime(Integer.parseInt(num.substring(i)))) {
                return false;
            }
            if (!Util.isPrime(Integer.parseInt(num.substring(0,i)))) {
                return false;
            }
        }
        return true;
    }
}
