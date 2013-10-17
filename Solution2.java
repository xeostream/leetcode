/*
 * twoSum
 */

public class Solution2 {
	public int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		for (int i = 0; i < numbers.length; i++)
			for (int j = i+1; j < numbers.length; j++) {
				if (numbers[i] + numbers[j] == target) {
					result[0] = i+1;
					result[1] = j+1;
				}
			}
		return result;
	}
	public static void main(String ...args) {
		Solution2 s2 = new Solution2();
		int[] numbers = {2,7,11,13};
		int[] result = s2.twoSum(numbers, 9);
		for (int r : result)
			System.out.print(r + " ");
	}
}
