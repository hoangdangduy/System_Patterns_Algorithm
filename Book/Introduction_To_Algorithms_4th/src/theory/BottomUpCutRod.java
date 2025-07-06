package theory;

import java.util.HashMap;
import java.util.Map;

public class BottomUpCutRod {
    private Map<Integer, Integer> prices = new HashMap<>();

    private void initPrice() {
        prices.put(1, 1);
        prices.put(2, 5);
        prices.put(3, 8);
        prices.put(4, 9);
        prices.put(5, 10);
        prices.put(6, 17);
        prices.put(7, 17);
        prices.put(8, 20);
        prices.put(9, 24);
        prices.put(10, 30);
//        prices.put(1, 2);
//        prices.put(2, 5);
//        prices.put(3, 7);
//        prices.put(4, 8);
    }

    private BestRevenue bottomUpCutRod(int n) {
        int[] r = new int[n+1];
        int[] s = new int[n+1];

        for (int i = 1; i <= n; i++) {
            int q = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++) {
                if (q < prices.get(j) + r[i-j]) {
                    q = prices.get(j) + r[i-j];
                    s[i] = j;
                }
            }
            r[i] = q;
        }

        return new BestRevenue(r, s);
    }

    private void printCutRodSolution(int n) {
        var bestRevenue = bottomUpCutRod(n);
        System.out.println("Best revenue for rod length " + n + " is: " + bestRevenue.getRevenue()[n]);
        while (n > 0) {
            System.out.println("Cut rod of length " + bestRevenue.getLength()[n]);
            n -= bestRevenue.getLength()[n];
        }
        System.out.println("Done");
    }

    public static void main(String[] args) {
        BottomUpCutRod bottomUpCutRod = new BottomUpCutRod();
        bottomUpCutRod.initPrice();
        bottomUpCutRod.printCutRodSolution(4);
    }

    private static class BestRevenue {
        private final int[] revenue;
        private final int[] length;

        public BestRevenue(int[] revenue, int[] length) {
            this.revenue = revenue;
            this.length = length;
        }

        public int[] getRevenue() {
            return revenue;
        }

        public int[] getLength() {
            return length;
        }
    }
}
