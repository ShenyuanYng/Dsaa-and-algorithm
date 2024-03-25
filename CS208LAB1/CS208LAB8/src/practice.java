import java.util.Scanner;

public class practice {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        String[] pricesStr = input.split(" ");

        // 将字符串数组转换为整数数组
        int[] prices = new int[pricesStr.length];
        for (int i = 0; i < pricesStr.length; i++) {
            prices[i] = Integer.parseInt(pricesStr[i]);
        }

        int[] result = findBestBuySellDays(prices);

        System.out.println(result[0]);
        System.out.println( result[1]);
        int maxProfit = prices[result[1]] - prices[result[0]];
        System.out.println( maxProfit);
        scanner.close();
    }
    public static int[] findBestBuySellDays(int[] prices) {
        int n = prices.length;
        int[] result = new int[2];

        if (n < 2) {
            // 价格数据太少，无法进行交易
            return result;
        }

        int minPrice = prices[0];
        int maxProfit = 0;
        int buyDay = 0;
        int sellDay = 0;

        for (int i = 1; i < n; i++) {
            int currentPrice = prices[i];

            if (currentPrice < minPrice) {
                // 当前价格比最低价格还低，更新最低价格和买入日期
                minPrice = currentPrice;
                buyDay = i;
            } else {
                // 计算当前价格卖出时的利润
                int currentProfit = currentPrice - minPrice;

                // 如果当前利润大于之前记录的最大利润，更新最大利润和卖出日期
                if (currentProfit > maxProfit) {
                    maxProfit = currentProfit;
                    sellDay = i;
                }
            }
        }

        result[0] = buyDay;
        result[1] = sellDay;

        return result;
    }
}