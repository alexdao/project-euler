public class P039 implements Problem {

    public static void main(String args[]) {
        System.out.println(new P039().solve());
    }

    @Override
    public String solve() {
        int max = 0;
        int maxP = 1;
        for (int i = 1; i <= 1000; i++) {
            int curr = this.findNumOfRightTriangles(i);
            if (curr > max) {
                max = curr;
                maxP = i;
            }
        }
        return Integer.toString(maxP);
    }

    /**
     * Finds number of different right triangles with perimeter p.
     * Let a be the smallest side of the right triangle.
     * We only need to consider length up to p/3 for a because of the triangle inequality.
     */
    private int findNumOfRightTriangles(int p) {
        int count = 0;
        int limit = p / 3;
        for (int a = 1; a <= limit; a++) {
            for (int b = a; b <= p; b++) {
                int c = p - a - b;
                if (a * a + b * b == c * c) {
                    count++;
                }
            }
        }
        return count;
    }
}
