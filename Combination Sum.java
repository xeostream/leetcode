/*
Given a set of candidate numbers (C) and a target number (T ), find all unique combinations in C where
the candidate numbers sums to T .
The same repeated number may be chosen from C unlimited number of times.
Note:
• All numbers (including target) will be positive integers.
• Elements in a combination (a1; a2; ...; ak) must be in non-descending order. (ie, a1 > a2 > ... > ak).
• The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, A solution set is:
[7]
[2, 2, 3]
*/

public class Solution {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> rst = new ArrayList<List<Integer>>();
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		combinationSum(rst, tmp, candidates, 0, target);
		/*for (int i = 0; i < nums.length; i++) {
			if (target >= nums[i]) {
				tmp.add(nums[i]);
				combinationSum(rst, tmp, nums, i, target-nums[i]);
			} else {
				break;
			}
		}*/
		return rst;
	}
	private void combinationSum(List<List<Integer>> rst, ArrayList<Integer> tmp, int[] nums, int start, int target) {
		if (target == 0) {
			ArrayList<Integer> list = new ArrayList<Integer>(tmp);
			rst.add(list);
		}
		for (int i = start; i < nums.length; i++) {
			if (target >= nums[i]) {
				ArrayList<Integer> array = new ArrayList<Integer>(tmp);
				array.add(nums[i]);
				combinationSum(rst, array, nums, i, target-nums[i]);
			} else {
				break;
			}
		}
	}
}