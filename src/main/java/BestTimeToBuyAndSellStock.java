import java.util.Arrays;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }
        return maxProfit;
    }

    public int maxProfit2(int[] prices) {
        int maxProfit = 0;
        int minStockPrice = prices[0];

        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minStockPrice);
            minStockPrice = Math.min(minStockPrice, prices[i]);
        }
        return maxProfit;
    }

    public int maxProfit3(int[] prices) {
        Arrays.sort(prices);
        return prices[prices.length - 1] - prices[0];
    }

}
