public class practice {
    public static int maximizeRevenue(int[] prices, int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int maxRevenue = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++) {
                maxRevenue = Math.max(maxRevenue, prices[j - 1] + dp[i - j]);
            }
            dp[i] = maxRevenue;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20,24,30};
        int rodLength = 10;

        int optimalRevenue = maximizeRevenue(prices, rodLength);
        System.out.println( optimalRevenue);
    }
}
