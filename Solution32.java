/*
 * Candy
 * There are N children standing in a line.Each child is assigned a rating value
 * Each child must have at least one candy
 * Children with a higher rating get more candies than their neighbors
 */
public class Solution32 {
	public int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0)
			return 0;
		int len = ratings.length;
		int sum = 0;
		int[] cnt = new int[len];
		for (int i = 0; i < len; i++)
			cnt[i] = 1;
		for (int i = 1; i < len; i++)
			if (ratings[i] > ratings[i-1])
				cnt[i] = cnt[i-1] + 1;
		for (int i = len - 1; i > 0; i--)
			if (ratings[i] < ratings[i-1] && cnt[i-1] <= cnt[i])
				cnt[i-1] = cnt[i] + 1;
		for (int i : cnt)
			sum += i;
		return sum;
	}
	
	public static void main(String ...args) {
		Solution32 s32 = new Solution32();
		int[] ratings = {1,2,2,1};
		System.out.println(s32.candy(ratings));
	}
}
