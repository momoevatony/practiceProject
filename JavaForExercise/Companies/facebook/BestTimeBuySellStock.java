package facebook;

public class BestTimeBuySellStock {
	
	//accepted 5.12.2017 1515ms
	public int maxProfit(int[] prices) {
        // write your code here
		int result = 0;
		int currMin = Integer.MAX_VALUE;
		
		for (int price : prices) {
			if (price < currMin) {
				currMin = price;
			}
			result = result > (price - currMin) ? result : (price - currMin);
		}
		
		return result;
    }
}
