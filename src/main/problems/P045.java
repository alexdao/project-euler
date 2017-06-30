public class P045 implements Problem {

    public static void main(String args[]) {
        System.out.println(new P045().solve());
    }

    @Override
    public String solve() {
        long curr = 286;
        while (true) {
            long triangleNum = curr * (curr + 1) / 2;
            if (Util.isPentagonal(triangleNum) && Util.isHexagonal(triangleNum)) {
                return Long.toString(triangleNum);
            }
            curr++;
        }
    }
}
