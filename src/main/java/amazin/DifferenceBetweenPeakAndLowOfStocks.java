package amazin;

import java.util.ArrayList;
import java.util.Arrays;

// Series of stock prices, determine when to buy and when to sell
//
public class DifferenceBetweenPeakAndLowOfStocks {
    public static void main(String[] args) {
        ArrayList<Integer> stockPricesList = new ArrayList<Integer>(Arrays.asList(9,2,0,11,8,12,19,99,2000));
        stockPricesList.add(-5);
        int minPrice = 0, maxPrice = 0;

        for(int price : stockPricesList){
            if(price<=minPrice) {
                minPrice = price;
            }else{
                maxPrice = price;
            }
        }
        System.out.println(minPrice +" , "+maxPrice);

    }


}
