/*
 * Best Time to Buy and Sell Stock III
 */
public class Solution45 {
	public int maxProfit(int[] prices) {
		int[] nums = new int[3];
		if (prices.length > 0) {
			maxProfit(prices, 0, prices.length-1, nums);
			for (int i = nums[0]; i <= nums[1]+1; i++)
				nums[2] = Math.max(nums[2], maxProfit(prices, 0, i-1, nums)+maxProfit(prices, i, prices.length-1, nums));
		}
		return nums[2];
	}
	
	public int maxProfit(int[] prices, int begin, int end, int[] nums) {
		if (begin > end) return 0;
		nums[0] = begin;
		int sum = 0;
		int min = begin;
		for (int i = begin+1; i <= end; i++) {
			if (prices[i] > prices[min] && prices[i]-prices[min] > sum) {
				sum = prices[i] - prices[min];
				nums[1] = i;
				nums[0] = min;
			}
			if (prices[i] < prices[min])
				min = i;
		}
		nums[2] = Math.max(sum, nums[2]);
		return sum;
	}
	
	public static void main(String ...args) {
		Solution45 s45 = new Solution45();
		int[] prices = {2,1,2,0,1};
		System.out.println(s45.maxProfit(prices));
		
	}
}
