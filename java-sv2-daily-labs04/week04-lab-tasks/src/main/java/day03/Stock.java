package day03;

import java.util.Arrays;
import java.util.List;

public class Stock {

    private List<Double> prices;

    public Stock(List<Double> prices) {
        this.prices = prices;
    }

    private double maxProfit() {
        double lowestPrice = prices.get(0);
        double maxProfit = 0.;
        for (double priceOnDay : prices) {
            double profit;
            if (priceOnDay > lowestPrice) {
                profit = priceOnDay - lowestPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            } else {
                lowestPrice = priceOnDay;
            }
        }
        return maxProfit;

    }

    public static void main(String[] args) {
        Stock stock = new Stock(Arrays.asList(1.23, 4.35, 0.23, 4.0, 8.4));
        System.out.println(stock.maxProfit());  //8.17

        Stock stock2 = new Stock(Arrays.asList(12.0, 2.0, 8.0, 4.0));
        System.out.println(stock2.maxProfit()); //6.0

        Stock stock3 = new Stock(Arrays.asList(2.0, 2.0, 1.0, 0.4));
        System.out.println(stock3.maxProfit()); //0.0

    }

}
