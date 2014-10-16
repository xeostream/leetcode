/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},
    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
*/

public class Solution {
	public List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> rst = new ArrayList<List<Integer>>();
		Arrays.sort(num);
		for (int i = 0; i < num.length-2; i++) {
			int m = i + 1, n = num.length-1;
			while (m < n) {
				int sum = num[i] + num[m] + num[n];
				if (sum == 0) {
					List<Integer> list = new ArrayList<Integer>();
					list.add(num[i]);
					list.add(num[m]);
					list.add(num[n]);
					rst.add(list);
					m++;
				} else if (sum > 0) {
					n--;
				} else {
					m++;
				}
			}
		}
		Set<List<Integer>> set = new HashSet<Integer>(rst);
		rst.clear();
		rst.addAll(set);
		return rst;
	}
}